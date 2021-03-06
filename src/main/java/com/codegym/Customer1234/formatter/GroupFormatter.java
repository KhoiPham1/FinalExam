package com.codegym.Customer1234.formatter;

import com.codegym.Customer1234.model.Group;
import com.codegym.Customer1234.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class GroupFormatter implements Formatter<Group> {
    private GroupService groupService;

    @Autowired
    private GroupFormatter(GroupService groupService){this.groupService=groupService;}
    @Override
    public Group parse(String text, Locale locale) throws ParseException {
        return groupService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Group object, Locale locale) {
        return "["+object.getId()+","+object.getName()+"]";
    }
}
