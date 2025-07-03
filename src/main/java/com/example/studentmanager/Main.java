package com.example.studentmanager;

import java.util.ArrayList;
import java.util.Collections;
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

/**
 * Interface for student validation.
 */
interface StudentValidator {
    /**
     * Validates a student.
     *
     * @param student student to validate.
     * @return true if valid, false otherwise.
     */
    boolean isValid(Student student);
}

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

/**
 * Manages student registration.
 */
class StudentManager implements StudentRegistry {
    /** List of students. */
    private final List<Student> students = new ArrayList<Student>();
    /** List of validators. */
    private final List<StudentValidator> validators;

    /**
     * Constructor.
     *
     * @param validatorList list of validators.
     */
    StudentManager(final List<StudentValidator> validatorList) {
        this.validators = validatorList;
    }

    @Override
    public void addStudent(final Student student) {
        for (StudentValidator validator : validators) {
            if (!validator.isValid(student)) {
                throw new IllegalArgumentException(
                        "Estudiante no válido: " + student);
            }
        }
        students.add(student);
    }

    @Override
    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}

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

/**
 * Validates student names.
 */
class NameValidator implements StudentValidator {
    @Override
    public boolean isValid(final Student student) {
        return student.getName() != null
                && !student.getName().trim().isEmpty();
    }
}

/**
 * Validates student grades.
 */
class GradeValidator implements StudentValidator {
    /** Minimum allowed grade. */
    private static final double MIN_GRADE = 0.0;
    /** Maximum allowed grade. */
    private static final double MAX_GRADE = 100.0;

    @Override
    public boolean isValid(final Student student) {
        return student.getGrade() >= MIN_GRADE
                && student.getGrade() <= MAX_GRADE;
    }
}

/**
 * Main application class.
 */
public final class Main {
    /** Previene la instanciación de Main. */
    private Main() {
        // Constructor privado para Checkstyle
    }

    /** John's grade (avoid magic number). */
    private static final double JOHN_GRADE = 85.5;
    /** Jane's grade (avoid magic number). */
    private static final double JANE_GRADE = 91.2;

    /**
     * Main method.
     *
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        List<StudentValidator> validators = new ArrayList<StudentValidator>();
        validators.add(new NameValidator());
        validators.add(new GradeValidator());

        StudentRegistry manager = new StudentManager(validators);
        StudentPrinter printer = new ConsoleStudentPrinter();

        try {
            manager.addStudent(new Student("John Doe", JOHN_GRADE));
            manager.addStudent(new Student("Jane Doe", JANE_GRADE));
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        printer.printStudents(manager.getStudents());
    }
}
