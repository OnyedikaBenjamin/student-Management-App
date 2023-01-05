package com.bbl.studentmanagementapplication.services;

import com.bbl.studentmanagementapplication.exceptions.StudentException;
import com.bbl.studentmanagementapplication.models.entity.Student;
import com.bbl.studentmanagementapplication.models.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }
    @Override
    public Optional<Student> getStudent(int id) {
        return studentRepository.findById(id);
    }
@Override
public Student updateStudent(Student updatedStudent, int id) {
    Student student = getStudent(id).orElseThrow(()-> new StudentException("Student queried cannot be found"));
    student.setFirstName(updatedStudent.getFirstName());
    student.setLastName(updatedStudent.getLastName());
    student.setEmail(updatedStudent.getEmail());
    return studentRepository.save(student);
}
    @Override
    public void deleteStudent(int id) {
        studentRepository.delete(studentRepository.getReferenceById(id));
    }

}