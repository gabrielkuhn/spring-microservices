package com.gabrielkuhn.department.service;

import com.gabrielkuhn.department.entity.Department;
import com.gabrielkuhn.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long id) {
        log.info("Inside findDepartmentById of DepartmentService");
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("department not found"));
    }
}
