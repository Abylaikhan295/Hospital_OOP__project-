package model;

import exception.InvalidInputException;

public class Appointment {

    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(int appointmentId, Patient patient, Doctor doctor, String date) {
        setAppointmentId(appointmentId);
        setPatient(patient);
        setDoctor(doctor);
        setDate(date);
    }

    public void setAppointmentId(int appointmentId) {
        if (appointmentId <= 0) {
            throw new InvalidInputException("Appointment ID must be positive");
        }
        this.appointmentId = appointmentId;
    }

    public void setPatient(Patient patient) {
        if (patient == null) {
            throw new InvalidInputException("Patient cannot be null");
        }
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        if (doctor == null) {
            throw new InvalidInputException("Doctor cannot be null");
        }
        this.doctor = doctor;
    }

    public void setDate(String date) {
        if (date == null || date.isBlank()) {
            throw new InvalidInputException("Date cannot be empty");
        }
        this.date = date;
    }

    public void cancel() {
        date = "Canceled";
    }

    public boolean isCanceled() {
        return "Canceled".equals(date);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "ID=" + appointmentId +
                ", Patient=" + patient.getName() +
                ", Doctor=" + doctor.getName() +
                ", Date='" + date + '\'' +
                '}';
    }
}
