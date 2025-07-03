# Student Manager

This project is a simple Java application that manages a list of students and their corresponding grades. It provides functionality to add students and list all students along with their grades.

## Project Structure

```
student-manager
├── src
│   └── StudentManager.java
├── README.md
```

## Features

- **Add Student**: You can add a student along with their grade using the `addStudent(String s, double g)` method.
- **List Students**: You can list all added students and their grades using the `listStudents()` method.

## Usage

1. Compile the `StudentManager.java` file.
2. Run the application. It will create an instance of `StudentManager`, add a sample student, and display the list of students.

## Example

```java
StudentManager sm = new StudentManager();
sm.addStudent("John Doe", 85.5);
sm.listStudents();
```

This will output:

```
Student: John Doe, Grade: 85.5
```

## Requirements

- Java Development Kit (JDK) installed on your machine.

## License

This project is open-source and available for modification and distribution.