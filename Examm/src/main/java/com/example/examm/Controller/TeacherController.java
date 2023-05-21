package com.example.examm.Controller;

import com.example.examm.Model.Student;
import com.example.examm.Model.Teacher;
import com.example.examm.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("api/v1/teacher")
@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ArrayList<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @PostMapping("/create")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher t , Errors e ){
        if(e.hasErrors()){
            String message= e.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(t);
        return ResponseEntity.status(200).body("Teacher added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher t , Errors e , @PathVariable String id ){
        if(e.hasErrors()){
            String message= e.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(teacherService.updateTeacher(id , t))
            return ResponseEntity.status(200).body("Teacher updated!");

        return ResponseEntity.status(400).body("Teacher with this ID dosent exist!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher( @PathVariable String id ){

        if(teacherService.deleteTeacher(id))
            return ResponseEntity.status(200).body("Teacher deleted!");

        return ResponseEntity.status(400).body("Teacher with this ID dosent exist!");
    }

    @GetMapping("/getTeacher/{id}")
    public ResponseEntity getTeacher(@PathVariable String id){
        if(teacherService.search(id) == -1)
            return ResponseEntity.status(400).body("Teacher with this ID exist!");
        return ResponseEntity.status(200).body(teacherService.getTeacher(id));
    }
}
