package com.example.studentmanager;

import org.junit.Test;
import java.util.Collections;

public class ConsoleStudentPrinterTest {
    @Test
    public void testPrintEmptyList() {
        ConsoleStudentPrinter printer = new ConsoleStudentPrinter();
        printer.printStudents(Collections.emptyList());
    }

    @Test
    public void testPrintStudent() {
        ConsoleStudentPrinter printer = new ConsoleStudentPrinter();
        Student s = new Student("Valido", 95.0);
        printer.printStudents(Collections.singletonList(s));
    }
}
