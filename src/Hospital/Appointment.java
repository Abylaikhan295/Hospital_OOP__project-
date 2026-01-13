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

        public void completeAppointment () {
            completed = true;
        }

        @Override
        public String toString () {
            return "Patient: " + patient.getName() + ", Doctor: " + doctor.getName() +
                    ", Date: " + date + ", Time: " + time;
            return "Appointment ID: " + appointmentId +
                    "\nPatient: " + patient.getName() +
                    "\nDoctor: " + doctor.getName() +
                    "\nDate: " + date +
                    "\nCompleted: " + completed;
        }

        public static class Person {
        }
    }
}
