package JavaConcepts.Collections;

import java.util.Arrays;
import java.util.Comparator;
class Student implements Comparable<Student> {
    int id;
    String name;
int age;
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
this.age  = age; }

    @Override
    public int compareTo(Student sid) {
        return this.id - sid.id;
    }
}
class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.age, s2.age);
    }
}
class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}
public class ComparatorVsComparable {
    public static void main(String args[]) {
        Student s1 = new Student(1, "abc", 350);
        Student s3 = new Student(3, "xyz",42);
        Student s2 = new Student(2, "afuy",23);
        Student s4 = new Student(4, "gkh",95);
        Student[] students = {s1, s3, s2, s4};
        System.out.println("Before sorting:");
        for (Student s : students) {
            System.out.println(s.id + " " + s.name);
        }
//        Collections.sort(Arrays.asList(students), new StudentNameComparator());
        Arrays.sort(students);
        System.out.println("After sorting:");
        for (Student s : students) {
            System.out.println(s.id + " " + s.name);
        }

        Arrays.sort(students, new StudentNameComparator());
        System.out.println("After sorting by name:");
        for (Student s : students) {
            System.out.println(s.id + " " + s.name);
        }
        // Sorting by age
Arrays.sort(students,  new StudentAgeComparator());
        System.out.println("After sorting by age:");
        for (Student s : students) {
            System.out.println(s.id + " " + s.name + " " + s.age);
        }
     }
}
