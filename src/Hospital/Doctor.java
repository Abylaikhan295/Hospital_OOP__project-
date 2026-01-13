package Hospital;
public class Doctor extends Person {

    private String specialization;
    private int salary;

    public Doctor(int id, String name, int age, String gender, String specialization, int salary) {
        super(id, name, age, gender); // MUST be first
        this.specialization = specialization;
public class Doctor extends Hospital.Person {

    private String specialization;
    private int experienceYears;
    private double salary;

    public Doctor(String id, String name, int age, String specialization, int experienceYears, double salary) {
        super(id, name, age);   // super() → parent constructor
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
        setSalary(salary);
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be empty");
        }
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Experience cannot be negative");
        }
        this.experienceYears = experienceYears;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive");
        }
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
    public String toString() {
        return super.toString() + ", Specialization: " + specialization + ", Salary: " + salary;
        System.out.println("Doctor " + name + " is treating patients.");
    }

    @Override
    public String toString() {
        return "[Doctor] " + super.toString() +
                ", Specialization: " + specialization +
                ", Experience: " + experienceYears +
                ", Salary: " + salary;
    }

    public void diagnose(Hospital.Patient patient) {
        System.out.println(name + " is diagnosing " + patient.getName());
    }
}
