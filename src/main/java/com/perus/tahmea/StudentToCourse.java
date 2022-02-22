package com.perus.tahmea;
import java.util.List;


public class StudentToCourse extends ParamClass {
    private String Students;
    private String Courses;


    public StudentToCourse() {

    }

    public String getStudents() {
        return Students;
    }

    public String getCourses() {
        return Courses;
    }

    public String registration(String Register) {

        StoC.add(Register);

        return successMsg + redirect;

    }

    public List<String> GetInfo() {

        return StoC;

    }
}
