package com.codegym.Customer1234.service;

import com.codegym.Customer1234.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();

    Group findById (Long id);

    void save(Group group);

    void delete(Long id);
}
