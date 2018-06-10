package com.aran.learn.web;

import com.aran.learn.config.SalesTaxProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesTaxController {

    @Autowired
    SalesTaxProperties salesTaxProperties;

    @GetMapping("/tax/rate")
    public String getTaxRate() {
        return salesTaxProperties.getSalestax().toString();
    }

    @RequestMapping("/tax/{price}")
    public Double calculateTax(@PathVariable(value = "price") Double price) {
        return price * salesTaxProperties.getSalestax();
    }
}
