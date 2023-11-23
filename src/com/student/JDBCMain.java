package com.student;

import com.student.model.Student;
import com.student.service.StudentService;
import com.student.service.impl.StudentServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JDBCMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Student st = new Student();
        StudentService ss = new StudentServiceImpl();
        System.out.println("*****************************************************");
        System.out.println("<<<<<<<<< WELCOME TO STUDENT MANAGEMENT APP >>>>>>>>>");
        System.out.println("*****************************************************");
        while (true) {
            System.out.println("\n---------------------------------------------------");
            System.out.println("PRESS 1 to Add Student");
            System.out.println("PRESS 2 to Display All Students");
            System.out.println("PRESS 3 to Display By Student Id");
            System.out.println("PRESS 4 to Update Student");
            System.out.println("PRESS 5 to Delete Student");
            System.out.println("PRESS 6 to Exit");
            System.out.println("---------------------------------------------------\n");
            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                //create student
                case 1: {
                    System.out.println("Enter student name :");
                    st.setStudentName(br.readLine());
                    System.out.println("Enter student phone :");
                    st.setStudentPhone(br.readLine());
                    System.out.println("Enter student city :");
                    st.setStudentCity(br.readLine());
                    ss.createStudent(st);
                }
                break;
                //display all students
                case 2:
                    ss.findAllStudents();
                    break;
                //display student by id
                case 3: {
                    System.out.println("Enter student id :");
                    ss.findStudent(Long.parseLong(br.readLine()));
                }
                break;
                //update student record
                case 4: {
                    System.out.println("Enter student id :");
                    ss.updateStudent(Long.parseLong(br.readLine()));
                }
                break;
                //delete student
                case 5: {
                    System.out.println("Enter student id :");
                    ss.deleteStudent(Long.parseLong(br.readLine()));
                }
                break;
                //exit
                case 6:
                    System.out.println("***********************************************");
                    System.out.println("----------Thank You For Using Our App----------");
                    System.out.println("***********************************************");
                    System.exit(0);
                default:
                    System.out.println("Please enter correct input...");
            }
        }

    }
}
