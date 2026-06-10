package com.example.lms.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
@Service
public class StudentService {
    public String getMessage(){
        return "Student Service Working";
    }
    @Autowired //Di-FIlled injecttion
     private JdbcTemplate jdbcTemplate;
    public String getStudentCount(){
        
        String sql = "SELECT COUNT(*) FROM students";

        return jdbcTemplate.queryForObject(
                sql,
                Integer.class
        ).toString();
    }
}
