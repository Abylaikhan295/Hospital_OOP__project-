package model;

import exception.InvalidInputException;

public class Doctor extends Person implements Treating {

    private String specialization;
    private int experienceYears;

    public Doctor(int id, String name, int age, String department,
                  String specialization, int experienceYears) {
        super(id, name, age, department);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.isBlank()) {
            throw new InvalidInputException("Specialization cannot be empty");
        }
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new InvalidInputException("Experience cannot be negative");
        }
        this.experienceYears = experienceYears;
    }

    public boolean isExperienced() {
        return experienceYears >= 10;
    }

    @Override
    public void treat() {
        System.out.println("Doctor " + name + " is treating patients.");
    }

    @Override
    public void work() {
        System.out.println("Doctor " + name + " works in " + specialization);
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Spec: " + specialization +
                " | Exp: " + experienceYears + " yrs";
    }
}
