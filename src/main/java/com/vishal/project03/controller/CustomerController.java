package com.vishal.project03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vishal.project03.enity.Customer;
import com.vishal.project03.service.CustomerService;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/getById")
    public Customer getCustomerById(@RequestParam Long id) {
        return customerService.getById(id);
    }

    @PostMapping("/save")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateById(customer.getId(), customer);
    }

    @DeleteMapping("/deleteById")
    public void deleteCustomer(@RequestParam Long id) {
        customerService.deleteById(id);
    }
}