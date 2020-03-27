package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Supplier;
import com.zktr.crmproject.service.HTSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HTSupplierController {
    @Autowired
    private HTSupplierService supplierService;

    @GetMapping("/queryAllSupplier")
    public List<Supplier> queryAllSupplier(){
        return supplierService.queryAllSupplier();
    }

}
