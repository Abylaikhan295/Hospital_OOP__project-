package model;

public class Patient extends Person implements Treatable {
    private String disease;

    public Patient(int id, String name, int age, String gender, String disease) {
        super(id, name, age, gender);
        this.disease = disease;
    }

    @Override
    public void work() {
        System.out.println(name + " is recovering from " + disease);
    }

    @Override
    public void treat() {
        System.out.println("Applying medical treatment for " + disease);
    }

    @Override
    public String getRole() { return "Patient"; }
}