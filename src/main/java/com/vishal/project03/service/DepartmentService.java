package com.vishal.project03.service;

import java.util.List;
import java.util.Optional;

import com.vishal.project03.enity.Department;

public interface DepartmentService {

    Optional<Department> getById(Long id);

    Department save(Department department);

    void deleteById(Long id);

    List<Department> getAll();

    Department update(Long id, Department department); 
}