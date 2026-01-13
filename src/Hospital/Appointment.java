package Hospital;

public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;

    public Appointment(Patient patient, Doctor doctor, String date, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public void showInfo() {
        System.out.println("Appointment: " + patient.getName() +
                " with Dr. " + doctor.getName() +
                " on " + date + " at " + time);
    }

    @Override
    public String toString() {
        return "Patient: " + patient.getName() + ", Doctor: " + doctor.getName() +
                ", Date: " + date + ", Time: " + time;
    }
}
