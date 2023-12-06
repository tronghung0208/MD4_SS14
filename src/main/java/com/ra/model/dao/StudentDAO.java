package com.ra.model.dao;

import com.ra.model.entity.Student;
import com.ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IGenericDAO<Student, String> {
    @Override
    public List<Student> findALl() throws SQLException {
        Connection connection = null;
        List<Student> list = new ArrayList<>();
        try {
            connection = ConnectionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT *FROM students");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudent_id(rs.getString("student_id"));
                student.setStudent_name(rs.getString("student_name"));
                student.setGender(rs.getString("gender"));
                student.setAddress(rs.getString("address"));
                student.setCourse_id(rs.getString("course_id"));
                student.setScholarship(rs.getFloat("scholarship"));
                list.add(student);
            }


        } catch (SQLException s) {
            throw new RuntimeException(s);
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    @Override
    public Boolean save(Student student) {
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            String sql = "INSERT INTO student(student_id,student_name,gender,birth_day,address,course_id,scholarship) VALUES(?,?,?,?,?,?,?) ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, student.getStudent_id());
            pstm.setString(2, student.getStudent_name());
            pstm.setString(3, student.getGender());
            pstm.setDate(4, student.getBirth_day());
            pstm.setString(5, student.getAddress());
            pstm.setString(6, student.getCourse_id());
            pstm.setFloat(7, student.getScholarship());
            int check = pstm.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return false;
    }

    @Override
    public Student findId(String s) {
        return null;
    }

    @Override
    public Boolean update(Student student, String s) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
