package com.example.lms.controller;
import com.example.lms.model.Student;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController{
    @GetMapping
    public ArrayList<Student> getStudent() {
       ArrayList<Student> students=new ArrayList<>();
       students.add(
              new Student(1,"Diya","CSE")
       );
       students.add(
              new Student(2,"Vasudha","BE-CSE")
       );
       return students;
    }
}
