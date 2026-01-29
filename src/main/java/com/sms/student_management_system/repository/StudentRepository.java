package com.sms.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sms.student_management_system.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}   