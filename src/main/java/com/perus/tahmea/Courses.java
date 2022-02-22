package com.perus.tahmea;

public class Courses extends ParamClass {
    private String course;
    private String teacher;
    private int courseId;

    public Courses(String course, String teacher, int courseId) {
        this.course = course;
        this.teacher = teacher;
        this.courseId = courseId;
    }

    public Courses() {

    }

    public String getCourse() {
        return course;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getCourseId() {
        return courseId;
    }

    public String setCourses(String course, String teacher, String CourseId) {
        try {
            int id = Integer.parseInt(CourseId);
            if (id > coursesList.size() && id < coursesList.size() + 2) {
                Courses C = new Courses(course, teacher, id);
                coursesList.add(C);
                return successMsg + redirect;
            } else {
                return errorMsg + redirect;
            }
        } catch (Exception e) {
            return parseError + redirect;
        }
    }

    public String getCourses() {
        String CourseString = "";
        for (Courses e : coursesList) {
            CourseString += "<h1>Course Name: </h1>" + e.getCourse() + "<br>";
            CourseString += "<h1>Teacher name: </h1>" + e.getTeacher() + "<br>";
            CourseString += "<h1>Course id: </h1>" + e.getCourseId() + "<br><br>";
        }
        return CourseString + redirect;
    }

    public String deleteCourses(String CourseId) {
        try {
            int id = Integer.parseInt(CourseId);
            coursesList.remove(id - 1);
        } catch (Exception e) {
            return errorMsg + redirect;
        }

        return deleteMSG + redirect;
    }

    public String GetCourseById(String courseId) {
        int id = Integer.parseInt(courseId);
        Courses C = coursesList.get(id-1);
        String CourseName = "<br>Course Name: " + C.getCourse() + "<br>";
        return  CourseName;
    }
}
