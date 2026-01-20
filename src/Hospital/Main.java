package Hospital;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Person> people = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addPatient();
                case 2 -> addDoctor();
                case 3 -> viewAllPeople();
                case 4 -> demonstratePolymorphism();
                case 5 -> addAppointment();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
        System.out.println("Program ended.");
    }

    private static void showMenu() {
        System.out.println("\n===== HOSPITAL SYSTEM =====");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. View All People");
        System.out.println("4. Demonstrate Polymorphism");
        System.out.println("5. Add Appointment");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private static void addPatient() {
        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
        System.out.print("Gender: "); String gender = sc.nextLine();
        System.out.print("Disease: "); String disease = sc.nextLine();
        System.out.print("Room: "); String room = sc.nextLine();
        people.add(new Patient(id, name, age, gender, disease, room));
        System.out.println("Patient added.");
    }

    private static void addDoctor() {
        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
        System.out.print("Gender: "); String gender = sc.nextLine();
        System.out.print("Specialization: "); String spec = sc.nextLine();
        System.out.print("Salary: "); int salary = sc.nextInt(); sc.nextLine();
        people.add(new Doctor(id, name, age, gender, spec, salary));
        System.out.println("Doctor added.");
    }

    private static void viewAllPeople() {
        System.out.println("\n--- ALL PEOPLE ---");
        for (Person p : people) System.out.println(p);
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        for (Person p : people) p.work();
    }

    private static void addAppointment() {
        if (people.isEmpty()) { System.out.println("No people available."); return; }

        Patient selectedPatient = null;
        Doctor selectedDoctor = null;

        for (Person p : people) {
            if (p instanceof Patient && selectedPatient == null) selectedPatient = (Patient)p;
            if (p instanceof Doctor && selectedDoctor == null) selectedDoctor = (Doctor)p;
        }

        if (selectedPatient == null || selectedDoctor == null) {
            System.out.println("Need at least 1 patient and 1 doctor.");
            return;
        }

        System.out.print("Date: "); String date = sc.nextLine();
        System.out.print("Time: "); String time = sc.nextLine();
        Appointment app = new Appointment(selectedPatient, selectedDoctor, date, time);
        appointments.add(app);
        app.showInfo();
    }
}
