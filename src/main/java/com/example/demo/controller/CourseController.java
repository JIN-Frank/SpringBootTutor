package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CourseController {
    @Autowired  // IOC 控制反转
    CourseService courseService;  // singleton

    @GetMapping(path = "/", produces = "application/json")   //如果你用get方法 call我这个地址
    public HttpEntity findAllCourses(){
        List<Course> allCourses = courseService.findAllCourses();  // 我就帮你用这个方法处理这个请求

        return new ResponseEntity<>(allCourses,HttpStatus.OK);  // 返回结果给你
    }
}

