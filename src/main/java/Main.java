import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// ISP: Interfaz para las operaciones de registro
interface StudentRegistry {
    void addStudent(Student student);

    List<Student> getStudents();
}

// ISP: Interfaz para impresión
interface StudentPrinter {
    void printStudents(List<Student> students);
}

// OCP: Se puede añadir nuevos validadores sin modificar el StudentManager
interface StudentValidator {
    boolean isValid(Student student);
}

// Clase base de Student: Abierta a extensión (OCP), cumple LSP
class Student {
    private final String name;
    private final double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Estudiante: " + name + ", Calificación: " + grade;
    }
}

// StudentManager implementa solo las interfaces que necesita (ISP)
class StudentManager implements StudentRegistry {
    private final List<Student> students = new ArrayList<>();
    private final List<StudentValidator> validators;

    public StudentManager(List<StudentValidator> validators) {
        this.validators = validators;
    }

    @Override
    public void addStudent(Student student) {
        for (StudentValidator validator : validators) {
            if (!validator.isValid(student)) {
                throw new IllegalArgumentException("Estudiante no válido: " + student);
            }
        }
        students.add(student);
    }

    @Override
    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}

// OCP/ISP: Se puede agregar impresores nuevos sin tocar StudentManager
class ConsoleStudentPrinter implements StudentPrinter {
    @Override
    public void printStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

// OCP: Se puede agregar nuevos validadores sin modificar StudentManager
class NameValidator implements StudentValidator {
    @Override
    public boolean isValid(Student student) {
        return student.getName() != null && !student.getName().trim().isEmpty();
    }
}

class GradeValidator implements StudentValidator {
    @Override
    public boolean isValid(Student student) {
        return student.getGrade() >= 0.0 && student.getGrade() <= 100.0;
    }
}

// Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        List<StudentValidator> validators = new ArrayList<>();
        validators.add(new NameValidator());
        validators.add(new GradeValidator());

        StudentRegistry manager = new StudentManager(validators);
        StudentPrinter printer = new ConsoleStudentPrinter();

        try {
            manager.addStudent(new Student("John Doe", 85.5));
            manager.addStudent(new Student("Jane Doe", 91.2));
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        printer.printStudents(manager.getStudents());
    }
}
