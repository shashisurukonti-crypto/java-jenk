package com.example.student;

/**
 * Represents an individual student with ID, Name, and Department.
 */
public class Student {
    private int id;
    private String name;
    private String department;

    /**
     * Parameterized constructor to initialize student attributes.
     *
     * @param id         Unique student identifier
     * @param name       Full name of the student
     * @param department Department/Branch of study
     */
    public Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Returns formatted student details in the format: id - name - department.
     * Example: "101 - Sathvik - CSE"
     *
     * @return Formatted string of student details
     */
    public String getDetails() {
        return id + " - " + name + " - " + department;
    }
}
