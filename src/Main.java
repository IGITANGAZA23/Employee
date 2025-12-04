import java.util.Scanner;

class GFG {

    // Simple employee data holder
    static class employee {
        String name;
        long code;
        String designation;
        int exp;
        int age;
    }

    static int num;                   // current number of employees
    static final int max = 20;        // maximum employees
    static final employee[] emp = new employee[max];
    static final Scanner sc = new Scanner(System.in);

    // Helper to pause between actions so user can read output
    static void pause() {
        System.out.println("\nPress Enter to continue...");
        sc.nextLine(); // consume the leftover newline, if any
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
    }

    static void build() {
        System.out.println("\n--- Build The Employee Table ---");
        System.out.println("Maximum entries can be " + max);
        System.out.print("Enter the number of entries you want to create: ");
        num = sc.nextInt();

        if (num > max) {
            System.out.println("You entered more than " + max + ". Only " + max + " will be created.");
            num = max;
        }

        for (int i = 0; i < num; i++) {
            emp[i] = new employee();

            System.out.println("\nEmployee " + (i + 1) + ":");
            System.out.print("  Name: ");
            emp[i].name = sc.next();

            System.out.print("  Employee ID: ");
            emp[i].code = sc.nextLong();

            System.out.print("  Designation: ");
            emp[i].designation = sc.next();

            System.out.print("  Experience (years): ");
            emp[i].exp = sc.nextInt();

            System.out.print("  Age: ");
            emp[i].age = sc.nextInt();
        }

        System.out.println("\nEmployee table built successfully with " + num + " records.");
    }

    static void insert() {
        if (num >= max) {
            System.out.println("\nEmployee table is full. Cannot insert more employees.");
            return;
        }

        emp[num] = new employee();
        System.out.println("\n--- Insert New Employee ---");

        System.out.print("  Name: ");
        emp[num].name = sc.next();

        System.out.print("  Employee ID: ");
        emp[num].code = sc.nextLong();

        System.out.print("  Designation: ");
        emp[num].designation = sc.next();

        System.out.print("  Experience (years): ");
        emp[num].exp = sc.nextInt();

        System.out.print("  Age: ");
        emp[num].age = sc.nextInt();

        num++;
        System.out.println("\nEmployee added successfully. Total employees: " + num);
    }

    static void deleteIndex(int i) {
        for (int j = i; j < num - 1; j++) {
            emp[j] = emp[j + 1];
        }
    }

    static void deleteRecord() {
        if (num == 0) {
            System.out.println("\nThere are no employees to delete.");
            return;
        }

        System.out.print("\nEnter the Employee ID to delete: ");
        long code = sc.nextLong();

        for (int i = 0; i < num; i++) {
            if (emp[i].code == code) {
                deleteIndex(i);
                num--;
                System.out.println("Record deleted successfully. Remaining employees: " + num);
                return;
            }
        }
        System.out.println("Employee with ID " + code + " not found.");
    }

    static void searchRecord() {
        if (num == 0) {
            System.out.println("\nThere are no employees to search.");
            return;
        }

        System.out.print("\nEnter the Employee ID to search: ");
        long code = sc.nextLong();

        for (int i = 0; i < num; i++) {
            if (emp[i].code == code) {
                System.out.println("\n---- Employee Found ----");
                System.out.println("  Name: " + emp[i].name);
                System.out.println("  Employee ID: " + emp[i].code);
                System.out.println("  Designation: " + emp[i].designation);
                System.out.println("  Experience: " + emp[i].exp + " years");
                System.out.println("  Age: " + emp[i].age);
                return;
            }
        }
        System.out.println("Employee with ID " + code + " not found.");
    }

    static void showMenu() {
        System.out.println("\n==================================");
        System.out.println("       Employee Management");
        System.out.println("==================================");
        System.out.println("1. Build Employee Table");
        System.out.println("2. Insert New Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. Search Employee");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");

        int option = sc.nextInt();

        switch (option) {
            case 1 -> build();
            case 2 -> insert();
            case 3 -> deleteRecord();
            case 4 -> searchRecord();
            case 5 -> {
                System.out.println("\nThank you for using the Employee Management System. Goodbye!");
                System.exit(0);
            }
            default -> System.out.println("\nInvalid option! Please enter a number between 1 and 5.");
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("  Welcome to Employee Management  ");
        System.out.println("==================================");
        System.out.println("You will now be guided by on-screen prompts.");

        while (true) {
            showMenu();
            pause();
        }
    }
}
