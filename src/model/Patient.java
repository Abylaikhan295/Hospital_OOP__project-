package model;

import exception.InvalidInputException;

public class Patient extends Person implements Treating {

    private String illness;
    private boolean checked;

    public Patient(int id, String name, int age, String department,
                   String illness, boolean checked) {
        super(id, name, age, department);
        setIllness(illness);
        this.checked = checked;
    }

    public void setIllness(String illness) {
        if (illness == null || illness.isBlank()) {
            throw new InvalidInputException("Illness cannot be empty");
        }
        this.illness = illness;
    }

    @Override
    public void treat() {
        System.out.println("Patient " + name + " is treated for " + illness);
    }

    @Override
    public void work() {
        System.out.println("Patient " + name + " is under observation.");
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Illness: " + illness +
                " | Checked: " + checked;
    }
}
