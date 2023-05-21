package com.example.examm.Controller;

import com.example.examm.Model.Student;
import com.example.examm.Model.Teacher;
import com.example.examm.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("api/v1/student")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ArrayList<Student> getStudent(){
       return studentService.getStudents();
    }

    @PostMapping("/create")
    public ResponseEntity addStudent(@Valid @RequestBody Student s , Errors e ){
        if(e.hasErrors()){
           String message= e.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(s);
        return ResponseEntity.status(200).body("Student added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student s , Errors e , @PathVariable String id ){
        if(e.hasErrors()){
            String message= e.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(studentService.updateStudent(id , s))
           return ResponseEntity.status(200).body("Student updated!");

        return ResponseEntity.status(400).body("Student with this ID dosent exist!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent( @PathVariable String id ){

        if(studentService.deleteStudent(id))
            return ResponseEntity.status(200).body("Student deleted!");

        return ResponseEntity.status(400).body("Student with this ID dosent exist!");
    }

    @GetMapping("/getStudent/{name}")
    public ResponseEntity getStudent(@PathVariable String name){
        if(studentService.getStudent(name) == null)
            return ResponseEntity.status(400).body("Student with this name dosent exist!");
        return ResponseEntity.status(200).body(studentService.getStudent(name));
    }
}
