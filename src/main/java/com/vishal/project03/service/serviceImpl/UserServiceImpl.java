package com.vishal.project03.service.serviceImpl;

import org.springframework.stereotype.Service;
import com.vishal.project03.service.UserService;
import com.vishal.project03.enity.User;
import com.vishal.project03.enity.UserRole;
import com.vishal.project03.enity.Customer;
import com.vishal.project03.Repository.UserRepository;
import com.vishal.project03.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setDeleted(true);
        userRepository.save(user);
    }

    @Override
    public User updateById(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setUserRole(user.getUserRole());
            updatedUser.setPhone(user.getPhone());
            updatedUser.setAddress(user.getAddress());
            updatedUser.setCity(user.getCity());
            updatedUser.setState(user.getState());
            updatedUser.setCountry(user.getCountry());
            updatedUser.setZip(user.getZip());
            return userRepository.save(updatedUser);
        } else {
            return null;
        }
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public List<User> getAll(String search, String sortBy, String sortDirection) {
        Specification<User> spec = (root, query, criteriaBuilder) -> {
            if (search != null && !search.isEmpty()) {
                return criteriaBuilder.or(
                    criteriaBuilder.like(root.get("name"), "%" + search + "%"),
                    criteriaBuilder.like(root.get("email"), "%" + search + "%")
                );
            }
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true)); // No filtering
        };

        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        return userRepository.findAll(spec, sort);
    }

    @Override
    public User addCustomerUser(Long customerId, User user) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            user.setCustomer(customer.get());
            user.setUserRole(UserRole.CUSTOMER_USER);
            return userRepository.save(user);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }
}