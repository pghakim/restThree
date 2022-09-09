package com.example.restThree.controller;

import com.example.restThree.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class EmployeeController {

  @Autowired
  RestTemplate restTemplate;

  @GetMapping("/hello")
  public String helloGet() {
    return restTemplate.getForObject("http://localhost:8080/employeelist", String.class);
  }


  @PostMapping("/hello")
  public String helloPost(@RequestBody Employee emp) {
    HttpEntity<Employee> request = new HttpEntity<>(emp);
    return restTemplate.postForObject("http://localhost:8080/employeelist", request, String.class);
  }


  @DeleteMapping("/hello/{id}")
  public void helloDelete(@PathVariable int id) {
    restTemplate.delete("http://localhost:8080/employeelist" + id);
  }

  @PutMapping("/employee")
  public void helloPut(@RequestBody Employee employee) {
    HttpEntity<Employee> request = new HttpEntity<>(employee);
    restTemplate.put("http://localhost:8080/employeelist", request);


  }
}

