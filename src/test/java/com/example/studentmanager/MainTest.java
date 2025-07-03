package com.example.studentmanager;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        Constructor<Main> constructor = Main.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Main instance = constructor.newInstance();
        assertNotNull(instance);
    }
}
