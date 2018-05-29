package com.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class controller {

@RequestMapping("/")
public String index() {
	System.out.println("hello");
    return "Welcome to CloudTrail Logs";
    }
}
