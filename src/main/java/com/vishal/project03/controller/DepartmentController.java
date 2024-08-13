package com.vishal.project03.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import com.vishal.project03.enity.Department;
import com.vishal.project03.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getById")
    public Optional<Department> getDepartmentById(@RequestParam Long id) {
        return departmentService.getById(id);
    }

    @PostMapping("/save")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @DeleteMapping("/deleteById")
    public void deleteDepartmentById(@RequestParam Long id) {
        departmentService.deleteById(id);
    }

    @GetMapping("/getAll")
    public List<Department> getAllDepartments() {
        return departmentService.getAll();
    }


    @PutMapping("/update")
    public Department updateDepartment(@RequestParam Long id, @RequestBody Department department) {
        return departmentService.update(id, department);
    }
}


