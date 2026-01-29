package com.sms.student_management_system.controller;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;  
import com.sms.student_management_system.entity.Attendance;
import com.sms.student_management_system.entity.Student;
import com.sms.student_management_system.repository.StudentRepository;
import com.sms.student_management_system.repository.AttendanceRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
private AttendanceRepository attendanceRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin-login")
    public String adminLoginPage() {
        return "admin-login";
    }

    @PostMapping("/admin-login")
    public String adminLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model
    ) {
        if ("admin".equals(username) && "admin123".equals(password)) {
            return "redirect:/admin-dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "admin-login";
        }
    }

    @GetMapping("/admin-dashboard")
public String adminDashboard(Model model) {

    long totalStudents = studentRepository.count();
    long totalAttendance = attendanceRepository.count();

    model.addAttribute("totalStudents", totalStudents);
    model.addAttribute("totalAttendance", totalAttendance);

    return "admin-dashboard";
}


    @GetMapping("/add-student")
    public String addStudentPage() {
        return "add-student";
    }
    @GetMapping("/students")
    public String viewStudents(Model model) {
    model.addAttribute("students", studentRepository.findAll());
    return "student-list";
    }
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
    Student student = studentRepository.findById(id).orElse(null);
    model.addAttribute("student", student);
    return "edit-student";
    }
    @GetMapping("/view/{id}")
    public String viewStudent(@PathVariable Long id, Model model) {
    Student student = studentRepository.findById(id).orElse(null);
    model.addAttribute("student", student);
    return "view-student";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
    studentRepository.deleteById(id);
    return "redirect:/students";
    }
    @PostMapping("/save")
public String saveStudent(
        @RequestParam String rollNo,
        @RequestParam String name,
        @RequestParam String gender,

        @RequestParam
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate dob,

        @RequestParam String fatherName,
        @RequestParam String motherName,
        @RequestParam String course,
        @RequestParam Integer semester,
        @RequestParam String phone,
        @RequestParam String parentContact,
        @RequestParam String email,

        @RequestParam
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate admissionDate,

        @RequestParam String registrationNo,
        @RequestParam String address
) {

    Student s = new Student();

    s.setRollNo(rollNo);
    s.setName(name);
    s.setGender(gender);
    s.setDob(dob);
    s.setFatherName(fatherName);
    s.setMotherName(motherName);
    s.setCourse(course);
    s.setSemester(semester);
    s.setPhone(phone);
    s.setParentContact(parentContact);
    s.setEmail(email);
    s.setAdmissionDate(admissionDate);
    s.setRegistrationNo(registrationNo);
    s.setAddress(address);

    studentRepository.save(s);

    return "redirect:/students";
}

@GetMapping("/attendance")
public String markAttendance(Model model) {
    model.addAttribute("students", studentRepository.findAll());
    return "mark-attendance";
}
@PostMapping("/attendance/save")
public String saveAttendance(
        @RequestParam
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate attendanceDate,

        @RequestParam String course,
        @RequestParam String subject,
        HttpServletRequest request
) {

    List<Student> students = studentRepository.findAll();

    for (Student student : students) {

        String status = request.getParameter("status_" + student.getId());

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setAttendanceDate(attendanceDate);
        attendance.setCourse(course);
        attendance.setSubject(subject);
        attendance.setStatus(status);

        attendanceRepository.save(attendance);
    }

    return "redirect:/attendance";
}
@GetMapping("/attendance/records")
public String viewAttendanceRecords(Model model) {

    List<Object[]> records = attendanceRepository.getAttendanceRecords();
    System.out.println("RECORD COUNT = " + records.size());
    model.addAttribute("records", records);

    return "attendance-records";
}
}