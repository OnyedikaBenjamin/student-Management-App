package com.bbl.studentmanagementapplication.services;
import com.bbl.studentmanagementapplication.models.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    void addStudent(Student student);
    Optional<Student> getStudent(int id);
//    void updateStudent(Student student, int id);
    void deleteStudent(int id);

    Student updateStudent(Student student, int id);
}