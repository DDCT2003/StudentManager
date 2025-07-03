package com.example.studentmanager;

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
