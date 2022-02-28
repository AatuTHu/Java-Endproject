package com.perus.tahmea;


import org.springframework.web.bind.annotation.*;
import java.io.IOException;

/**
 *  id given to new students is active, it only lasts for the time that the program is running.
 *  I didn't figure out a way to use it for lasting purposes other than cosmetic.
 *  I could have made another id but in my mind that would be too confusing.
 *
 *  Students and courses are not filed because I think that one filer is enough for this.
 *  Decision to make last index deletion was made because it is just easier than thinking how to give students and courses new active id.
 *
 *  Everything done in this project was done by me. I had no prior knowledge of java coding other than lectures.
 */


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
        return "Hello Reiska";
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

    @PostMapping("updateStudents")
    public String updateStudents(@RequestParam String fname, @RequestParam String lname, @RequestParam String address) {
        return  S.UpdateStudents(fname,lname,address);
    }

    /**
     *
     * Delete last index on list
     * @return success or error
     */
    @GetMapping("deleteStudents")
    public String deleteStudents() {
        try {
            return S.DeleteStudents();
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

    @PostMapping("updateCourses")
    public String updateCourses(@RequestParam String course, @RequestParam String teacher, @RequestParam String classRoom) {
        return C.updateCourses(course,teacher,classRoom);
    }
    /**
     *
     * Delete last index
     * @return success or error
     */
    @GetMapping("deleteCourses")
    public String deleteCourses() {
        try {
            return C.deleteCourses();
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
      String info1 =  S.GetStudentsById(Student_Id);
      String info2 = C.GetCourseById(Course_Id);
      return StoC.registration(info1,info2);
    }

    /**
     *
     * @return File of students that have been added to courses
     */
    @GetMapping("getFiledStuff")
    public String getFiledStuff() {
        return StoC.GetInfo();
    }

    @GetMapping("deleteFiledStuff")
    public String deleteFileContent(){
        return StoC.deleteFileContent();
    }
}


