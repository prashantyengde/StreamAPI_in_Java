package claude.Comparator;

import java.util.*;

//Student class — no interface, no changes needed
public class Student {

 String name;
 int age;

 public Student(String name, int age) {
     this.name = name;
     this.age  = age;
 }

 @Override
 public String toString() {
     return name + "(" + age + ")";
 }

 public static void main(String[] args) {

     Student alice = new Student("Alice", 20);
     Student bob   = new Student("Bob",   22);
     Student zara  = new Student("Zara",  19);

     List<Student> list = new ArrayList<>(Arrays.asList(zara, bob, alice));

     // ── Comparator 1: sort by NAME ─────────────────────────
     Comparator<Student> byName = (a, b) -> a.name.compareTo(b.name);

     // ── Comparator 2: sort by AGE ──────────────────────────
     Comparator<Student> byAge = (a, b) -> Integer.compare(a.age, b.age);

     // ── Comparator 3: sort by AGE reversed ────────────────
     Comparator<Student> byAgeDesc = byAge.reversed();

     // Direct comparison
     System.out.println("byAge.compare(alice, bob) = " + byAge.compare(alice, bob));
     // Output: negative → Alice(20) before Bob(22)

     // Sort by NAME
     list.sort(byName);
     System.out.println("Sort by name: " + list);  // [Alice, Bob, Zara]

     // Sort by AGE
     list.sort(byAge);
     System.out.println("Sort by age:  " + list);  // [Zara(19), Alice(20), Bob(22)]

     // Sort by AGE descending
     list.sort(byAgeDesc);
     System.out.println("Sort by age↓: " + list);  // [Bob(22), Alice(20), Zara(19)]
 }
}


/***
 * Output:** ``` byAge.compare(alice, bob) = -1 Sort by name: [Alice(20),
 * Bob(22), Zara(19)] Sort by age: [Zara(19), Alice(20), Bob(22)] Sort by age↓:
 * [Bob(22), Alice(20), Zara(19)]
 */