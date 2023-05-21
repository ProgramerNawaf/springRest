package com.example.examm.Service;


import com.example.examm.Model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Component
public class StudentService {
    ArrayList <Student> students = new ArrayList<Student>();

    public ArrayList<Student> getStudents(){
        return students;
    }

    public void addStudent(Student s){
        students.add(s);
    }

    public boolean updateStudent(String id , Student s){
        if(search(id) != -1) {
            students.set(search(id), s);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(String id ){
        if(search(id) != -1) {
            students.remove(search(id));
            return true;
        }
        return false;
    }

    public int search(String id ){
        for(int i= 0 ; i< students.size() ; i++)
            if(students.get(i).getId().equalsIgnoreCase(id))
                return i;
        return -1;
    }

    public Student getStudent(String name ){
        for(int i= 0 ; i< students.size() ; i++)
            if(students.get(i).getName().equalsIgnoreCase(name))
                return students.get(i);
        return null;
    }
}
