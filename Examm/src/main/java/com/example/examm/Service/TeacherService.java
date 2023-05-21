package com.example.examm.Service;
import com.example.examm.Model.Teacher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Component
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public ArrayList<Teacher> getTeachers(){
        return teachers;
    }

    public void addTeacher(Teacher s){
        teachers.add(s);
    }

    public boolean updateTeacher(String id , Teacher s){
        if(search(id) != -1) {
            teachers.set(search(id), s);
            return true;
        }
        return false;
    }

    public boolean deleteTeacher(String id ){
        if(search(id) != -1) {
            teachers.remove(search(id));
            return true;
        }
        return false;
    }

    public int search(String id ){
        for(int i= 0 ; i< teachers.size() ; i++)
            if(teachers.get(i).getId().equalsIgnoreCase(id))
                return i;
        return -1;
    }
    public Teacher getTeacher(String id ){
        for(int i= 0 ; i< teachers.size() ; i++)
            if(teachers.get(i).getId().equalsIgnoreCase(id))
                return teachers.get(i);
        return null;
    }
}
