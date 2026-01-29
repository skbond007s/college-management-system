package com.sms.student_management_system.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ATTENDANCE")
@SequenceGenerator(
        name = "attendance_seq_gen",
        sequenceName = "ATTENDANCE_SEQ",
        allocationSize = 1
)
public class Attendance {

    // ===== PRIMARY KEY =====
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendance_seq_gen")
    @Column(name = "ATTENDANCE_ID")
    private Long id;

    // ===== RELATION WITH STUDENT =====
    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    // ===== ATTENDANCE DETAILS =====
    @Column(name = "ATTENDANCE_DATE")
    private LocalDate attendanceDate;

    @Column(name = "COURSE")
    private String course;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "STATUS")
    private String status; // Present / Absent

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public String getCourse() {
        return course;
    }

    public String getSubject() {
        return subject;
    }

    public String getStatus() {
        return status;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}