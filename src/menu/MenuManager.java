package menu;

import model.Doctor;
import database.DoctorDAO;

import java.util.Scanner;

public class MenuManager {
    private final DoctorDAO doctorDAO = new DoctorDAO();
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("\n╔══════════════════════════╗");
        System.out.println("║       DOCTOR MENU        ║");
        System.out.println("╚══════════════════════════╝");
        System.out.println("1. Add Doctor");
        System.out.println("2. View All Doctors");
        System.out.println("3. Update Doctor");
        System.out.println("4. Delete Doctor");
        System.out.println("5. Search Doctor by Name");
        System.out.println("6. Search Doctor by Salary Range");
        System.out.println("7. Highest Paid Doctor");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addDoctor(); break;
                case 2: viewAllDoctors(); break;
                case 3: updateDoctor(); break;
                case 4: deleteDoctor(); break;
                case 5: searchByName(); break;
                case 6: searchBySalaryRange(); break;
                case 7: showMaxSalaryDoctor(); break;
                case 0:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addDoctor() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Department: ");
        String dept = scanner.nextLine();

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        System.out.print("Experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Salary: ");
        double sal = scanner.nextDouble();
        scanner.nextLine();

        Doctor d = new Doctor(0, name, age, dept, spec, exp, sal);
        if (doctorDAO.insertDoctor(d)) {
            System.out.println("Doctor added successfully!");
        } else {
            System.out.println("Failed to add doctor.");
        }
    }

    private void viewAllDoctors() {
        System.out.println("\n--- All Doctors ---");
        for (Doctor d : doctorDAO.getAllDoctors()) {
            System.out.println(d);
        }
    }

    private void updateDoctor() {
        System.out.print("Enter Doctor ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Doctor d = doctorDAO.getDoctorById(id);
        if (d == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.print("New Name: ");
        String name = scanner.nextLine();

        System.out.print("New Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New Department: ");
        String dept = scanner.nextLine();

        System.out.print("New Specialization: ");
        String spec = scanner.nextLine();

        System.out.print("New Experience: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New Salary: ");
        double sal = scanner.nextDouble();
        scanner.nextLine();

        Doctor updated = new Doctor(id, name, age, dept, spec, exp, sal);
        if (doctorDAO.updateDoctor(updated)) {
            System.out.println("Doctor updated successfully!");
        } else {
            System.out.println("Update failed.");
        }
    }

    private void deleteDoctor() {
        System.out.print("Enter Doctor ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Doctor d = doctorDAO.getDoctorById(id);
        if (d == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.print("Confirm deletion (yes/no): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            if (doctorDAO.deleteDoctor(id)) {
                System.out.println("Doctor deleted successfully!");
            } else {
                System.out.println("Delete failed.");
            }
        } else {
            System.out.println("Cancelled.");
        }
    }

    private void searchByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        for (Doctor d : doctorDAO.searchByName(name)) {
            System.out.println(d);
        }
    }

    private void searchBySalaryRange() {
        System.out.print("Min salary: ");
        double min = scanner.nextDouble();

        System.out.print("Max salary: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        for (Doctor d : doctorDAO.searchBySalaryRange(min, max)) {
            System.out.println(d);
        }
    }

    private void showMaxSalaryDoctor() {
        Doctor d = doctorDAO.getMaxSalaryDoctor();
        if (d == null) {
            System.out.println("No doctors found.");
        } else {
            System.out.println("Highest Paid Doctor:");
            System.out.println(d);
        }
    }
}
