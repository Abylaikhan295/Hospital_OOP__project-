package model;

public abstract class Person {
    protected int id;
    protected String name;
    protected int age;
    protected String gender;

    public Person(int id, String name, int age, String gender) {
        setId(id);
        setName(name);
        setAge(age);
        this.gender = gender;
    }

    public abstract void work();
    public abstract String getRole();

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID must be positive!");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name required!");
        this.name = name;
    }

    public void setAge(int age) {
        if (age <= 0) throw new IllegalArgumentException("Age must be positive!");
        this.age = age;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "[" + getRole() + "] ID: " + id + ", Name: " + name;
    }
}