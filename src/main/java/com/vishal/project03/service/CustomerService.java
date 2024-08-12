package com.vishal.project03.service;

import com.vishal.project03.enity.Customer;
import java.util.List;

public interface CustomerService {
    Customer getById(Long id);
    Customer save(Customer customer);
    void deleteById(Long id);
    Customer updateById(Long id, Customer customer);
    List<Customer> getAll();
}