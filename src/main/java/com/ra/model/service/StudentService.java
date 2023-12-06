package com.ra.model.service;

import com.ra.model.dao.StudentDAO;
import com.ra.model.entity.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService implements IGenericService<Student,String> {
    private StudentDAO studentDAO=new StudentDAO();
    @Override
    public List<Student> findAll() {
        try {
            return studentDAO.findALl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean save(Student student) {
        return studentDAO.save(student);
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
