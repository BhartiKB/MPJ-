import java.util.Scanner;

// part 01
class Shapes {
    double a;

    Shapes(int s) {
        a = s * s;
        System.out.println("Square area = " + a);
    }

    Shapes(int l, int b) {
        a = l * b;
        System.out.println("Rectangle area = " + a);
    }

    Shapes(double r) {
        a = 3.14 * r * r;
        System.out.println("Circle area = " + a);
    }

    void area(int s) {
        System.out.println("Square (method) = " + (s * s));
    }

    void area(int l, int b) {
        System.out.println("Rectangle (method) = " + (l * b));
    }

    void area(double r, int x) {
        System.out.println("Circle (method) = " + (3.14 * r * r));
    }
}


// part 02
class Hillstations {
    void famousfood() {
        System.out.println("Common hill station food");
    }

    void famousfor() {
        System.out.println("Known for nature");
    }
}

class Manali extends Hillstations {
    void famousfood() {
        System.out.println("Siddu");
    }

    void famousfor() {
        System.out.println("Snow & mountains");
    }
}

class Mussoorie extends Hillstations {
    void famousfood() {
        System.out.println("Momos");
    }

    void famousfor() {
        System.out.println("Hills & waterfalls");
    }
}

class Ooty extends Hillstations {
    void famousfood() {
        System.out.println("Chocolates");
    }

    void famousfor() {
        System.out.println("Tea gardens");
    }
}


// main
public class LAB03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char m = 'y';

        do {
            System.out.println("\nChoose Part:");
            System.out.println("1. Shapes (Overloading)");
            System.out.println("2. Hillstations (Overriding)");
            System.out.print("\nEnter your choice: ");
            int p = sc.nextInt();

            // part 01
            if (p == 1) {
                char c = 'y';

                do {
                    System.out.println("\n1. Square");
                    System.out.println("2. Rectangle");
                    System.out.println("3. Circle");
                    System.out.print("\nEnter your choice: ");
                    int ch = sc.nextInt();

                    if (ch == 1) {
                        System.out.print("Length of side: ");
                        int s = sc.nextInt();
                        Shapes o = new Shapes(s);
                        o.area(s);

                    } else if (ch == 2) {
                        System.out.print("Length: ");
                        int l = sc.nextInt();
                        System.out.print("Width: ");
                        int b = sc.nextInt();
                        Shapes o = new Shapes(l, b);
                        o.area(l, b);

                    } else if (ch == 3) {
                        System.out.print("Radius: ");
                        double r = sc.nextDouble();
                        Shapes o = new Shapes(r);
                        o.area(r, 1);

                    } else {
                        System.out.println("Invalid choice");
                    }

                    System.out.print("\nDo you want to continue in Shapes? (y/n): ");
                    c = sc.next().charAt(0);

                } while (c == 'y' || c == 'Y');
            }

            // part 02
            else if (p == 2) {
                char c = 'y';

                do {
                    System.out.println("\n1. Manali");
                    System.out.println("2. Mussoorie");
                    System.out.println("3. Ooty");
                    System.out.print("\nEnter your choice: ");
                    int ch = sc.nextInt();

                    Hillstations h;

                    if (ch == 1)
                        h = new Manali();
                    else if (ch == 2)
                        h = new Mussoorie();
                    else if (ch == 3)
                        h = new Ooty();
                    else {
                        System.out.println("Invalid choice");
                        continue;
                    }

                    h.famousfood();
                    h.famousfor();

                    System.out.print("\nDo you want to continue in Hillstations? (y/n): ");
                    c = sc.next().charAt(0);

                } while (c == 'y' || c == 'Y');
            }

            else {
                System.out.println("Wrong option");
            }

            System.out.print("\nDo you want to go back to main menu? (y/n): ");
            m = sc.next().charAt(0);

        } while (m == 'y' || m == 'Y');

        System.out.println("\nProgram ended.");
        sc.close();
    }
}