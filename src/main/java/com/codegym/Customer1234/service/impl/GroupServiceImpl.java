package com.codegym.Customer1234.service.impl;

import com.codegym.Customer1234.model.Group;
import com.codegym.Customer1234.repository.GroupRepository;
import com.codegym.Customer1234.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Iterable<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).get();
    }
}
