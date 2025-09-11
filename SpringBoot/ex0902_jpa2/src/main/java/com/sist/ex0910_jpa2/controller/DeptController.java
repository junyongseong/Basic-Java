package com.sist.ex0910_jpa2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.ex0910_jpa2.service.DeptService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/dept")
@RequiredArgsConstructor
public class DeptController {

    private final DeptService deptService;
    @GetMapping("/all")
    public Object getAll() {
        return deptService.findAll();
    }
    
}
