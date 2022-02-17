package com.perus.tahmea;

public class StudentToCourse {
    private Object Students;
    private Object Courses;

    public StudentToCourse(Object students, Object courses) {
        Students = students;
        Courses = courses;
    }

    public Object getStudents() {
        return Students;
    }

    public Object getCourses() {
        return Courses;
    }
}
