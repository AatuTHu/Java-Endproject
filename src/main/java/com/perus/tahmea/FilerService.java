package com.perus.tahmea;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FilerService extends ParamClass {
    private String Students;
    private String Courses;


    public FilerService() {

    }

    public String getStudents() {
        return Students;
    }

    public String getCourses() {
        return Courses;
    }

    public String registration(String Register) throws IOException {

            FileWriter Writer = new FileWriter("filename.txt", true);
            Writer.append(Register);
            Writer.close();
            return FileSuccess + redirect;
    }

    public String GetInfo() {

        String data = "";

        try {
            File Reader = new File("filename.txt");
            Scanner myReader = new Scanner(Reader);
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
