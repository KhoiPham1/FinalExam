package com.codegym.Customer1234.controller;

import com.codegym.Customer1234.model.Group;
import com.codegym.Customer1234.model.Staff;
import com.codegym.Customer1234.service.GroupService;
import com.codegym.Customer1234.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class StaffController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private GroupService groupService;

    @ModelAttribute("group")
    public Iterable<Group> groups(){return groupService.findAll();}

    @GetMapping("create-staff")
    public ModelAndView formCreate(){
        ModelAndView modelAndView = new ModelAndView("create","staff",new Staff());
        return modelAndView;
    }

    @PostMapping("create-staff")
    public ModelAndView createStaff(@Validated @ModelAttribute("staff")Staff staff, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("create");
        if (bindingResult.hasFieldErrors()){
            return modelAndView;
        }else {
            staffService.save(staff);
            modelAndView.addObject("message","Successfully!");
            return modelAndView;
        }
    }

    @GetMapping("list-staff")
    public ModelAndView listStaff(@RequestParam("search")Optional<String>search, @PageableDefault(5)Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Staff> staff;
        if (search.isPresent()){
            staff = staffService.findByNameContains(search.get(),pageable);
        }else{
            staff = staffService.findAll(pageable);
        }
        modelAndView.addObject("staff",staff);
        return modelAndView;
    }

    @GetMapping("edit-staff/{id}")
    public ModelAndView formUpdateStaff(@PathVariable Long id){
        Staff staff = staffService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit","staff",staff);
        return modelAndView;
    }
    @PostMapping("edit-staff")
    public ModelAndView updateStaff(@Validated @ModelAttribute("staff") Staff staff,BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("edit");
        if (bindingResult.hasFieldErrors()){
            return modelAndView;
        }else {
            staffService.save(staff);
            modelAndView.addObject("message","Success!");
            return modelAndView;
        }
    }
    @GetMapping("delete-staff/{id}")
    public ModelAndView formDeleteStaff(@PathVariable Long id){
        Staff staff = staffService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete","staff",staff);
        return modelAndView;
    }
    @PostMapping("delete-staff")
    public String deleteStaff(@ModelAttribute("staff") Staff staff){
        staffService.delete(staff.getId());
        return "redirect:list-staff";
    }
}
