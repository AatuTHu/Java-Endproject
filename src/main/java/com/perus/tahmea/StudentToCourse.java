package com.perus.tahmea;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class StudentToCourse extends ParamClass {
    private String Students;
    private String Courses;


    public StudentToCourse() {

    }

    public String getStudents() {
        return Students;
    }

    public String getCourses() {
        return Courses;
    }

    public String registration(String Register) throws IOException {

            FileWriter myWriter = new FileWriter("filename.txt", true);
            myWriter.append(Register + System.lineSeparator());
            myWriter.close();

            return successMsg + redirect;


    }

    public String GetInfo() {

        String data = "";

        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return errorMsg + redirect;
        }

        return data + "<br>" + redirect;

    }
}
