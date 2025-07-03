package com.example.studentmanager;

import java.util.List;

/**
 * Prints student information to the console.
 */
class ConsoleStudentPrinter implements StudentPrinter {
    @Override
    public void printStudents(final List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
