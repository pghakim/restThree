package com.example.restThree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String helloGet(){
        return restTemplate.getForObject("http://localhost:8080/employeelist", String.class);
    }



    @PostMapping("/hello")
    public String  helloPost(@RequestBody Employee emp){
        HttpEntity<Employee> request = new HttpEntity<>(emp);
        return restTemplate.postForObject("http://localhost:8080/employeelist", request, String.class);
    }

}
