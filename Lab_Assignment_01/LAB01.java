import java.util.Scanner;

public class LAB01 { // Name should start with capital letter
    static class Student{
        String name;
        int roll_no;
        int[] marks= new int[5];
        char grade;
        double average;
    }

    public static void main(String[] args) {
        // take info name, roll no, marks for 5 subjects. find avg marks or percentage and display grade A, B or C
        Scanner sc = new Scanner(System.in); //sc is name of obj, scanner is a class used to take input
        Student s1 = new Student();

        System.out.print("Enter Student Name: ");
        s1.name = sc.nextLine();

        System.out.print("Enter Student roll no.: ");
        s1.roll_no = sc.nextInt();

        int total = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            s1.marks[i] = sc.nextInt();
            total += s1.marks[i];
        }
        s1.average = total / 5.0;

        if (s1.average >= 75)
            s1.grade = 'A';
        else if (s1.average >= 50)
            s1.grade = 'B';
        else
            s1.grade = 'C';


        System.out.println("\n--- Student Details ---");
        System.out.println("Name       : " + s1.name);
        System.out.println("Roll No    : " + s1.roll_no);
        System.out.println("Average    : " + s1.average);
        System.out.println("Grade      : " + s1.grade);

        sc.close();
    }
}

/*

- byte code output is in what file ?? ANS -> .class file
- it is platform independent -> byte code can run in all OS.
- it's pass by value...find why ?
- Multiple inheritance ??....why possible or not ?
- Only one class can be defined....every class has one source file...as a part of main class
- How to achieve functionality of multiple Java files, like we do in C++.
- for viva innovative research.
- Structure of JVM and it's functionality
- Demonstrate the Concurrency
- Do this in command line in linux

Solve all the configuration issue of ur IDE


Required:
- class: methods, variables, inheritance
- super class
- Supports single inheritance for classes (multiple inheritance via interfaces only).
- no deconstruction ??

in addition, take the marks as a constructor
*/