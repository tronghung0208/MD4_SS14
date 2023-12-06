package com.ra.controller;

import com.ra.model.entity.Student;
import com.ra.model.service.StudentService;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentServlet", value = "/studentservlet")
public class StudentServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            request.setCharacterEncoding("utf-8");
            showListStudent(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        String student_id = request.getParameter("student_id");
        String student_name = request.getParameter("student_name");
        String gender = request.getParameter("gender");

        String dateStr = request.getParameter("birth_day");
        Date birth_day = null;

        if (dateStr != null && !dateStr.isEmpty()) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng của chuỗi ngày tháng

            try {
                birth_day = dateFormat.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace(); // Xử lý lỗi khi không thể chuyển đổi
                // Có thể thông báo lỗi cho người dùng hoặc xử lý lỗi khác tùy theo nhu cầu
            }
        }
        String address = request.getParameter("address");
        String course_id = request.getParameter("course_id");
        float scholarship = Float.parseFloat(request.getParameter("scholarship"));
        if (action == null) {
            studentService.save(new Student(student_id, student_name, gender, birth_day, address, course_id, scholarship));
            response.sendRedirect("/studentservlet");
        }
    }

    public void showListStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = studentService.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("views/student.jsp").forward(request, response);
    }
}