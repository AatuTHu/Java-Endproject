package com.perus.tahmea;

public class ParamClass {

    /**
     * This probably is not a good way of doing things at all.
     * EmptinessCather checks if user input was empty
     * NumberCather checks if given names contain numbers
     */

    String redirect = "<a href='http://localhost:8080'><button> Return to main page</button></a>";
    String successMsg = "<h1>Addition was successful </h1>";
    String emptyInput = "<h1>You must give all the information, otherwise nothing will be done</h1>";
    String emptyDeletionMsg = "<h1>Nothing to be deleted, list is empty </h1>";
    String emptyListMsg = "<h1>There is nothing to show, list is empty</h1>";
    String emptyFileMsg = "<h1>File that you want to read is empty</h1>";
    String emptyFilingMsg = "<h1>There is nothing to file or you did not give both ids correctly</h1>";
    String numberCatherMsg = "<h1>I doubt that no one has numbers in their name</h1>";
    String errorMsg = "<h1>Something went wrong  </h1>";
    String deleteMSG = "<h1>Deletion was successful</h1>";
    String FileSuccess = "<h1>File successfully filed</h1>";


    public int EmptinessCather(String TestParam) {
        int Test = TestParam.length();
        if (Test == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public Boolean NumberCather(String NameParam) {
         return NameParam.matches(".*[0-9].*");
    }
}
