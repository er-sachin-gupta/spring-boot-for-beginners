package com.alibou.springdemo.student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentDao {

    private final List<Student> STUDENTS = new ArrayList<>();

    
    public Student save(Student s) {
        STUDENTS.add(s);
        return s;
    }

    
    public List<Student> findAllStudents() {
        return STUDENTS;
        /*return java.util.List.of(
                new com.alibou.springdemo.student.Student("Ali", "Bouali", LocalDate.now(), "contact@aliboucoding.com", 34),
                new com.alibou.springdemo.student.Student("Radhe", "Bouali", LocalDate.now(), "contact@aliboucoding.com", 28)
        );*/
    }

    
    public Student getByEmail(String email) {
        return STUDENTS.stream().
                filter(s -> s.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    
    public Student update(Student s) {
        var studentIndex = IntStream.range(0, STUDENTS.size())
                .filter(index -> STUDENTS.get(index).getEmail().equals(s.getEmail()))
                .findFirst()
                .orElse(-1);
        if (studentIndex > -1) {
            STUDENTS.set(studentIndex, s);
            return s;
        }
        return null;
    }

    
    public void delete(String email) {
        var student = getByEmail(email);
        if (student != null) {
            STUDENTS.remove(student);
        }
    }
}
