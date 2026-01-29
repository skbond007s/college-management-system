package com.sms.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.student_management_system.entity.Attendance;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {  
    @Query("""
        SELECT 
            a.attendanceDate,
            a.course,
            a.subject,
            SUM(CASE WHEN a.status = 'Present' THEN 1 ELSE 0 END),
            SUM(CASE WHEN a.status = 'Absent' THEN 1 ELSE 0 END)
        FROM Attendance a
        GROUP BY a.attendanceDate, a.course, a.subject
        ORDER BY a.attendanceDate DESC
    """)
    List<Object[]> getAttendanceRecords();
} 