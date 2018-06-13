package com.aran.learn.web;


import com.aran.learn.service.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ServiceUnavailableException;

@RestController
public class InvoiceController {

    @Autowired
    Invoice invoice;

    @GetMapping("/invoice/{cost}")
    public Double getInvoice(@PathVariable(value = "cost") double cost) throws ServiceUnavailableException {
        return invoice.calculatePrice(cost);
    }
}
