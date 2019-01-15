package com.codegym.Customer1234.repository;

import com.codegym.Customer1234.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StaffRepository extends PagingAndSortingRepository<Staff,Long> {
    Page<Staff> findByNameContains(String name, Pageable pageable);
}
