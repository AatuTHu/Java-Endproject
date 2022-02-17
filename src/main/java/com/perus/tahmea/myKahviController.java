package com.perus.tahmea;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class myKahviController {

    List<Students> studentsList = new ArrayList<>();
    List<Courses> coursesList = new ArrayList<>();
    List<StudentToCourse> StoC = new ArrayList<>();

    @GetMapping("home")
    public String hello(){
        return "Hello to my javaEndgame";
    }

    @PostMapping("addStudents")
    public String addStudent(@RequestParam String fname, @RequestParam String lname, @RequestParam String StudentId){

        try {
            int id = Integer.parseInt(StudentId);
                if(id > studentsList.size() && id < studentsList.size()+2) {
                    Students S = new Students(fname,lname,id);
                    studentsList.add(S);
                    return "<h1>Student added</h1>";
            } else {
                return "No can do";
            }

        }catch (Exception e) {
            return "no can do";
        }
    }

    @GetMapping("Students")
    public List<Students> getStudents(){
        return studentsList;
    }

    @PostMapping("addCourses")
    public String addCourse(@RequestParam String course, @RequestParam String teacher, @RequestParam String CourseId) {

        try {
            int id = Integer.parseInt(CourseId);
            if(id > coursesList.size() && id < coursesList.size()+2) {
                Courses C = new Courses(course,teacher,id);
                coursesList.add(C);
                return "<h1>Course added</h1>";
            }else{
                return "No can do";
            }
        }catch (Exception e) {
            return "no can do";
        }
    }

    @GetMapping("Courses")
    public List<Courses> getCourses(){
        return coursesList;
    }

    @PostMapping("StoC")
    public String Stoc(@RequestParam String Course_Id, @RequestParam String Student_Id){

        try {
            int StuId = Integer.parseInt(Student_Id);
            int CouId = Integer.parseInt(Course_Id);

            StudentToCourse e = new StudentToCourse(
                    studentsList.get(StuId-1),
                    coursesList.get(CouId-1)
            );
            StoC.add(e);


        } catch (Exception e) {
            return e.getMessage();
        }

        return "Student added to course";

    }

    @GetMapping("getStoC")
    public List<StudentToCourse> getStoc() {
        return StoC;
    }

}
