package com.alibou.springdemo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> findAllStudents() {
        return java.util.List.of(
                new com.alibou.springdemo.student.Student("Ali", "Bouali", LocalDate.now(), "contact@aliboucoding.com", 34),
                new com.alibou.springdemo.student.Student("Radhe", "Bouali", LocalDate.now(), "contact@aliboucoding.com", 28)
        );
    }

}
