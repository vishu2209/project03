package com.vishal.project03.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.vishal.project03.enity.Role;
import com.vishal.project03.enity.User;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    
    @Query("SELECT u FROM User u WHERE u.isDeleted = false")
    List<User> findAllActiveUsers();

    List<User> findByRole(Role role);
}