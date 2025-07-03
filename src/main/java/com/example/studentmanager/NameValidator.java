package com.example.studentmanager;


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
