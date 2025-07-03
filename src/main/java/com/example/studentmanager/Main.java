package com.example.studentmanager;
import java.util.ArrayList;
import java.util.List;

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
