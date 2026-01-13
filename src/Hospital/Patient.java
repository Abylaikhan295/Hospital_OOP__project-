package Hospital;

public class Patient extends Person {

    private String disease;
    private String roomNumber;

    public Patient(int id, String name, int age, String gender, String disease, String roomNumber) {
        super(id, name, age, gender); // MUST be first
        this.disease = disease;
        this.roomNumber = roomNumber;
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

            public String getDisease() {
                return disease;
            }

            public String getRoomNumber() {
                return roomNumber;
            }

            @Override
            public String toString() {
                return super.toString() + ", Disease: " + disease + ", Room: " + roomNumber;
                System.out.println("Patient " + name + " is receiving treatment.");
            }

            @Override
            public String toString() {
                return "[Patient] " + super.toString() +
                        ", Disease: " + disease +
                        ", Admitted: " + admitted;
            }
        }
    }
}