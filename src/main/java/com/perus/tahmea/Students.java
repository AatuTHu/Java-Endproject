package com.perus.tahmea;

public class Students {

    private String fname;
    private String lname;
    private int StudentId;


    public Students(String fname, String lname, int studentId) {
        this.fname = fname;
        this.lname = lname;
        this.StudentId = studentId;
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
}