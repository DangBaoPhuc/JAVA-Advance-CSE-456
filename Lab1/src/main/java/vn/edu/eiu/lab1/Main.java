package vn.edu.eiu.lab1;

import com.fasterxml.jackson.core.JsonProcessingException;
import vn.edu.eiu.lab1.entity.Course;
import vn.edu.eiu.lab1.entity.Student;
import com.fasterxml.jackson.databind.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("S001", "Alice", "Nguyen", 2002, 3.6);
        Student student2 = new Student("S002", "Bob", "Tran", 2001, 3.8);
        Student student3 = new Student("S003", "Charlie", "Le", 2003, 3.4);

        // Create 2 courses
        Course course1 = new Course("C001", "Introduction to Java", 3, 45.0);
        Course course2 = new Course("C002", "Database Systems", 4, 60.0);

        // Print student info
        System.out.println("Students:");
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());

        // Print course info
        System.out.println("\nCourses:");
        System.out.println(course1.toString());
        System.out.println(course2.toString());

        // JackSon
//1. Object -> Json
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert Student to JSON string
            String json = mapper.writeValueAsString(student1);

            // Print the JSON
            System.out.println("Student as JSON:");
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String json = """
            {
              "id": "S002",
              "firstName": "Alice",
              "lastName": "Nguyen",
              "yearOfBirth": 2001,
              "gpa": 3.9
            }
            """;


        try {
            // Deserialize JSON to Student object
            Student student = mapper.readValue(json, Student.class);

            // Print student info
            System.out.println("Deserialized Student object:");
            System.out.println(student.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Connection conn = null;
        //Sử dụng các class cung cấp sẵn có trong thư viên JDBC (có trong JAVA SDK)
        //JDBC sẽ tự động kết nối với MySQL JDBC Server (MySQL connector/java)
        try {
            String url = "jdbc:mysql://localhost:3306/Lab1";

            //Đối với Java mới thì Driver sẽ được tự động dò tìm trong URL mà ko cần lệnh này.
            //Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url,"root","12345678");
            System.out.println("Connected to database successfully");

            //Sau khi kết nối thành công thì tiếp tục thực hiện truy vấn bằng SQL
            //Tạo Class PreparedStatement để thực hiện câu truy vấn.
            PreparedStatement pstmt = conn.prepareStatement("select * from Student");

            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                System.out.print(rs.getString(1));
//                System.out.print(rs.getString(2));
//                System.out.print(rs.getString(3));
//                System.out.print(rs.getString(4));
//                System.out.println(rs.getString(5));
//            }
//            while (rs.next()) {
//                String code = rs.getString("code");
//                String name = rs.getString("name");
//                int Credits = rs.getInt("Credits");
//                int StudyHours = rs.getInt("StudyHours");
//                System.out.println(code + "|" + name + "|" + Credits + "|" + StudyHours);
////                System.out.printf("|%10s|%-40s|%2d|%4d|\n",code,name,Credits,StudyHours);
//
//            }
            while (rs.next()) {
                String id = rs.getString("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int yearOfBirth = rs.getInt("YOB");
                double gpa = rs.getDouble("gpa");

                Student student = new Student(id, firstName, lastName, yearOfBirth, gpa);
                System.out.println(student);
            }

            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }


