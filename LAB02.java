import java.util.Scanner;

// ================= BASE CLASS =================
class Employee {
    protected String name;
    protected double salary;

    // Constructor
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        System.out.println("Employee constructor called");
    }

    public void displaySalary() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Employee object destroyed");
    }
}

// ============ SINGLE INHERITANCE =============
class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name, double salary) {
        super(name, salary);
        System.out.println("FullTimeEmployee constructor called");
    }

    public void calculateSalary() {
        System.out.println("\n--- Full Time Employee ---");
        System.out.println("Before Hike:");
        displaySalary();

        salary = salary + (salary * 0.50);

        System.out.println("After 50% Hike:");
        displaySalary();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("FullTimeEmployee object destroyed");
    }
}

// ========== HIERARCHICAL INHERITANCE ==========
class InternEmployee extends Employee {

    InternEmployee(String name, double salary) {
        super(name, salary);
        System.out.println("InternEmployee constructor called");
    }

    public void calculateSalary() {
        System.out.println("\n--- Intern Employee ---");
        System.out.println("Before Hike:");
        displaySalary();

        salary = salary + (salary * 0.25);

        System.out.println("After 25% Hike:");
        displaySalary();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("InternEmployee object destroyed");
    }
}

// ========== MULTILEVEL INHERITANCE ==========
class TraineeIntern extends InternEmployee {

    TraineeIntern(String name, double salary) {
        super(name, salary);
        System.out.println("TraineeIntern constructor called");
    }

    public void traineeInfo() {
        System.out.println("\n--- Trainee Intern ---");
        displaySalary();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("TraineeIntern object destroyed");
    }
}

// ================= MAIN CLASS =================
class Mai {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input for Full Time Employee
        System.out.print("Enter Full Time Employee Name: ");
        String fName = sc.nextLine();
        System.out.print("Enter Full Time Employee Salary: ");
        double fSalary = sc.nextDouble();
        sc.nextLine();

        FullTimeEmployee fte = new FullTimeEmployee(fName, fSalary);
        fte.calculateSalary();

        // Input for Intern
        System.out.print("\nEnter Intern Name: ");
        String iName = sc.nextLine();
        System.out.print("Enter Intern Salary: ");
        double iSalary = sc.nextDouble();
        sc.nextLine();

        InternEmployee intern = new InternEmployee(iName, iSalary);
        intern.calculateSalary();

        // Input for Trainee Intern
        System.out.print("\nEnter Trainee Intern Name: ");
        String tName = sc.nextLine();
        System.out.print("Enter Trainee Intern Salary: ");
        double tSalary = sc.nextDouble();

        TraineeIntern trainee = new TraineeIntern(tName, tSalary);
        trainee.traineeInfo();

        // Making objects eligible for GC
        fte = null;
        intern = null;
        trainee = null;

        System.gc();

        sc.close();
    }
}



/*
- what is inheritance with proper example
- what operator overloading
- does operator overloading works in java?
- 5 problems where inheritance is used
 */