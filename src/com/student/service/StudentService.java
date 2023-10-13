package com.student.service;

import com.student.model.Student;

import java.io.IOException;

public interface StudentService {

    void createStudent(Student student);

    void findAllStudents();

    void findStudent(long id);

    void updateStudent(long id) throws IOException;

    void deleteStudent(long id);
}
