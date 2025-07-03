package com.example.studentmanager;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testGetNameAndGrade() {
        Student s = new Student("Ana", 95.5);
        Assert.assertEquals("Ana", s.getName());
        Assert.assertEquals(95.5, s.getGrade(), 0.01);
    }

    @Test
    public void testToString() {
        Student s = new Student("Luis", 88.0);
        String expected = "Estudiante: Luis, Calificación: 88.0";
        Assert.assertEquals(expected, s.toString());
    }
}
