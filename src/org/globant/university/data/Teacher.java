package org.globant.university.data;

public abstract class Teacher {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract protected double calculateSalary();

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Salary: " + calculateSalary() + "\n" ;
    }

//setear salario por si recibe aumento
}
