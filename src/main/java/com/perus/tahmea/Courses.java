package com.perus.tahmea;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  First six functions are basic, two constructors and four getters
 *
 *  setCourses() creates a list of courses for later use
 *  getCourses() Returns data in readable form
 *  deleteCourses() delete last addition
 *  GetCoursesById() return data to for the filerService
 *
 */

@Service
public class Courses extends ParamClass {

    List<Courses> coursesList = new ArrayList<>();

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
            if(NumberCather(teacher)) {return numberCatherMsg + " <h1>( teachers name )<h1>" + redirect;}
                if(EmptinessCather(course) == 0 || EmptinessCather(teacher)==0 || EmptinessCather(classRoom) == 0) {
                    return emptyInput + redirect;
            } else {
                courseId = courseId + 1;
                Courses C = new Courses(course, teacher, classRoom, courseId);
                coursesList.add(C);
                return successMsg + redirect;
            }
        } catch (Exception e) {
            return errorMsg + redirect;
        }
    }

    public String getCourses() {
        StringBuilder CourseString = new StringBuilder();
        if(coursesList.isEmpty()) {
            return emptyListMsg + redirect;
        } else {
            for (Courses e : coursesList) {
                CourseString.append("<b>Course Name: </b>").append(e.getCourse()).append("<br>");
                CourseString.append("<b>Teacher name: </b>").append(e.getTeacher()).append("<br>");
                CourseString.append("<b>Classroom: </b>").append(e.getClassRoom()).append("<br>");
                CourseString.append("<b>Course id: </b>").append(e.getCourseId()).append("<br><br>");
            }
        }
        return CourseString + redirect;
    }

    public String deleteCourses() {
        try {
            int index = coursesList.size();
            if(index == 0) { return emptyDeletionMsg + redirect; }

            coursesList.remove(index-1);
            courseId = courseId - 1;
        } catch (Exception e) {
            return errorMsg + redirect;
        }
        return deleteMSG + redirect;
    }

    public String GetCourseById(String courseId) {
        try {
            if (EmptinessCather(courseId) == 0) {
              return "";
            }
                int id = Integer.parseInt(courseId);
                    if(id > coursesList.size() || id < 0) {
                        return "";
                    } else {
                        Courses C = coursesList.get(id-1);
                        return "Course Name: " + C.getCourse() + "<br>" + "Classroom: " + C.getClassRoom() +"<br>"+"Course Teacher: " +C.getTeacher()+"<br><br>";
                    }
        } catch (Exception e) {
            return "";
        }

    }


}
