package Hospital;

public class Person {
    protected int id;
    protected String name;
    protected int age;
    protected String gender;

    public Person() {}

    public Person(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void work() {
        System.out.println(name + " is working at the hospital.");
    }

    public String getRole() {
        return "Person";
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }

    @Override
    public String toString() {
        return "[" + getRole() + "] ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}
