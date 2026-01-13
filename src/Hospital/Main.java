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
                case 1 -> addPerson();
                case 2 -> addPatient();
                case 3 -> addDoctor();
                case 4 -> viewAllPeople();
                case 5 -> demonstratePolymorphism();
                case 6 -> viewDoctorsOnly();
                case 7 -> addAppointment();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }

        System.out.println("Program ended.");
    }

    private static void showMenu() {
        System.out.println("\n===== HOSPITAL SYSTEM =====");
        System.out.println("1. Add Person");
        System.out.println("2. Add Patient");
        System.out.println("3. Add Doctor");
        System.out.println("4. View All People");
        System.out.println("5. Demonstrate Polymorphism");
        System.out.println("6. View Doctors Only");
        System.out.println("7. Add Appointment");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private static void addPerson() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();

        people.add(new Person(id, name, age, gender));
        System.out.println("Person added.");
    }

    private static void addPatient() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        System.out.print("Disease: ");
        String disease = sc.nextLine();
        System.out.print("Room: ");
        String room = sc.nextLine();

        people.add(new Patient(id, name, age, gender, disease, room));
        System.out.println("Patient added.");
    }

    private static void addDoctor() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        System.out.print("Specialization: ");
        String spec = sc.nextLine();
        System.out.print("Salary: ");
        int salary = sc.nextInt();
        sc.nextLine();

        people.add(new Doctor(id, name, age, gender, spec, salary));
        System.out.println("Doctor added.");
    }

    private static void viewAllPeople() {
        System.out.println("\n--- ALL PEOPLE ---");
        for (Person p : people) {
            System.out.println(p);
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        for (Person p : people) {
            p.work(); // different behavior for Patient & Doctor
        }
    }

    private static void viewDoctorsOnly() {
        System.out.println("\n--- DOCTORS ONLY ---");
        for (Person p : people) {
            if (p instanceof Doctor) {
                Doctor d = (Doctor) p; // safe downcasting
                System.out.println(d);
                d.writePrescription();
            }
        }
    }

    private static void addAppointment() {
        Patient selectedPatient = null;
        Doctor selectedDoctor = null;

        for (Person p : people) {
            if (p instanceof Patient && selectedPatient == null)
                selectedPatient = (Patient) p;

            if (p instanceof Doctor && selectedDoctor == null)
                selectedDoctor = (Doctor) p;
        }

        if (selectedPatient == null || selectedDoctor == null) {
            System.out.println("Need at least 1 patient and 1 doctor.");
            return;
        }

        System.out.print("Date: ");
        String date = sc.nextLine();
        System.out.print("Time: ");
        String time = sc.nextLine();

        Appointment app = new Appointment(selectedPatient, selectedDoctor, date, time);
        appointments.add(app);

        app.showInfo();
    }
}
import Hospital.Doctor;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Appointment> appointments = new ArrayList<>();

        while (true) {
            System.out.println("\n====== HOSPITAL MENU ======");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. View All People");
            System.out.println("4. Make Everyone Work (Polymorphism)");
            System.out.println("5. Create Appointment");
            System.out.println("6. View Appointments");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Disease: ");
                        String disease = sc.nextLine();
                        System.out.print("Admitted (true/false): ");
                        boolean admitted = sc.nextBoolean();
                        Hospital.Patient p = new Hospital.Patient(id, name, age, disease, admitted);
                        people.add(p);
                        System.out.println("✅ Patient added successfully!");
                    }
                    case 2 -> {
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Specialization: ");
                        String spec = sc.nextLine();
                        System.out.print("Experience Years: ");
                        int exp = sc.nextInt();
                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();

                        Doctor d = new Doctor(id, name, age, spec, exp, salary);
                        boolean add = people.add(d);
                        System.out.println("✅ Doctor added successfully!");
                    }
                    case 3 -> {
                        System.out.println("\n=== ALL PEOPLE ===");
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

