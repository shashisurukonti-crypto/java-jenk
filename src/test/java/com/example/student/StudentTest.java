package com.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit tests for the Student class using JUnit 5.
 */
public class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student(101, "Sathvik", "CSE");
    }

    @Test
    void testStudentCreation() {
        assertNotNull(student, "Student instance should not be null after initialization");
    }

    @Test
    void testStudentId() {
        assertEquals(101, student.getId(), "Student ID should match the initialized value");
        student.setId(102);
        assertEquals(102, student.getId(), "Student ID should match the updated value");
    }

    @Test
    void testStudentName() {
        assertEquals("Sathvik", student.getName(), "Student name should match the initialized value");
        student.setName("Rahul");
        assertEquals("Rahul", student.getName(), "Student name should match the updated value");
    }

    @Test
    void testStudentDepartment() {
        assertEquals("CSE", student.getDepartment(), "Student department should match the initialized value");
        student.setDepartment("ECE");
        assertEquals("ECE", student.getDepartment(), "Student department should match the updated value");
    }

    @Test
    void testGetDetails() {
        String expectedDetails = "101 - Sathvik - CSE";
        assertEquals(expectedDetails, student.getDetails(), "getDetails() must return format 'id - name - department'");
    }
}
