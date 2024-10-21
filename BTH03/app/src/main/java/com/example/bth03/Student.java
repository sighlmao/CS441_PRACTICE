package com.example.bth03;

public class Student {
    private String id;
    private String name;
    private double gpa;
    private String gender;

    // Constructor, getters, and setters
    public Student(String id, String name, double gpa, String gender) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.gender = gender;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public String getGender() { return gender; }
}