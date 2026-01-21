package model;

public class Doctor extends Person {
    private String specialization;

    public Doctor(int id, String name, int age, String gender, String specialization) {
        super(id, name, age, gender);
        this.specialization = specialization;
    }

    @Override
    public void work() {
        System.out.println("Dr. " + name + " is treating patients in " + specialization);
    }

    @Override
    public String getRole() { return "Doctor"; }
}