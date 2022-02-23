package com.perus.tahmea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  First six functions are basic, two constructors and four getters
 *
 *  SetStudents() add one number to index file and creates a list of students for later use
 *  GetStudents() Returns data in readable form
 *  deleteStudents() works if everytime you use index that starts from beginning 1 -->
 *  GetStudentsById() return data to for the filerService
 *  StudentIdFiler() one, if not very bad way to do auto-incrementation for id. When you start and add new course you continue from the last id.
 *  did that only because I was bored but interested in how you could use files for this kind of stuff.
 */

public class Students extends ParamClass {

    private String fname;
    private String lname;
    private String address;
    private int StudentId;

    public Students(String fname, String lname,String address, int studentId) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public int getStudentId() {
        return StudentId;
    }

    public String SetStudents(String fname, String lname, String adress) {
        try {
                StudentIdFiler(String.valueOf(StudentId));
                Students S = new Students(fname, lname,adress, StudentId);
                studentsList.add(S);
                return successMsg + redirect;

        } catch (Exception e) {
            return errorMsg + redirect;

        }
    }

    public String GetStudents(){
        StringBuilder StudentString = new StringBuilder();
        for (Students e : studentsList) {
            StudentString.append("<b>Firstname: </b>").append(e.getFname()).append("<br>");
            StudentString.append("<b>Lastname: </b>").append(e.getLname()).append("<br>");
            StudentString.append("<b>Address: </b>").append(e.getAddress()).append("<br>");
            StudentString.append("<b>StudentId: </b>").append(e.getStudentId()).append("<br><br>");
        }
        return StudentString + redirect;
    }

    public String DeleteStudents(int StudentId) {
        try {
            studentsList.remove(StudentId+1);
        } catch (Exception e) {
            return errorMsg + redirect;
        }
        return deleteMSG + redirect;
    }

    public String GetStudentsById(String studentId) {
        try {
            int Test = studentId.length();
            if (Test == 0) {
                return "";
            }
            int id = Integer.parseInt(studentId);
            if(id > studentsList.size() || id < studentsList.size()) {
                return "";

            } else {
                Students S = studentsList.get(id - 1);
                return "Name of The Student: " + S.getFname() + " " + S.getLname() + "<br>";
            }
        } catch (Exception e) {
            return parseError + redirect;
        }
    }

    private void StudentIdFiler(String id) throws IOException {
        File Reader = new File("IdStudents.txt");
            long checker = Reader.length();
                StudentId = Math.toIntExact(checker+1);
                FileWriter Writer = new FileWriter("IdStudents.txt", true);
            Writer.append(id);
        Writer.close();
    }
}
