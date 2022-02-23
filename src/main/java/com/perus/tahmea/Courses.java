package com.perus.tahmea;

public class Courses extends ParamClass {
    private String course;
    private String teacher;
    private String classRoom;
    private int courseId = 1;

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

                Courses C = new Courses(course, teacher,classRoom,courseId);
                coursesList.add(C);
                courseId = courseId+1;
                return successMsg + redirect;
        } catch (Exception e) {
            return errorMsg + redirect;
        }
    }

    public String getCourses() {
        StringBuilder CourseString = new StringBuilder();
        for (Courses e : coursesList) {
            CourseString.append("<h1>Course Name: </h1>").append(e.getCourse()).append("<br>");
            CourseString.append("<h1>Teacher name: </h1>").append(e.getTeacher()).append("<br>");
            CourseString.append("<h1>Classroom: </h1>").append(e.getClassRoom()).append("<br>");
            CourseString.append("<h1>Course id: </h1>").append(e.getCourseId()).append("<br><br>");
        }
        return CourseString + redirect;
    }

    public String deleteCourses(int CourseId) {
        try {
            coursesList.remove(CourseId-1);
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
                return "<br>Course Name: " + C.getCourse() + "<br>";

            }

        } catch (Exception e) {
            return errorMsg + redirect;
        }

    }
}
