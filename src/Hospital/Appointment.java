package Hospital;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;

    public Appointment(Patient patient, Doctor doctor, String date, String time) {
        if (patient == null || doctor == null) throw new IllegalArgumentException("Patient and doctor required");
        if (date == null || date.equals("")) throw new IllegalArgumentException("Date required");
        if (time == null || time.equals("")) throw new IllegalArgumentException("Time required");

        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public void showInfo() {
        System.out.println("Appointment: " + patient.getName() + " with Dr. " + doctor.getName() + " on " + date + " at " + time);
    }
    public void cancelAppointment() {
        System.out.println("Appointment for " + patient.getName() + " with Dr. " + doctor.getName() + " has been cancelled.");
    }

    public void reschedule(String newDate, String newTime) {
        this.date = newDate;
        this.time = newTime;
        System.out.println("Appointment rescheduled to " + date + " at " + time);
    }

    public boolean isDoctorAvailable(String checkTime) {
        // Simple demo: return true if appointment time is different
        return !checkTime.equals(time);
    }

    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }

    @Override
    public String toString() {
        return "Patient: " + patient.getName() + ", Doctor: " + doctor.getName() + ", Date: " + date + ", Time: " + time;
    }
}
