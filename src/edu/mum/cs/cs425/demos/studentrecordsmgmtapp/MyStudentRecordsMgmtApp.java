package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyStudentRecordsMgmtApp {

    public static void main(String[] args) {
        Student[] students = {
                new Student(110001, "Dave", LocalDate.parse("1951-11-18", DateTimeFormatter.ofPattern("yyyy-MM-dd"))),
                new Student(110002, "Anna", LocalDate.parse("1990-12-07", DateTimeFormatter.ofPattern("yyyy-MM-dd"))),
                new Student(110003, "Erica", LocalDate.parse("1974-01-31", DateTimeFormatter.ofPattern("yyyy-MM-dd"))),
                new Student(110004, "Carlos", LocalDate.parse("2009-08-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"))),
                new Student(110005, "Bob", LocalDate.parse("1990-03-05", DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        };

        printListOfStudents(students);
        List<Student> platinumAlumni = getListOfPlatinumAlumniStudents(students);
        System.out.println("\nPlatinum Alumni Students:");
        platinumAlumni.forEach(student -> System.out.println(student.getName() + ", " + student.getDateOfAdmission()));
    }

    public static void printListOfStudents(Student[] students) {
        Arrays.sort(students, Comparator.comparing(Student::getName));
        for (Student s : students) {
            System.out.println(s.getName() + ", " + s.getDateOfAdmission());
        }
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        return Arrays.stream(students)
                .filter(student -> student.getDateOfAdmission().isBefore(LocalDate.now().minusYears(30)))
                .sorted(Comparator.comparing(Student::getDateOfAdmission).reversed())
                .collect(Collectors.toList());
    }
}
