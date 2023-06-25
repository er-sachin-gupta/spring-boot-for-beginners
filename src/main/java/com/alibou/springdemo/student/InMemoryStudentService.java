package com.alibou.springdemo.student;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryStudentService implements StudentService {

    private final InMemoryStudentDao dao;

    public InMemoryStudentService(InMemoryStudentDao dao) {
        this.dao = dao;
    }

    @Override
    public Student save(Student s) {
        return dao.save(s);
    }

    @Override
    public List<Student> findAllStudents() {
        return dao.findAllStudents();
        /*return java.util.List.of(
                new com.alibou.springdemo.student.Student("Ali", "Bouali", LocalDate.now(), "contact@aliboucoding.com", 34),
                new com.alibou.springdemo.student.Student("Radhe", "Bouali", LocalDate.now(), "contact@aliboucoding.com", 28)
        );*/
    }

    @Override
    public Student getByEmail(String email) {
        return dao.getByEmail(email);
    }

    @Override
    public Student update(Student s) {
        return dao.update(s);
    }

    @Override
    public void delete(String email) {
        dao.delete(email);
    }

}
