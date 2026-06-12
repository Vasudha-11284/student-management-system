package com.example.lms.controller;
import com.example.lms.dto.StudentRequestDTO;
import com.example.lms.dto.StudentResponseDTO;
import com.example.lms.model.Student;
import com.example.lms.service.StudentService;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController{
       @Autowired
       private  StudentService service;
   //  @GetMapping
   //  public ArrayList<Student> getStudent() {
   //     ArrayList<Student> students=new ArrayList<>();
   //     students.add(
   //            new Student(1,"Diya","CSE")
   //     );
   //     students.add(
   //            new Student(2,"Vasudha","BE-CSE")
   //     );
   //     return students;
    @GetMapping("/count")
     public String  countStudents() {
         return service.getStudentCount();
    }
    @GetMapping("/message")
    public String getMessage(){
       return service.getMessage();
    }
    @GetMapping
     public List<Student> getAllStudents(){
            return service.getAllStudents();
        }
//         @PostMapping
// public Student addStudent(@RequestBody Student student) {
//     return service.saveStudent(student);
// }
@GetMapping("/{id}")
public ResponseEntity<?> getStudent( @PathVariable("id") Integer id){
     Student student =service.getStudentById(id);
     StudentResponseDTO responseDTO=new StudentResponseDTO(
        student.getId(),
        student.getName(),
        student.getCourse()
    );
    return ResponseEntity.ok(responseDTO);
}
@PostMapping
public ResponseEntity<?> addStudent(@RequestBody StudentRequestDTO dto) {

    Student student = service.addStudent(dto);

    return ResponseEntity.ok(student);
}
@PutMapping("/{id}")
public ResponseEntity<?> updateStudent(@PathVariable("id") Integer id, @RequestBody StudentRequestDTO  dto){
    return ResponseEntity.ok(
        service.updateStudent(id, dto)
    );
}
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteStudent(@PathVariable("id") Integer id){
        return ResponseEntity.ok(Map.of("message",service.deleteStudent(id)));
}
}
