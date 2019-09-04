package com.example.demo.entity;

public class User {
    private String name;
    private String age;


    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public  User(){

    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
