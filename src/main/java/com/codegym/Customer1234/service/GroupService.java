package com.codegym.Customer1234.service;

import com.codegym.Customer1234.model.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupService {
    Iterable<Group> findAll();

    Group findById (Long id);
}
