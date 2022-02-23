package com.perus.tahmea;


import org.springframework.web.bind.annotation.*;
import java.io.IOException;


@RestController
public class myKahviController {

    Courses C = new Courses();
    Students S = new Students();
    FilerService StoC = new FilerService();


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
     * @param address Students Address
     * @return success or else
     */
    @PostMapping("addStudents")
    public String addStudents(@RequestParam String fname, @RequestParam String lname, @RequestParam String address) {
        return S.SetStudents(fname,lname,address);
    }

    /**
     *
     * @param StudentId id is used to find who is going to be deleted
     * @return success or error
     */
    @PostMapping("deleteStudents")
    public String deleteStudents(@RequestParam String StudentId) {

        try {
            return S.DeleteStudents(Integer.parseInt(StudentId));
        } catch (Exception e) {
            return "Id could not be parsed or does not exist";
        }
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
     * @param classRoom course Classroom name
     * @return success or error
     */
    @PostMapping("addCourses")
    public String addCourses(@RequestParam String course, @RequestParam String teacher, @RequestParam String classRoom) {
        return C.setCourses(course,teacher,classRoom);
    }

    /**
     *
     * @param CourseId used to determinate which course is going to be deleted
     * @return success or error
     */
    @PostMapping("deleteCourses")
    public String deleteCourses(@RequestParam String CourseId) {
        try {
            return C.deleteCourses(Integer.parseInt(CourseId));
        } catch (Exception e) {
            return "Id could not be parsed or does not exist";
        }
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
     * @Action files students to file and saves
     * @return success or error
     */
    @PostMapping("Filer")
    public String Filer(@RequestParam String Course_Id, @RequestParam String Student_Id) throws IOException {
      String Register =  S.GetStudentsById(Student_Id);
      Register += C.GetCourseById(Course_Id);
        return StoC.registration(Register);
    }

    /**
     *
     * @return File of students that has been added to courses
     */
    @GetMapping("getFiledStuff")
    public String getFiledStuff() {
        return StoC.GetInfo();
    }
}


