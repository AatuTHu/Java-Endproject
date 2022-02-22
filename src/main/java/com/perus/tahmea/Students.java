package com.perus.tahmea;

public class Students extends ParamClass {

    private String fname;
    private String lname;
    private int StudentId=0;

    public Students(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        this.StudentId = StudentId+1;
    }

    public Students(){

    }


    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getStudentId() {
        return StudentId;
    }

    public String SetStudents(String fname, String lname, String StudentId) {
        try {
            int id = Integer.parseInt(StudentId);
            if (id > studentsList.size() && id < studentsList.size() + 2) {
                Students S = new Students(fname, lname);
                studentsList.add(S);
                return successMsg + redirect;

            } else {
                return errorMsg + redirect;

            }

        } catch (Exception e) {
            return parseError+ redirect;

        }
    }

    public String GetStudents(){
        String StudentString = "";
        for (Students e : studentsList) {
            StudentString += "<h1>Firstname: </h1>" + e.getFname() + "<br>";
            StudentString += "<h1>Lastname: </h1>" + e.getLname() + "<br>";
            StudentString += "<h1>StudentId: </h1>" + e.getStudentId() + "<br><br>";
        }
        return StudentString + redirect;
    }

    public String DeleteStudents(String StudentId) {
        try {
            int id = Integer.parseInt(StudentId);
            studentsList.remove(id - 1);
        } catch (Exception e) {
            return errorMsg + redirect;
        }
        return deleteMSG + redirect;
    }

    public String GetStudentbyId(String studentId) {
        int id = Integer.parseInt(studentId);
        Students S = studentsList.get(id-1);
        String Student = "Name of The Student: " + S.getFname();
        return  Student;
    }
}
