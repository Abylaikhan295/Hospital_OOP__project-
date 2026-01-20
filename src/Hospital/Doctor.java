package Hospital;

public class Doctor extends Person {
    private String specialization;
    private int salary;

    public Doctor(int id, String name, int age, String gender, String specialization, int salary) {
        super(id, name, age, gender);
        if (specialization == null || specialization.equals("")) throw new IllegalArgumentException("Specialization required");
        if (salary < 0) throw new IllegalArgumentException("Salary cannot be negative");

        this.specialization = specialization;
        this.salary = salary;
    }

    @Override
    public void work() {
        System.out.println("Dr. " + name + " is treating patients as a " + specialization);
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    public void writePrescription() {
        System.out.println("Dr. " + name + " is writing a prescription.");
    }

    public void performSurgery() {
        System.out.println("Dr. " + name + " is performing surgery.");
    }

    public String getSpecialization() { return specialization; }
    public int getSalary() { return salary; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
        System.out.println("Salary: " + salary);
    }

    @Override
    public String toString() {
        return super.toString() + " | Specialization: " + specialization + ", Salary: " + salary;
    }
}
