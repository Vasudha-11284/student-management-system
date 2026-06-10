package com.example.lms.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.lms.model.Student;
import com.example.lms.repository.StudentRepository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
@Service
public class StudentService {
    public String getMessage(){
        return "Student Service Working";
    }
    @Autowired //Di-FIlled injecttion
     private JdbcTemplate jdbcTemplate;
     @Autowired
      private StudentRepository repository;
    public String getStudentCount(){
        
        String sql = "SELECT COUNT(*) FROM students";

        return jdbcTemplate.queryForObject(
                sql,
                Integer.class
        ).toString();
    }
        public List<Student> getAllStudents(){
            return repository.findAll();
        }
        public Student saveStudent( Student student) {
    return repository.save(student);
}
    
}
