/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai16;

/**
 *
 * @author Admin
 */
//public class Student {
    public class Student implements CompareGeneric<Student> {
    private final String name;
    private final int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Implement the compareTo method to compare students by age
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age); // Compare by age
    }

    // Override the toString method to display student information
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}


