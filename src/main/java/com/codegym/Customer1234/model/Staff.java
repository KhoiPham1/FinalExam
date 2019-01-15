package com.codegym.Customer1234.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = Group.class)
    @JoinColumn(name = "category")
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @NotEmpty
    private String codestaff;

    @NotEmpty
    private String name;

    @NotEmpty
    private String birthday;

    @NotEmpty
    private String gender;

    @Pattern(regexp = "^$|[0-9]{10}")
    private String phonenumber;

    @NotEmpty
    private String code;

    @Email
    private String email;

    @NotEmpty
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodestaff() {
        return codestaff;
    }

    public void setCodestaff(String codestaff) {
        this.codestaff = codestaff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Staff(Group group, @NotEmpty String codestaff, @NotEmpty String name, @NotEmpty String birthday, @NotEmpty String gender, @Pattern(regexp = "^$|[0-9]{10}") String phonenumber, @NotEmpty String code, @Email String email, @NotEmpty String address) {
        this.group = group;
        this.codestaff = codestaff;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phonenumber = phonenumber;
        this.code = code;
        this.email = email;
        this.address = address;
    }

    public Staff() {
    }
}
