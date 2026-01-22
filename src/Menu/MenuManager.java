package Menu;

import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuManager implements Menu {

    private final List<Person> people = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n===== HOSPITAL MENU =====");
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Patient");
        System.out.println("3. Show All People");
        System.out.println("4. Show Work (Polymorphism)");
        System.out.println("5. Show Treatment");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    private void loadTestData() {
        people.add(new Doctor(1, "Dr. Nurdaulet", 45, "Upper", "Cardiology", 15));
        people.add(new Doctor(2, "Dr. Aisha", 67, "Lower", "Pulmonology", 17));
        people.add(new Patient(3, "Margulan", 23, "Upper", "Cancer", true));
        people.add(new Patient(4, "Aruzhan", 19, "Lower", "Asthma", true));
    }

    @Override
    public void run() {
        boolean isRunning = true;
        loadTestData();

        while (isRunning) {
            try {
                displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addDoctor();
                    case 2 -> addPatient();
                    case 3 -> showAllPeople();
                    case 4 -> showWork();
                    case 5 -> showTreatment();
                    case 0 -> {
                        isRunning = false;
                        System.out.println("System closed.");
                    }
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Input error: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void addDoctor() {
        System.out.print("ID: ");
        int id = scanner.nextInt(); scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt(); scanner.nextLine();

        System.out.print("Department: ");
        String dept = scanner.nextLine();

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        System.out.print("Experience years: ");
        int exp = scanner.nextInt();

        people.add(new Doctor(id, name, age, dept, spec, exp));
        System.out.println("Doctor added successfully.");
    }

    private void addPatient() {
        System.out.print("ID: ");
        int id = scanner.nextInt(); scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt(); scanner.nextLine();

        System.out.print("Department: ");
        String dept = scanner.nextLine();

        System.out.print("Illness: ");
        String illness = scanner.nextLine();

        System.out.print("Checked (true/false): ");
        boolean checked = scanner.nextBoolean();

        people.add(new Patient(id, name, age, dept, illness, checked));
        System.out.println("Patient added successfully.");
    }

    private void showAllPeople() {
        people.forEach(System.out::println);
    }

    private void showWork() {
        for (Person p : people) {
            p.work();
        }
    }

    private void showTreatment() {
        for (Person p : people) {
            if (p instanceof Treating t) {
                t.treat();
            }
        }
    }
}
