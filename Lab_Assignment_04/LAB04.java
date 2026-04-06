import java.io.*;
import java.util.*;

public class LAB04 {

    static class Acc {
        int id;
        String name;
        double bal;

        Acc(int id, String name, double bal) {
            this.id = id;
            this.name = name;
            this.bal = bal;
        }
    }

    static ArrayList<Acc> a = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static Acc search(int id) {
        for (Acc x : a) {
            if (x.id == id) {
                return x;
            }
        }
        return null;
    }

    static void writeFile(Acc x) {
        try {
            FileWriter fw = new FileWriter("rec.txt", true);
            fw.write(x.id + " " + x.name + " " + x.bal + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("File error");
        }
    }

    static void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("rec.txt"));
            String s;
            System.out.println("\nFile Records:");
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("No file found");
        }
    }

    public static void main(String[] args) {
        int ch = 0;

        do {
            try {
                System.out.println("\n1. Add Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Show Balance");
                System.out.println("5. Show File");
                System.out.println("6. Exit");
                System.out.print("\nEnter choice: ");
                ch = sc.nextInt();

                if (ch == 1) {
                    System.out.print("Enter id: ");
                    int id = sc.nextInt();

                    if (id <= 0) {
                        System.out.println("Invalid id");
                        continue;
                    }

                    if (search(id) != null) {
                        System.out.println("Id already used");
                        continue;
                    }

                    System.out.print("Enter name: ");
                    String name = sc.next();

                    System.out.print("Enter balance: ");
                    double bal = sc.nextDouble();

                    if (bal < 1000) {
                        System.out.println("Invalid balance");
                    } else {
                        Acc x = new Acc(id, name, bal);
                        a.add(x);
                        writeFile(x);
                        System.out.println("Account created");
                    }
                }

                else if (ch == 2) {
                    System.out.print("Enter id: ");
                    int id = sc.nextInt();
                    Acc x = search(id);

                    if (x == null) {
                        System.out.println("Account not found");
                        continue;
                    }

                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();

                    if (amt <= 0) {
                        System.out.println("Invalid amount");
                    } else {
                        x.bal = x.bal + amt;
                        System.out.println("Deposit done");
                        System.out.println("Balance = " + x.bal);
                    }
                }

                else if (ch == 3) {
                    System.out.print("Enter id: ");
                    int id = sc.nextInt();
                    Acc x = search(id);

                    if (x == null) {
                        System.out.println("Account not found");
                        continue;
                    }

                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();

                    if (amt <= 0) {
                        System.out.println("Invalid amount");
                    } else if (amt > x.bal) {
                        System.out.println("Not enough balance");
                    } else {
                        x.bal = x.bal - amt;
                        System.out.println("Withdraw done");
                        System.out.println("Balance = " + x.bal);
                    }
                }

                else if (ch == 4) {
                    System.out.print("Enter id: ");
                    int id = sc.nextInt();
                    Acc x = search(id);

                    if (x == null) {
                        System.out.println("Account not found");
                    } else {
                        System.out.println("Name: " + x.name);
                        System.out.println("Balance: " + x.bal);
                    }
                }

                else if (ch == 5) {
                    readFile();
                }

                else if (ch == 6) {
                    System.out.println("Exit");
                }

                else {
                    System.out.println("Invalid choice");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                sc.nextLine();
            }

        } while (ch != 6);
    }
}