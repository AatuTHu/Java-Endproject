package com.perus.tahmea;


import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class myKahviController {

    List<Students> studentsList = new ArrayList<>();
    List<Courses> coursesList = new ArrayList<>();
    List<StudentToCourse> StoC = new ArrayList<>();

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

        try {
            int id = Integer.parseInt(StudentId);
            if (id > studentsList.size() && id < studentsList.size() + 2) {
                Students S = new Students(fname, lname, id);
                studentsList.add(S);
                return "<h1>Student added</h1>";
            } else {
                return "No can do";
            }

        } catch (Exception e) {
            return "no can do";
        }
    }

    /**
     *
     * @param StudentId id is used to find who is going to be deleted
     * @return succes or error
     */
    @PostMapping("deleteStudents")
    public String deleteStudents(@RequestParam String StudentId) {
        try {
            int id = Integer.parseInt(StudentId);
            studentsList.remove(id - 1);
        } catch (Exception e) {
            return "You have made an error";
        }
        return "Succes";
    }

    /**
     *
     * @return all students in readable form
     */
    @GetMapping("Students")
    public String getStudents() {
        String StudentString = "";
        for (Students e : studentsList) {
            StudentString += "<h1>Firstname: </h1>" + e.getFname() + "<br>";
            StudentString += "<h1>Lastname: </h1>" + e.getLname() + "<br>";
            StudentString += "<h1>StudentId: </h1>" + e.getStudentId() + "<br><br>";
        }
        return StudentString;
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

        try {
            int id = Integer.parseInt(CourseId);
            if (id > coursesList.size() && id < coursesList.size() + 2) {
                Courses C = new Courses(course, teacher, id);
                coursesList.add(C);
                return "<h1>Course added</h1>";
            } else {
                return "No can do";
            }
        } catch (Exception e) {
            return "no can do";
        }
    }

    /**
     *
     * @param CourseId used to determinate which course is going to be deleted
     * @return success or error
     */
    @PostMapping("deleteCourses")
    public String deleteCourses(@RequestParam String CourseId) {

        try {
            int id = Integer.parseInt(CourseId);
            coursesList.remove(id - 1);
        } catch (Exception e) {
            return "You have made an error";
        }

        return "Succes";
    }

    /**
     *
     * @return  all courses in readable form
     */
    @GetMapping("Courses")
    public String getCourses() {
        String CourseString = "";
        for (Courses e : coursesList) {
            CourseString += "<h1>Course Name: </h1>" + e.getCourse() + "<br>";
            CourseString += "<h1>Teacher name: </h1>" + e.getTeacher() + "<br>";
            CourseString += "<h1>Course id: </h1>" + e.getCourseId() + "<br><br>";
        }
        return CourseString;
    }

    /**
     *
     * @param Course_Id which course
     * @param Student_Id which student
     * @return success or error
     */
    @PostMapping("StudentstoCourses")
    public String StudentstoCourses(@RequestParam String Course_Id, @RequestParam String Student_Id) {

        try {
            int StuId = Integer.parseInt(Student_Id);
            int CouId = Integer.parseInt(Course_Id);

            StudentToCourse e = new StudentToCourse(
                    studentsList.get(StuId - 1),
                    coursesList.get(CouId - 1)
            );
            StoC.add(e);

        } catch (Exception e) {
            return e.getMessage();
        }

        return "Student added to course";

    }

    /**
     *
     * @return list data
     */
    @GetMapping("getStudentstoCourses")
    public List<StudentToCourse> getStudentstoCourses() {
        return StoC;
    }
}


