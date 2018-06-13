package com.aran.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.util.Optional;

@Service
public class Invoice {

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private DiscoveryClient discoveryClient;

    private Optional<URI> serviceURL() {
        return discoveryClient.getInstances("sales-tax-service")
                .stream().map(si -> si.getUri()).findFirst();
    }

    public Double calculatePrice(Double cost) throws ServiceUnavailableException {
        URI service = serviceURL().map(s -> s.resolve("/tax/rate")).orElseThrow(ServiceUnavailableException::new);
        ResponseEntity<Double> tax = restTemplate.getForEntity(service, Double.class);
        return cost + tax.getBody() * cost;
    }
}
