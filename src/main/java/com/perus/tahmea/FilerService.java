package com.perus.tahmea;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FilerService extends ParamClass {

    public String registration(String Register) throws IOException {

        int Test = Register.length();
        if (Test == 0) {
            return errorMsg + redirect;
        } else {
            FileWriter Writer = new FileWriter("filename.txt", true);
            Writer.append(Register);
            Writer.close();
            return FileSuccess + redirect;
        }
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
