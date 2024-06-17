package com.csi.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee{
    private int empId;
    private String empName;
    private double empSalary;
}

@RestController
@RequestMapping("/api")
public class Appcontroller {
    @GetMapping
    public String sayHi(){
        return "WELCOME TO THE FULL STACK JAVA DEVELOPER";
    }

    @GetMapping("/services")
    public String Services(){
        return "APP DEVELOPMENT SERVICE";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> listofemployee(){
        return ResponseEntity.ok( Stream.of(new Employee(121,"shubham",45000),
                new Employee(122,"om",670000),
                new Employee(123,"raj",78000)).toList());
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortbyname(){
        return ResponseEntity.ok( Stream.of(new Employee(121,"shubham",45000),
                new Employee(122,"om",670000),
                new Employee(123,"raj",78000)).collect(Collectors.toList()).stream().sorted(Comparator.comparing(Employee::getEmpName)).toList());
    }




}
