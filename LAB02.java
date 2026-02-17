import java.util.Scanner;

// base
class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void displaySalary() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

// deri 1
class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    public void calculateSalary() {
        salary += salary * 0.50;  // 50% hike
    }
}

// deri 2
class InternEmployee extends Employee {

    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    public void calculateSalary() {
        salary += salary * 0.25;  // 25% hike
    }
}

public class LAB02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.println("\nSelect Employee Type:");
            System.out.println("1. Full Time Employee");
            System.out.println("2. Intern Employee");
            System.out.print("Enter choice (1 or 2): ");
            int type = sc.nextInt();
            sc.nextLine(); //buffer clear karne ke liye ?

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            if (type == 1) {
                FullTimeEmployee emp = new FullTimeEmployee(name, salary);
                System.out.println("\nBefore Hike:");
                emp.displaySalary();
                emp.calculateSalary();
                System.out.println("After 50% Hike:");
                emp.displaySalary();

            } else if (type == 2) {
                InternEmployee emp = new InternEmployee(name, salary);
                System.out.println("\nBefore Hike:");
                emp.displaySalary();
                emp.calculateSalary();
                System.out.println("After 25% Hike:");
                emp.displaySalary();

            } else {
                System.out.println("Invalid choice!");
            }

            System.out.print("\nDo you want to enter another employee? (y/n): ");
            choice = sc.next().charAt(0);
            sc.nextLine();

        } while (choice == 'y' || choice == 'Y');

        sc.close();
    }
}
