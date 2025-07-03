package com.example.studentmanager;

import org.junit.Assert;
import org.junit.Test;

public class GradeValidatorTest {

    @Test
    public void testValidGrade() {
        Student s = new Student("Ana", 90.0);
        GradeValidator validator = new GradeValidator();
        Assert.assertTrue(validator.isValid(s));
    }

    @Test
    public void testTooLowGrade() {
        Student s = new Student("Ana", -5.0);
        GradeValidator validator = new GradeValidator();
        Assert.assertFalse(validator.isValid(s));
    }

    @Test
    public void testTooHighGrade() {
        Student s = new Student("Ana", 105.0);
        GradeValidator validator = new GradeValidator();
        Assert.assertFalse(validator.isValid(s));
    }
}
