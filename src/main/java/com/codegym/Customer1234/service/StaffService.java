package com.codegym.Customer1234.service;

import com.codegym.Customer1234.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffService {
    Page<Staff> findAll(Pageable pageable);

    Staff findById(Long id);

    void save (Staff staff);

    void delete (Long id);

    Page<Staff> findByNameContains(String name, Pageable pageable);
}
