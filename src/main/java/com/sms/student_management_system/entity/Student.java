package com.sms.student_management_system.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "STUDENTS")
@SequenceGenerator(
        name = "student_seq_gen",
        sequenceName = "STUDENT_SEQ",
        allocationSize = 1
)
public class Student {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seq_gen"
    )
       @Column(name = "STUDENT_ID")
    private Long id;
    @Column(name = "ROLL_NO")
    private String rollNo;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "DOB")
    private LocalDate dob;
    // ===== FAMILY DETAILS =====
    @Column(name = "FATHER_NAME")
    private String fatherName;

    @Column(name = "MOTHER_NAME")
    private String motherName;

    // ===== ACADEMIC DETAILS =====
    @Column(name = "COURSE")
    private String course;

    @Column(name = "SEMESTER")
    private Integer semester;

    // ===== CONTACT DETAILS =====
    @Column(name = "PHONE")
    private String phone;

    @Column(name = "PARENT_CONTACT")
    private String parentContact;

    @Column(name = "EMAIL")
    private String email;

    // ===== ADMISSION DETAILS =====
    @Column(name = "ADMISSION_DATE")
    private LocalDate admissionDate;

    @Column(name = "REGISTRATION_NO")
    private String registrationNo;

    @Column(name = "ADDRESS")
    private String address;

    // ===== Getters & Setters =====

    public Long getId() { return id; }

    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public String getMotherName() { return motherName; }
    public void setMotherName(String motherName) { this.motherName = motherName; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public Integer getSemester() { return semester; }
    public void setSemester(Integer semester) { this.semester = semester; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getParentContact() { return parentContact; }
    public void setParentContact(String parentContact) { this.parentContact = parentContact; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(LocalDate admissionDate) { this.admissionDate = admissionDate; }

    public String getRegistrationNo() { return registrationNo; }
    public void setRegistrationNo(String registrationNo) { this.registrationNo = registrationNo; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}