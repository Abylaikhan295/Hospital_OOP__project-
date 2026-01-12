package Hospital;
public abstract class Person {
    protected String id;
    protected String name;
    protected int age;
    public Person(String id, String name, int age) {
        setId(id);
        setName(name);
        setAge(age);
    }
    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
        this.id = id;
    }
    public void setName(String name) {
        if (name == null || name.length() < 2) {
            throw new IllegalArgumentException("Name must be at least 2 characters");
        }
        this.name = name;
    }
    public void setAge(int age) {
        if (age <= 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age");
        }
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public abstract void work();
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}
