package com.azati.sample50;

import static com.azati.sample50.Data.listOfLogin;
import static com.azati.sample50.Data.listOfPassword;
import static com.azati.sample50.Data.listOfPerson;

/**
 * Created by azati on 18.03.2018.
 */

public class DataProcess {

    public static boolean login(String login, String password) {
        //Toast.makeText(this, "login: " + login + "\n" + "password: " + password);
        Boolean getPermission = false;

        listOfPerson.size();

        for (Person p : listOfPerson) {
            if (p.getLogin().equals(login) && p.getPassword().equals(password)) {
                getPermission = true;
                break;
            }
        }
        return getPermission;
    }

}
