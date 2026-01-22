package model;

import exception.InvalidInputException;

public abstract class Person {

    protected int id;
    protected String name;
    protected int age;
    protected String department;

    public Person(int id, String name, int age, String department) {
        setId(id);
        setName(name);
        setAge(age);
        setDepartment(department);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }

    public void setId(int id) {
        if (id <= 0) {
            throw new InvalidInputException("ID must be positive");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidInputException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new InvalidInputException("Invalid age");
        }
        this.age = age;
    }

    public void setDepartment(String department) {
        if (department == null || department.isBlank()) {
            throw new InvalidInputException("Department cannot be empty");
        }
        this.department = department;
    }

    public abstract void work();
    public abstract String getRole();

    @Override
    public String toString() {
        return "[" + getRole() + "] " + name +
                " | ID: " + id +
                " | Age: " + age +
                " | Dept: " + department;
    }
}
