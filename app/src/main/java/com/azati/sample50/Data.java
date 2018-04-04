package com.azati.sample50;

import java.util.ArrayList;

/**
 * Created by azati on 02.04.2018.
 */

public class Data {
    public static ArrayList<Person> listOfPerson;
    public static ArrayList<String> listOfLogin;
    public static ArrayList<String> listOfPassword;

    public Data() {
        listOfLogin = new ArrayList<>();
        listOfPassword = new ArrayList<>();
        listOfPerson = new ArrayList<>();
    }
}
