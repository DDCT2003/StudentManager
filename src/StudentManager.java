import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Clase Student para representar a un estudiante
class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del estudiante no puede estar vacío.");
        }
        if (grade < 0.0 || grade > 100.0) {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y 100.");
        }
        this.name = name.trim();
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

// Gestor de estudiantes
public class StudentManager {
    private List<Student> students = new ArrayList<>();

    // Agrega un estudiante después de validar los datos
    public void addStudent(String name, double grade) {
        Student student = new Student(name, grade);
        students.add(student);
    }

    // Devuelve una lista inmutable de los estudiantes registrados
    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    // Imprime los estudiantes y calificaciones (responsabilidad de presentación)
    public void printStudents() {
        if (students.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Main solo como ejemplo de uso, no para lógica de negocio
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        try {
            manager.addStudent("John Doe", 85.5);
            manager.addStudent("Jane Doe", 91.2);

            // validación
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        manager.printStudents();
    }
}
