package com.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the StudentManager class using JUnit 5.
 */
public class StudentManagerTest {

    private StudentManager manager;
    private Student student1;
    private Student student2;

    @BeforeEach
    void setUp() {
        manager = new StudentManager();
        student1 = new Student(101, "Sathvik", "CSE");
        student2 = new Student(102, "Pooja", "ISE");
    }

    @Test
    void testAddStudent() {
        manager.addStudent(student1);
        assertEquals(1, manager.getStudentCount(), "Count should be 1 after adding a student");
        Student retrieved = manager.findStudentById(101);
        assertNotNull(retrieved, "Retrieved student should not be null");
        assertEquals("Sathvik", retrieved.getName(), "Retrieved student's name should match");
    }

    @Test
    void testFindStudentById() {
        manager.addStudent(student1);
        manager.addStudent(student2);

        Student found = manager.findStudentById(101);
        assertNotNull(found, "Student with ID 101 should be found");
        assertEquals("Sathvik", found.getName());
        assertEquals("CSE", found.getDepartment());
    }

    @Test
    void testFindNonExistentStudent() {
        manager.addStudent(student1);
        Student found = manager.findStudentById(999);
        assertNull(found, "Searching for an unregistered ID should return null");
    }

    @Test
    void testRemoveStudentById() {
        manager.addStudent(student1);
        manager.addStudent(student2);
        assertEquals(2, manager.getStudentCount());

        boolean isRemoved = manager.removeStudentById(101);
        assertTrue(isRemoved, "removeStudentById should return true when student is removed");
        assertEquals(1, manager.getStudentCount(), "Count should decrease to 1");
        assertNull(manager.findStudentById(101), "Removed student should no longer be found");

        boolean removeAgain = manager.removeStudentById(999);
        assertFalse(removeAgain, "Removing non-existent student should return false");
    }

    @Test
    void testGetAllStudents() {
        manager.addStudent(student1);
        manager.addStudent(student2);

        List<Student> students = manager.getAllStudents();
        assertNotNull(students, "Student list should not be null");
        assertEquals(2, students.size(), "Student list size should match the number of added students");
    }

    @Test
    void testGetStudentCount() {
        assertEquals(0, manager.getStudentCount(), "Initial count should be 0");
        manager.addStudent(student1);
        assertEquals(1, manager.getStudentCount(), "Count should be 1");
        manager.addStudent(student2);
        assertEquals(2, manager.getStudentCount(), "Count should be 2");
    }
}
