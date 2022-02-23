package com.perus.tahmea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  First six functions are basic, two constructors and four getters
 *
 *  setCourses() add one number to index file and creates a list of courses for later use
 *  getCourses() Returns data in readable form
 *  deleteCourses() delete last addition
 *  GetCoursesById() return data to for the filerService
 *
 */

public class Courses extends ParamClass {
    private String course;
    private String teacher;
    private String classRoom;
    private int courseId=0;



    public Courses(String course, String teacher, String classRoom ,int courseId) {
        this.course = course;
        this.teacher = teacher;
        this.classRoom = classRoom;
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

    public String getClassRoom() {
        return classRoom;
    }

    public int getCourseId() {
        return courseId;
    }

    public String setCourses(String course, String teacher, String classRoom) {
        try {
                courseId = courseId+1;
                Courses C = new Courses(course, teacher,classRoom,courseId);
                coursesList.add(C);
                return successMsg + redirect;
        } catch (Exception e) {
            return errorMsg + redirect;
        }
    }

    public String getCourses() {
        StringBuilder CourseString = new StringBuilder();
        for (Courses e : coursesList) {
            CourseString.append("<b>Course Name: </b>").append(e.getCourse()).append("<br>");
            CourseString.append("<b>Teacher name: </b>").append(e.getTeacher()).append("<br>");
            CourseString.append("<b>Classroom: </b>").append(e.getClassRoom()).append("<br>");
            CourseString.append("<b>Course id: </b>").append(e.getCourseId()).append("<br><br>");
        }
        return CourseString + redirect;
    }

    public String deleteCourses() {
        try {
            int index = coursesList.size();
            coursesList.remove(index-1);
        } catch (Exception e) {
            return errorMsg + redirect;
        }
        return deleteMSG + redirect;
    }

    public String GetCourseById(String courseId) {
        try {
            int Test = courseId.length();
            if (Test == 0) {
              return "";
            }

            int id = Integer.parseInt(courseId);
            if(id > coursesList.size() || id < coursesList.size()) {
                return "";
            } else {
                Courses C = coursesList.get(id-1);
                return "Course Name: " + C.getCourse() + "<br>" + "Classroom: " + C.getClassRoom() +"<br>";
            }
        } catch (Exception e) {
            return errorMsg + redirect;
        }

    }


}
