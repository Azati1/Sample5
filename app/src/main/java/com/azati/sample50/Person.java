package com.azati.sample50;

/**
 * Created by azati on 18.03.2018.
 */

public class Person {

    private String login;
    private String password;
    private String name;
    private String secondName;
    private int age;
    private int numberOfPhone;

    public Person(String login, String password, String name, String secondName,
                  int age, int numberOfPhone) {
        this.login = login;
        this.age = age;
        this.name = name;
        this.numberOfPhone = numberOfPhone;
        this.password = password;
        this.secondName = secondName;

    }

    public String getLogin() {
        return login;
    }

    public int getAge() {
        return age;
    }

    public int getNumberOfPhone() {
        return numberOfPhone;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSecondName() {
        return secondName;
    }
}
