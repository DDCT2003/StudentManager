package com.example.studentmanager;

import java.util.List;

/**
 * Interface for student registration operations.
 */
interface StudentRegistry {
    /**
     * Adds a student.
     *
     * @param student the student to add.
     */
    void addStudent(Student student);

    /**
     * Returns the list of students.
     *
     * @return unmodifiable list of students.
     */
    List<Student> getStudents();
}