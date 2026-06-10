package com.example.lms.controller;
import com.example.lms.model.Student;
import com.example.lms.service.StudentService;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController{
       @Autowired
       private StudentService service;
       @Autowired
       JdbcTemplate jdbcTemplate;
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
    @GetMapping("/count")
     public String  countStudents() {
         return service.getStudentCount();
    }
    @GetMapping("/message")
    public String getMessage(){
       return service.getMessage();
    }
}
