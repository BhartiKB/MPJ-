import java.util.Scanner;

// ================= BASE CLASS =================
abstract class Employee {
    private String name;
    protected double salary;

    // Constructor
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        System.out.println("Employee constructor called");
    }

    public String getName() {
        return name;
    }

    public void displaySalary() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }

    // Abstract method
    public abstract void calculateSalary();
}

// ============ SINGLE + HIERARCHICAL ============
class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name, double salary) {
        super(name, salary);
        System.out.println("FullTimeEmployee constructor called");
    }

    @Override
    public void calculateSalary() {
        System.out.println("\n--- Full Time Employee ---");
        System.out.println("Before Hike:");
        displaySalary();

        salary += salary * 0.50;

        System.out.println("After 50% Hike:");
        displaySalary();
    }
}

// ========== HIERARCHICAL ==========
class InternEmployee extends Employee {

    InternEmployee(String name, double salary) {
        super(name, salary);
        System.out.println("InternEmployee constructor called");
    }

    @Override
    public void calculateSalary() {
        System.out.println("\n--- Intern Employee ---");
        System.out.println("Before Hike:");
        displaySalary();

        salary += salary * 0.25;

        System.out.println("After 25% Hike:");
        displaySalary();
    }
}

// ========== MULTILEVEL ==========
class TraineeIntern extends InternEmployee {

    TraineeIntern(String name, double salary) {
        super(name, salary);
        System.out.println("TraineeIntern constructor called");
    }

    public void traineeInfo() {
        System.out.println("\n--- Trainee Intern ---");
        displaySalary();
    }
}

// ================= MAIN CLASS =================
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Full Time Employee Name: ");
        String fName = sc.nextLine();
        System.out.print("Enter Salary: ");
        double fSalary = sc.nextDouble();
        sc.nextLine();

        Employee fte = new FullTimeEmployee(fName, fSalary);
        fte.calculateSalary();

        System.out.print("\nEnter Intern Name: ");
        String iName = sc.nextLine();
        System.out.print("Enter Salary: ");
        double iSalary = sc.nextDouble();
        sc.nextLine();

        Employee intern = new InternEmployee(iName, iSalary);
        intern.calculateSalary();

        System.out.print("\nEnter Trainee Name: ");
        String tName = sc.nextLine();
        System.out.print("Enter Salary: ");
        double tSalary = sc.nextDouble();

        TraineeIntern trainee = new TraineeIntern(tName, tSalary);
        trainee.traineeInfo();

        sc.close();
    }
}
