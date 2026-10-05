package com.example.student;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of students using an ArrayList.
 * Supports adding, searching, listing, removing, and counting students.
 */
public class StudentManager {
    private final List<Student> students;

    /**
     * Initializes an empty list of students.
     */
    public StudentManager() {
        this.students = new ArrayList<>();
    }

    /**
     * Adds a student to the collection.
     *
     * @param student The student object to add
     */
    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        }
    }

    /**
     * Finds a student by their unique ID.
     *
     * @param id The ID of the student to search for
     * @return The Student object if found, or null if not found
     */
    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    /**
     * Returns a list of all students currently in the manager.
     *
     * @return List containing all students
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    /**
     * Removes a student by their unique ID.
     *
     * @param id The ID of the student to remove
     * @return true if student was found and removed, false otherwise
     */
    public boolean removeStudentById(int id) {
        Student studentToRemove = findStudentById(id);
        if (studentToRemove != null) {
            return students.remove(studentToRemove);
        }
        return false;
    }

    /**
     * Returns the total number of students currently managed.
     *
     * @return Current student count
     */
    public int getStudentCount() {
        return students.size();
    }
}
