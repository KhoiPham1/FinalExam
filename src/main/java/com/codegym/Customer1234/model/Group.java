package com.codegym.Customer1234.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }
}
