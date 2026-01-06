import java.util.*;

class Student {
    String id, name, dept;
    double cgpa;

    Student(String id, String name, String dept, double cgpa) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.cgpa = cgpa;
    }
}

public class StudentManagementSystem {
    static HashMap<String, Student> students = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {
        System.out.print("Enter ID: ");
        String id = sc.next();
        if (students.containsKey(id)) {
            System.out.println("Student already exists!");
            return;
        }
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Department: ");
        String dept = sc.next();
        System.out.print("CGPA: ");
        double cgpa = sc.nextDouble();

        students.put(id, new Student(id, name, dept, cgpa));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        for (Student s : students.values()) {
            System.out.println(s.id + " " + s.name + " " + s.dept + " " + s.cgpa);
        }
    }

    static void searchStudent() {
        System.out.print("Enter ID: ");
        String id = sc.next();
        Student s = students.get(id);
        if (s == null)
            System.out.println("Student not found!");
        else
            System.out.println(s.id + " " + s.name + " " + s.dept + " " + s.cgpa);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add 2.View 3.Search 4.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                default: System.exit(0);
            }
        }
    }
}