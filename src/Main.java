import java.util.*;

class GFG {

    static class employee {
        String name;
        long code;
        String designation;
        int exp;
        int age;
    }

    static int num;
    static int max = 20;
    static employee[] emp = new employee[max];
    static Scanner sc = new Scanner(System.in);

    static void build() {
        System.out.println("Build The Table\n");
        System.out.println("Maximum Entries can be " + max);
        System.out.println("Enter the number of Entries required:");
        num = sc.nextInt();

        if (num > max) num = max;

        for (int i = 0; i < num; i++) {
            emp[i] = new employee(); // ✅ initialize object

            System.out.print("Name: ");
            emp[i].name = sc.next();

            System.out.print("Employee ID: ");
            emp[i].code = sc.nextLong();

            System.out.print("Designation: ");
            emp[i].designation = sc.next();

            System.out.print("Experience: ");
            emp[i].exp = sc.nextInt();

            System.out.print("Age: ");
            emp[i].age = sc.nextInt();
        }
    }

    static void insert() {
        if (num < max) {
            emp[num] = new employee(); // ✅ initialize object

            System.out.println("Enter the information of the Employee:");
            System.out.print("Name: ");
            emp[num].name = sc.next();

            System.out.print("Employee ID: ");
            emp[num].code = sc.nextLong();

            System.out.print("Designation: ");
            emp[num].designation = sc.next();

            System.out.print("Experience: ");
            emp[num].exp = sc.nextInt();

            System.out.print("Age: ");
            emp[num].age = sc.nextInt();

            num++;
        } else {
            System.out.println("Employee Table Full");
        }
    }

    static void deleteIndex(int i) {
        for (int j = i; j < num - 1; j++) {
            emp[j] = emp[j + 1];
        }
    }

    static void deleteRecord() {
        System.out.println("Enter the Employee ID to Delete Record:");
        long code = sc.nextLong();

        for (int i = 0; i < num; i++) {
            if (emp[i].code == code) {
                deleteIndex(i);
                num--;
                System.out.println("Record deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    static void searchRecord() {
        System.out.println("Enter the Employee ID to Search Record:");
        long code = sc.nextLong();

        for (int i = 0; i < num; i++) {
            if (emp[i].code == code) {
                System.out.println("---- Employee Found ----");
                System.out.println("Name: " + emp[i].name);
                System.out.println("Employee ID: " + emp[i].code);
                System.out.println("Designation: " + emp[i].designation);
                System.out.println("Experience: " + emp[i].exp);
                System.out.println("Age: " + emp[i].age);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    static void showMenu() {
        System.out.println("\n--- Employee Management System ---");
        System.out.println("1. Build Table");
        System.out.println("2. Insert New Entry");
        System.out.println("3. Delete Entry");
        System.out.println("4. Search Record");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        int option = sc.nextInt();

        switch (option) {
            case 1 -> build();
            case 2 -> insert();
            case 3 -> deleteRecord();
            case 4 -> searchRecord();
            case 5 -> System.exit(0);
            default -> System.out.println("Invalid option!");
        }
    }

    public static void main(String[] args) {
        while (true) showMenu();
    }
}
