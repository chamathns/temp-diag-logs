package com.chamath.test;

import java.util.Map;

public class Person {

    private String name;
    private String address;
    private int age;
    private Map<String, String> details;

    public Person() {
    }

    public Person(String name, String address, int age, Map<String, String> details) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.details = details;
    }

    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }
}
