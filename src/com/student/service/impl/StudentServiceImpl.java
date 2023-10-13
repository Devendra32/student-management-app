package com.student.service.impl;

import com.student.dao.StudentDao;
import com.student.model.Student;
import com.student.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    StudentDao studentDao = new StudentDao();

    @Override
    public void createStudent(Student student) {
        if (studentDao.saveStudent(student)) {
            System.out.println("Record saved successfully...");
        } else {
            System.out.println("Something went wrong...");
        }
    }

    @Override
    public void findAllStudents() {
        List<Student> allStudent = studentDao.findAll();
        if (!allStudent.isEmpty()) {
            allStudent.stream().forEach(System.out::println);
        } else {
            System.out.println("Data not available...");
        }
    }

    @Override
    public void findStudent(long id) {
        Student st = studentDao.findById(id);
        if (st != null) {
            System.out.println(st);
        } else {
            System.out.println("No student found with id :" + id);
        }
    }

    @Override
    public void updateStudent(long id) throws IOException {
        Student st = studentDao.findById(id);
        if (st!=null) {
            System.out.println("Enter student name :");
            st.setStudentName(br.readLine());
            System.out.println("Enter student phone :");
            st.setStudentPhone(br.readLine());
            System.out.println("Enter student city :");
            st.setStudentCity(br.readLine());
            boolean b = studentDao.updateStudent(st);
            if(b)
                System.out.println("Record updated successfully...");
            else
                System.out.println("Something went wrong...");

        } else {
            System.out.println("No such student found with id :" + id);
        }
    }

    @Override
    public void deleteStudent(long id) {
        boolean b = studentDao.deleteStudent(id);
        if(b)
            System.out.println("Record deleted successfully...");
        else
            System.out.println("Something went wrong...");
    }

}
