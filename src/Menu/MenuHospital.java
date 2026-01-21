package Menu;

import model.*;
import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuHospital implements Menu {
    private ArrayList<Person> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n--- HOSPITAL SYSTEM ---");
        System.out.println("1. Add Doctor\n2. Add Patient\n3. Show All\n4. Polymorphism\n5. Exit");
    }

    @Override
    public void run() {
        int choice = 0;
        while (choice != 5) {
            displayMenu();
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 5) throw new InvalidInputException("Invalid Option!");

                switch (choice) {
                    case 1 -> addDoc();
                    case 2 -> addPat();
                    case 3 -> list.forEach(System.out::println);
                    case 4 -> demo();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addDoc() {
        System.out.print("ID: "); int id = Integer.parseInt(sc.nextLine());
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Spec: "); String spec = sc.nextLine();
        list.add(new Doctor(id, name, 30, "M", spec));
    }

    private void addPat() {
        System.out.print("ID: "); int id = Integer.parseInt(sc.nextLine());
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Disease: "); String disease = sc.nextLine();
        list.add(new Patient(id, name, 25, "F", disease));
    }

    private void demo() {
        for (Person p : list) {
            p.work();
            if (p instanceof Treatable) ((Treatable) p).treat();
        }
    }
}