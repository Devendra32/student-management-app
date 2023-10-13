package com.student.conn;


import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCCon {
    static Connection con;

    public static Connection craeteCon(){
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver loaded...");
            //Create the connection
            String URL = "jdbc:mysql://localhost:3306/student_db?verifyServerCertificate=false&useSSL=true";
            String USERNAME = "root";
            String PASSWORD = "root";
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            System.out.println("Connection Created...");

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return con;
    }

}
