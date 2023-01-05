package com.bbl.studentmanagementapplication.controllers;
import com.bbl.studentmanagementapplication.models.entity.Student;
import com.bbl.studentmanagementapplication.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;    // Dependency Injection

    @RequestMapping("/students")
    public List<Student> showListOfStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping("/students/{id}")
    public Optional<Student> getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/students")
    public void addStudent(@RequestBody Student student){           // @RequestBody mean that add the parameters of student object while creating.
        studentService.addStudent(student);
    }
    @RequestMapping(method = RequestMethod.PUT, value="/students/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable int id){
        studentService.updateStudent(student, id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value="/students/{id}")
    public void deleteStudent(@RequestBody Student student, @PathVariable int id){
        studentService.deleteStudent(id);
    }
}