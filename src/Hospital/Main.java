package Hospital;
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