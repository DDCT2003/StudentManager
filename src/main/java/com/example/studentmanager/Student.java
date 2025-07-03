package com.example.studentmanager;

/**
 * Student entity class.
 */
class Student {
    /** Name of the student. */
    private final String name;
    /** Grade of the student. */
    private final double grade;

    /**
     * Constructor.
     *
     * @param studentName  name of the student.
     * @param studentGrade grade of the student.
     */
    Student(final String studentName, final double studentGrade) {
        this.name = studentName;
        this.grade = studentGrade;
    }

    /**
     * Gets the student's name.
     *
     * @return the name.
     */
    String getName() {
        return name;
    }

    /**
     * Gets the student's grade.
     *
     * @return the grade.
     */
    double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Estudiante: " + name + ", Calificación: " + grade;
    }
}