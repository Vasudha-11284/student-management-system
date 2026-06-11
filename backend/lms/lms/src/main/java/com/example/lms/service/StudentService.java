package com.example.lms.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lms.dto.StudentRequestDTO;
import com.example.lms.exception.StudentNotFoundException;
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
    public Student getStudentById(Integer id){
            return repository.findById(id).orElseThrow(
                ()-> new StudentNotFoundException("Student not found with id:" + id)
            );
    }
    public Student addStudent(StudentRequestDTO dto) {

    Student student = new Student();
    //conerting requestdto to object 
    student.setName(dto.getName());
    student.setCourse(dto.getCourse());

    return repository.save(student);
}
}
