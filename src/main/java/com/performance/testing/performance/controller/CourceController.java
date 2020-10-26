package com.performance.testing.performance.controller;


import com.performance.testing.performance.model.Courses;
import com.performance.testing.performance.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourceController {
    @Autowired
    private CourseRepo courseRepo;

    @RequestMapping(method = RequestMethod.POST)
    public List<Courses> addCourses(@RequestBody List<Courses> courses){
        return this.courseRepo.saveAll(courses);
    }
}
