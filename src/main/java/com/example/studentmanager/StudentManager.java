package com.example.studentmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
