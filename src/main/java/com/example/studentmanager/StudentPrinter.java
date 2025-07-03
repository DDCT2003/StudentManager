package com.example.studentmanager;


import java.util.List;

/**
 * Interface for printing student information.
 */
interface StudentPrinter {
    /**
     * Prints the list of students.
     *
     * @param students list of students to print.
     */
    void printStudents(List<Student> students);
}
