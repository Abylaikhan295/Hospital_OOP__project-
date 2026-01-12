package Hospital;

public class Patient extends Hospital.Person {

    private String disease;
    private boolean admitted;

    public Patient(String id, String name, int age, String disease, boolean admitted) {
        super(id, name, age);   // super() → parent constructor
        setDisease(disease);
        this.admitted = admitted;
    }

    public void setDisease(String disease) {
        if (disease == null || disease.isEmpty()) {
            throw new IllegalArgumentException("Disease cannot be empty");
        }
        this.disease = disease;
    }

    @Override
    public void work() {
        System.out.println("Patient " + name + " is receiving treatment.");
    }

    @Override
    public String toString() {
        return "[Patient] " + super.toString() +
                ", Disease: " + disease +
                ", Admitted: " + admitted;
    }
}
