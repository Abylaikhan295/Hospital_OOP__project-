package Hospital;

public abstract class Person {
    protected int id;
    protected String name;
    protected int age;
    protected String gender;

    public Person(int id, String name, int age, String gender) {
        if (id <= 0) throw new IllegalArgumentException("ID must be positive");
        if (name == null || name.equals("")) throw new IllegalArgumentException("Name required");
        if (age <= 0) throw new IllegalArgumentException("Age must be positive");
        if (gender == null || gender.equals("")) throw new IllegalArgumentException("Gender required");

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }

    public abstract void work();
    public abstract String getRole();

    // Concrete method
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }

    @Override
    public String toString() {
        return "[" + getRole() + "] " + name + " (ID: " + id + ", Age: " + age + ", Gender: " + gender + ")";
    }
}
