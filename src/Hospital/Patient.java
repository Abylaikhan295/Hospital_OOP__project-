package Hospital;

public class Patient extends Person {
    private String disease;
    private String roomNumber;

    public Patient(int id, String name, int age, String gender, String disease, String roomNumber) {
        super(id, name, age, gender);
        if (disease == null || disease.equals("")) throw new IllegalArgumentException("Disease required");
        if (roomNumber == null || roomNumber.equals("")) throw new IllegalArgumentException("Room required");

        this.disease = disease;
        this.roomNumber = roomNumber;
    }

    @Override
    public void work() {
        System.out.println(name + " is being treated for " + disease);
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    public void takeMedicine() {
        System.out.println(name + " is taking medicine.");
    }

    public void requestNurse() {
        System.out.println(name + " is calling the nurse.");
    }

    public String getDisease() { return disease; }
    public String getRoomNumber() { return roomNumber; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Disease: " + disease);
        System.out.println("Room: " + roomNumber);
    }

    @Override
    public String toString() {
        return super.toString() + " | Disease: " + disease + ", Room: " + roomNumber;
    }
}
