package com.perus.tahmea;

public class Courses {
    private String course;
    private String teacher;
    private int CourseId;

    public Courses(String course, String teacher, int courseId) {
        this.course = course;
        this.teacher = teacher;
        this.CourseId = courseId;
    }

    public String getCourse() {
        return course;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getCourseId() {
        return CourseId;
    }
}
