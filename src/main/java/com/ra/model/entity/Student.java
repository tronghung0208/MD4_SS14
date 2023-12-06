package com.ra.model.entity;

import java.util.Date;

public class Student {
    private String student_id;
    private String student_name;
    private  String gender;
    private Date birth_day;
    private String address;
    private String course_id;
    private float scholarship;

    public Student() {
    }
    public Student(String student_id, String student_name, String gender, Date birth_day, String address, String course_id, float scholarship) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.gender = gender;
        this.birth_day = birth_day;
        this.address = address;
        this.course_id = course_id;
        this.scholarship = scholarship;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public java.sql.Date getBirth_day() {
        return (java.sql.Date) birth_day;
    }

    public void setBirth_day(Date birth_day) {
        this.birth_day = birth_day;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public float getScholarship() {
        return scholarship;
    }

    public void setScholarship(float scholarship) {
        this.scholarship = scholarship;
    }
}
