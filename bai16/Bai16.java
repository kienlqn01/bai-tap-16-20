/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai16;
    import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Bai16 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
//public class Main {
    //public static void main(String[] args) {
        // Create a list of students
        List<Student> students = new ArrayList<>();

        // Add students to the list
        students.add(new Student("John", 21));
        students.add(new Student("Alice", 19));
        students.add(new Student("Bob", 22));

        // Sort students by age using a custom comparator
        Collections.sort(students, new ComparatorImpl());

        // Display the sorted list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }

        private static class ComparatorImpl implements Comparator<Student> {

            public ComparatorImpl() {
            }

            @Override
            public int compare(Student s1, Student s2) {
                return s1.compareTo(s2); // Delegate to the compareTo method
            }
        }
    }

    
    

