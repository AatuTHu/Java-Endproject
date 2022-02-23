package com.perus.tahmea;
import java.util.ArrayList;
import java.util.List;

public class ParamClass {

    String redirect = "<a href='http://localhost:8080'><button> Return to main page</button></a>";
    String successMsg = "<h1>Addition was successful </h1>";
    String errorMsg = "<h1>Something went wrong  </h1>";
    String deleteMSG = "<h1>Deletion was successful</h1>";
    String FileSuccess = "<h1>File successfully filed</h1>";
    String parseError = "<h1>Id given could not be parsed or was not in chronological order</h1>";
    List<Students> studentsList = new ArrayList<>();
    List<Courses> coursesList = new ArrayList<>();
}
