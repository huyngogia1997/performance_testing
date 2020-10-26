package com.performance.testing.performance.controller;


import com.performance.testing.performance.model.Courses;
import com.performance.testing.performance.model.Roles;
import com.performance.testing.performance.repository.CourseRepo;
import com.performance.testing.performance.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    @Autowired
    private RoleRepo roleRepo;

    @RequestMapping(method = RequestMethod.POST)
    public List<Roles> addRoles(@RequestBody List<Roles> roles){
        return this.roleRepo.saveAll(roles);
    }
}
