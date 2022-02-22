package com.perus.tahmea;


import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class myKahviController {

    Courses C = new Courses();
    Students S = new Students();
    StudentToCourse StoC = new StudentToCourse();


    /**
     *
     * @return easter egg
     */
    @GetMapping("home")
    public String hello() {
        return "Hello to my javaEndgame";
    }

    /**
     *
     * @param fname Students firstname
     * @param lname Students Lastname
     * @param StudentId studentId
     * @return success or else
     */
    @PostMapping("addStudents")
    public String addStudents(@RequestParam String fname, @RequestParam String lname, @RequestParam String StudentId) {
        return S.SetStudents(fname,lname,StudentId);
    }

    /**
     *
     * @param StudentId id is used to find who is going to be deleted
     * @return success or error
     */
    @PostMapping("deleteStudents")
    public String deleteStudents(@RequestParam String StudentId) {
        return S.DeleteStudents(StudentId);
    }

    /**
     *
     * @return all students in readable form
     */
    @GetMapping("Students")
    public String getStudents() {
        return S.GetStudents();
    }

    /**
     *
     * @param course course name
     * @param teacher Teachers name
     * @param CourseId courseId
     * @return success or error
     */
    @PostMapping("addCourses")
    public String addCourses(@RequestParam String course, @RequestParam String teacher, @RequestParam String CourseId) {
        return C.setCourses(course,teacher,CourseId);
    }

    /**
     *
     * @param CourseId used to determinate which course is going to be deleted
     * @return success or error
     */
    @PostMapping("deleteCourses")
    public String deleteCourses(@RequestParam String CourseId) {
       return C.deleteCourses(CourseId);
    }

    /**
     *
     * @return  all courses in readable form
     */
    @GetMapping("Courses")
    public String getCourses() {
       return C.getCourses();
    }

    /**
     *
     * @param Course_Id which course
     * @param Student_Id which student
     * @return success or error
     */
    @PostMapping("StudentsToCourses")
    public String StudentsToCourses(@RequestParam String Course_Id, @RequestParam String Student_Id) throws IOException {
      String Register =  S.GetStudentbyId(Student_Id);
      Register += C.GetCourseById(Course_Id);
        return StoC.registration(Register);
    }

    /**
     *
     * @return String data
     */
    @GetMapping("getStudentsToCourses")
    public String getStudentstoCourses() {
        return StoC.GetInfo();
    }
}


