package com.aran.learn.web;


import com.aran.learn.service.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    @Autowired
    Invoice invoice;

    @GetMapping("/invoice/{zip}/{item}")
    public Double getInvoice(@PathVariable(value = "zip") int zip, @PathVariable(value ="item" ) String item){
        return Double.valueOf(0);
    }
}
