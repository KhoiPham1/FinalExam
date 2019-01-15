package com.codegym.Customer1234.service.impl;

import com.codegym.Customer1234.model.Staff;
import com.codegym.Customer1234.repository.StaffRepository;
import com.codegym.Customer1234.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    @Override
    public Staff findById(Long id) {
        return staffRepository.findById(id).get();
    }

    @Override
    public void save(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void delete(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Page<Staff> findByNameContains(String name, Pageable pageable) {
        return staffRepository.findByNameContains(name,pageable);
    }
}
