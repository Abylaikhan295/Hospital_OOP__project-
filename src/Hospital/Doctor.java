package Hospital;

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
