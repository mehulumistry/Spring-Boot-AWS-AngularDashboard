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

// ;

package org.finra.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CloudWatchResources {

    private String payload = "";
    @RequestMapping("/")
    public String index() {
        System.out.println("hello");
        return "Welcome to CloudTrail Logs";
    }

    @GetMapping("/blog/search")
    public String show(){
        System.out.println(payload);
        if(payload.length() > 0){
            return payload;
        }
        return "No data Found";
    }

    // make it so that it will consume JSON
    @PostMapping("/blog/search")
    public String search(@RequestBody String body){

        Map<String,String> map = new HashMap<String,String>();
        ObjectMapper mapper = new ObjectMapper();

        try {
           map = mapper.readValue( body, new TypeReference<HashMap>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        payload=map.toString();
        System.out.println(map);
        String valueFromMap = null;
       // use GSON
        Gson gson = new GsonBuilder().create();
        GSONtest p = gson.fromJson(body, GSONtest.class);
        System.out.println(p.getAge());
        System.out.println(p.getName());
       
        return map.toString();
    }
}
