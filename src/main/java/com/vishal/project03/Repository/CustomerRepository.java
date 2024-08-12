package com.vishal.project03.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vishal.project03.enity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}