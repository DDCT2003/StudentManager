package com.example.studentmanager;

import org.junit.Assert;
import org.junit.Test;

public class NameValidatorTest {

    @Test
    public void testValidName() {
        Student s = new Student("Carlos", 70.0);
        NameValidator validator = new NameValidator();
        Assert.assertTrue(validator.isValid(s));
    }

    @Test
    public void testNullName() {
        Student s = new Student(null, 70.0);
        NameValidator validator = new NameValidator();
        Assert.assertFalse(validator.isValid(s));
    }

    @Test
    public void testEmptyName() {
        Student s = new Student("   ", 70.0);
        NameValidator validator = new NameValidator();
        Assert.assertFalse(validator.isValid(s));
    }
}
