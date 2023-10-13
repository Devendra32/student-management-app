package com.student.dao;

import com.student.conn.JDBCCon;
import com.student.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    Connection con;

    //create student
    public boolean saveStudent(Student st) {
        boolean flag = false;
        try {
            con = JDBCCon.craeteCon();

            String q = "insert into students(sname, sphone, scity) values (?,?,?)";

            //prepared statement
            PreparedStatement pstmt = con.prepareStatement(q);

            //set values
            pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());

            //execute
            pstmt.executeUpdate();
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    //find all students
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        try {
            con = JDBCCon.craeteCon();

            String q = "select * from students";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
                list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //find by Idrt5
    public Student findById(long id) {
        try {
            con = JDBCCon.craeteCon();

            String q = "select * from students where sid=?";

            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setLong(1, id);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean updateStudent(Student st) {
        boolean flag=false;
        try{
            con = JDBCCon.craeteCon();

            String q = "update students set sname=?, sphone=?, scity=? where sid=?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1,st.getStudentName());
            pstmt.setString(2,st.getStudentPhone());
            pstmt.setString(3,st.getStudentCity());
            pstmt.setInt(4, Integer.parseInt(String.valueOf(st.getStudentId())));

            pstmt.executeUpdate();
            flag = true;


        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteStudent(long id) {
        boolean flag=false;
        try{
            con = JDBCCon.craeteCon();

            String q = "delete from students where sid="+id;
            Statement stmt = con.createStatement();
            stmt.execute(q);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
