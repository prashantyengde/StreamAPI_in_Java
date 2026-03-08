package claude.Comparable;

import java.util.*;

//Student class defines its OWN natural ordering
public class Student implements Comparable<Student> {

 String name;
 int age;

 // Constructor
 public Student(String name, int age) {
     this.name = name;
     this.age  = age;
 }

 // compareTo — sort alphabetically by name (natural order)
 @Override
 public int compareTo(Student other) {
     return this.name.compareTo(other.name);
     // returns negative → this comes first
     // returns 0        → equal
     // returns positive → other comes first
 }

 @Override
 public String toString() {
     return name + "(" + age + ")";
 }

 public static void main(String[] args) {

     Student alice = new Student("Alice", 20);
     Student bob   = new Student("Bob",   22);
     Student zara  = new Student("Zara",  19);

     // Direct comparison
     int result = alice.compareTo(bob);
     System.out.println("alice.compareTo(bob) = " + result);
     // Output: negative number → Alice comes before Bob

     // Sorting a list — uses compareTo automatically
     List<Student> list = new ArrayList<>(Arrays.asList(zara, bob, alice));
     System.out.println("Before sort: " + list);  // [Zara(19), Bob(22), Alice(20)]

     Collections.sort(list);  // calls compareTo internally
     System.out.println("After sort:  " + list);  // [Alice(20), Bob(22), Zara(19)]
 }
}
/*
 * ```
 ** 
 * Output:** ``` alice.compareTo(bob) = -1 Before sort: [Zara(19), Bob(22),
 * Alice(20)] After sort: [Alice(20), Bob(22), Zara(19)]
 */