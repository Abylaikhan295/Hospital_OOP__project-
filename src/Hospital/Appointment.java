package Hospital;

public class Appointment {

    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private boolean completed;

    public Appointment(String appointmentId, Patient patient, Doctor doctor, String date) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.completed = false;
    }

    public void completeAppointment() {
        completed = true;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId +
                "\nPatient: " + patient.getName() +
                "\nDoctor: " + doctor.getName() +
                "\nDate: " + date +
                "\nCompleted: " + completed;
    }

    public static class Person {
    }
}
