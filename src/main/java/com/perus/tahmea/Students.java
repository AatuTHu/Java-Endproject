package com.perus.tahmea;

public class Students extends ParamClass {

    private String fname;
    private String lname;
    private String adress;
    private int StudentId=0;

    public Students(String fname, String lname,String adress, int studentId) {
        this.fname = fname;
        this.lname = lname;
        this.adress = adress;
        this.StudentId = studentId;
    }

    public Students(){

    }


    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getAdress() {
        return adress;
    }

    public int getStudentId() {
        return StudentId;
    }

    public String SetStudents(String fname, String lname, String adress) {
        try {

                Students S = new Students(fname, lname,adress, StudentId);
                studentsList.add(S);
                StudentId = StudentId+1;
                return successMsg + redirect;

        } catch (Exception e) {
            return errorMsg + redirect;

        }
    }

    public String GetStudents(){
        StringBuilder StudentString = new StringBuilder();
        for (Students e : studentsList) {
            StudentString.append("<p>Firstname: </p>").append(e.getFname()).append("<br>");
            StudentString.append("<p>Lastname: </p>").append(e.getLname()).append("<br>");
            StudentString.append("<p>Adress: </p>").append(e.getAdress()).append("<br>");
            StudentString.append("<p>StudentId: </p>").append(e.getStudentId()).append("<br><br>");
        }
        return StudentString + redirect;
    }

    public String DeleteStudents(int StudentId) {
        try {
            studentsList.remove(StudentId - 1);
        } catch (Exception e) {
            return errorMsg + redirect;
        }
        return deleteMSG + redirect;
    }

    public String GetStudentsById(String studentId) {
        try {
            int id = Integer.parseInt(studentId);
            Students S = studentsList.get(id-1);
            return "Name of The Student: " + S.getFname();
        } catch (Exception e) {
            return parseError + redirect;
        }
    }
}
