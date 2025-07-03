package com.example.studentmanager;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testStudentGetters() {
        Student student = new Student("Test", 90.0);
        Assert.assertEquals("Test", student.getName());
        Assert.assertEquals(90.0, student.getGrade(), 0.01);
    }
}
