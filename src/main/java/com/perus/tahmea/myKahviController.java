package com.perus.tahmea;


import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class myKahviController {

    String redirect = "<a href='http://localhost:8080'><button> Return to main page</button></a>";
    String successMsg = "<h1>Addition was successful </h1>";
    String errorMsg = "<h1>Something went wrong  </h1>";
    String deleteMSG = "<h1>Deletion was successful</h1>";
    String parseError = "<h1>Id given could not be parsed or was not in chronological order</h1>";
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
                return successMsg + redirect;

            } else {
                return errorMsg + redirect;

            }

        } catch (Exception e) {
            return parseError+ redirect;

        }
    }

    /**
     *
     * @param StudentId id is used to find who is going to be deleted
     * @return success or error
     */
    @PostMapping("deleteStudents")
    public String deleteStudents(@RequestParam String StudentId) {
        try {
            int id = Integer.parseInt(StudentId);
            studentsList.remove(id - 1);
        } catch (Exception e) {
            return errorMsg + redirect;
        }
        return deleteMSG + redirect;

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
        return StudentString + redirect;
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
                return successMsg + redirect;
            } else {
                return errorMsg + redirect;
            }
        } catch (Exception e) {
            return parseError + redirect;
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
            return errorMsg + redirect;
        }

        return deleteMSG + redirect;
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
        return CourseString + redirect;
    }

    /**
     *
     * @param Course_Id which course
     * @param Student_Id which student
     * @return success or error
     */
    @PostMapping("StudentsToCourses")
    public String StudentsToCourses(@RequestParam String Course_Id, @RequestParam String Student_Id) {

        try {
            int StuId = Integer.parseInt(Student_Id);
            int CouId = Integer.parseInt(Course_Id);

                     Students S  = studentsList.get(StuId - 1);
                     Courses C = coursesList.get(CouId - 1);

                         String Palautus = S.getFname();
                         String Palautus1 = C.getCourse();

                         StudentToCourse F = new StudentToCourse(Palautus,Palautus1);
                         StoC.add(F);

        } catch (Exception e) {
            return errorMsg + redirect;
        }

        return successMsg + redirect;

    }

    /**
     *
     * @return String data
     */
    @GetMapping("getStudentsToCourses")
    public String getStudentstoCourses() {

        String CourseString = "";
        for (StudentToCourse e : StoC) {
            CourseString += "<h1>Student Name: </h1>" + e.getStudents() + "<br>";
            CourseString += "<h1>Course name: </h1>" + e.getCourses() + "<br><br>";
        }
        return CourseString + redirect;



    }
}


