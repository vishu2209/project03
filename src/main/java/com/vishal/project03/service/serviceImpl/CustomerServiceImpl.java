package com.vishal.project03.service.serviceImpl;

import org.springframework.stereotype.Service;
import com.vishal.project03.service.CustomerService;
import com.vishal.project03.enity.Customer;
import com.vishal.project03.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    

    @Override
    public Customer getById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateById(Long id, Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer updatedCustomer = existingCustomer.get();
            updatedCustomer.setOrgName(customer.getOrgName());
            updatedCustomer.setEstablishmentDate(customer.getEstablishmentDate());
            updatedCustomer.setUsers(customer.getUsers());
            return customerRepository.save(updatedCustomer);
        } else {
            return null;
        }
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}