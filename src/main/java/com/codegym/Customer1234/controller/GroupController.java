package com.codegym.Customer1234.controller;


import com.codegym.Customer1234.model.Group;
import com.codegym.Customer1234.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/group/",method = RequestMethod.GET)
    // hiển thị toàn bộ list
    public ResponseEntity<Iterable<Group>> listAllGroup(){
        List<Group> groups = groupService.findAll();
        if (groups.isEmpty()){
            return new ResponseEntity<Iterable<Group>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<Group>>(groups,HttpStatus.OK);
    }
    // tìm theo id
    @RequestMapping(value = "/group/{id}",method =RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> getGroup(@PathVariable Long id){
        System.out.println("Take id" + id);
        Group group = groupService.findById(id);
        if (group ==null){
            System.out.println("Group with id" + id + " not found ");
            return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Group>(group,HttpStatus.OK);
    }
    // tạo 1 group không tạo được id
    @RequestMapping(value = "/group",method = RequestMethod.POST)
    public ResponseEntity<Void> createGroup(@RequestBody Group group, UriComponentsBuilder uriComponentsBuilder){
        System.out.println("Creating group" +group.getName());
        groupService.save(group);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/group/{id}").buildAndExpand(group.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    // sửa 1 group không sửa được id
    @RequestMapping(value = "/group/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Group> updateGroup(@PathVariable Long id,@RequestBody Group group){
        System.out.println("Updating group" + id);

        Group currentGroup = groupService.findById(id);

        if (currentGroup==null){
            System.out.println("Group with id"+id +" not found");
            return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
        }
        currentGroup.setName(group.getName());
        currentGroup.setId(group.getId());
        groupService.save(currentGroup);
        return new ResponseEntity<Group>(currentGroup,HttpStatus.OK);
    }
    // xóa 1 group
    @RequestMapping(value = "/group/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Group> deleteGroup(@PathVariable Long id){
        System.out.println("Take id & delete group with id" + id);

        Group group = groupService.findById(id);
        if (group == null){
            System.out.println("unable to delete. Group with id" + id + " not found");
            return  new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
        }
        groupService.delete(id);
        return new ResponseEntity<Group>(HttpStatus.NO_CONTENT);

    }
}
