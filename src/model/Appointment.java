package model;

public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;

    public Appointment(Patient patient, Doctor doctor, String date, String time) {
        if (patient == null || doctor == null)
            throw new IllegalArgumentException("Patient and Doctor are required.");
        if (date == null || date.isEmpty() || time == null || time.isEmpty())
            throw new IllegalArgumentException("Date and time are required.");

        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public void showInfo() {
        System.out.println("Appointment: " + patient.getName() + " with Dr. " + doctor.getName() +
                " on " + date + " at " + time);
    }

    public void cancelAppointment() {
        System.out.println("Appointment for " + patient.getName() + " with Dr. " + doctor.getName() +
                " has been cancelled.");
    }

    public void reschedule(String newDate, String newTime) {
        this.date = newDate;
        this.time = newTime;
        System.out.println("Appointment rescheduled to " + date + " at " + time);
    }

    public boolean isDoctorAvailable(String checkTime) {
        return !checkTime.equals(time);
    }

    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }

    @Override
    public String toString() {
        return "Appointment: " + patient.getName() + " with Dr. " + doctor.getName() +
                " on " + date + " at " + time;
    }
}
