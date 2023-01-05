package com.bbl.studentmanagementapplication.models.repository;
import com.bbl.studentmanagementapplication.models.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository <Student, Integer>{
}
