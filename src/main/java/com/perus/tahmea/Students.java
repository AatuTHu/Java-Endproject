package com.perus.tahmea;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  First six functions are basic, two constructors and four getters
 *
 *  SetStudents() creates a list of students for later use
 *  GetStudents() Returns data in readable form
 *  deleteStudents() Delete last addition
 *  GetStudentsById() return data to for the filerService
 *
 */

@Service
public class Students extends ParamClass {

    List<Students> studentsList = new ArrayList<>();

    private String fname;
    private String lname;
    private String address;
    private int StudentId=0;

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

    public String SetStudents(String fname, String lname, String address) {
        try {
            if(NumberCather(fname) || NumberCather(lname)) { //we do not accept names with numbers
                return numberCatherMsg + redirect;
            } else if(EmptinessCather(fname) == 0 || EmptinessCather(lname)==0 || EmptinessCather(address) == 0) { // check if the inputs are empty
                return emptyInput + redirect;
            } else { //add students to list and auto-increment id for usage in other functions
                StudentId = StudentId + 1;
                Students S = new Students(fname, lname, address, StudentId);
                studentsList.add(S);
                return successMsg + redirect;
            }

        } catch (Exception e) {
            return errorMsg + redirect;

        }
    }

    public String GetStudents() {
        StringBuilder StudentString = new StringBuilder();

        if (studentsList.isEmpty()) { //check if the list is empty.
            return emptyListMsg + redirect;
        } else {
            for (Students e : studentsList) { // make a readable string of student currently on list
                StudentString.append("<b>Firstname: </b>").append(e.getFname()).append("<br>");
                StudentString.append("<b>Lastname: </b>").append(e.getLname()).append("<br>");
                StudentString.append("<b>Address: </b>").append(e.getAddress()).append("<br>");
                StudentString.append("<b>StudentId: </b>").append(e.getStudentId()).append("<br><br>");
            }
        }
        return StudentString + redirect;
    }

    public String DeleteStudents() {
        try {

            if(studentsList.isEmpty()) { //check if the list is empty
                return emptyDeletionMsg + redirect;
            }else{ // remove last student on the list and set student id -1 so next registered student is in chronological order
                studentsList.remove(studentsList.size() - 1);
                StudentId = StudentId - 1;
            }
        } catch (Exception e) {
            return errorMsg + redirect;
        }
            return deleteMSG + redirect;
    }

    public String GetStudentsById(String studentId) {
        try {
            int id = Integer.parseInt(studentId);

            if (EmptinessCather(studentId) == 0){  //check if the input was empty
                return "";
                    }else if(id > studentsList.size() || id < 0 ) { //check that the id given is not too high or low
                        return "";
                            }else{ // get student information based on passed id
                                Students S = studentsList.get(id-1);
                                return "Name of The Student: " + S.getFname() + " " + S.getLname() + "<br>";
                }

        } catch (Exception e) {
             return "";
        }
    }


}
