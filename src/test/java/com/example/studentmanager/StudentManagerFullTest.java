package com.example.studentmanager;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class StudentManagerFullTest {
    @Test
    public void testAddValidStudent() {
        List<StudentValidator> validators = Arrays.asList(new NameValidator(), new GradeValidator());
        StudentManager manager = new StudentManager(validators);
        Student s = new Student("Valido", 80.0);
        manager.addStudent(s);
        Assert.assertEquals(1, manager.getStudents().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidStudent() {
        List<StudentValidator> validators = Arrays.asList(new NameValidator(), new GradeValidator());
        StudentManager manager = new StudentManager(validators);
        Student s = new Student("", 150.0);
        manager.addStudent(s); // Esto debe lanzar excepción
    }
}
