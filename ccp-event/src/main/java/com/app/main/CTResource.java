package com.app.main;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
public class CTResource {

@RequestMapping("/")
public String index() {
	System.out.println("hello");
    return "Welcome to CloudTrail Logs";
    }


@GetMapping("/blog/{id}")
public String show(@PathVariable String id){
    int blogId = Integer.parseInt(id);
    return id.toString();
}

@PostMapping("/blog/search")
public String search(@RequestBody String body){
	System.out.println(body);
     String title = body.toString();
     return "HttpStatus.OK";
     
}
}