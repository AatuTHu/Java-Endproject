package com.perus.tahmea;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * registration() register students to courses and save them to file.
 * GetInfo() return registered students
 */

@Service
public class FilerService extends ParamClass {


    public String registration(String info1, String info2) throws IOException {

        if (EmptinessCather(info1) == 0 || EmptinessCather(info2) == 0) { //if the string deliver are empty, then nothing can be done
            return emptyFilingMsg + redirect;
        } else { //write info to file
            FileWriter Writer = new FileWriter("filename.txt", true);
            Writer.append(info1);
            Writer.append(info2);
            Writer.close();
            return FileSuccess + redirect;
        }
    }

    public String GetInfo() {

        StringBuilder data = new StringBuilder();
        try {
            File Reader = new File("filename.txt");

            if(Reader.length() == 0) { //if file is empty, return info
                return emptyFileMsg + redirect;
            } else { //read what is written
                Scanner myReader = new Scanner(Reader);
                while (myReader.hasNextLine()) {
                    data.append(myReader.nextLine());
                }
                myReader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return errorMsg + redirect;
        }

        return data + "<br>" + redirect;

    }
}
