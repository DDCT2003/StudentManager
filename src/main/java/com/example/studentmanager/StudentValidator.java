package com.example.studentmanager;

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