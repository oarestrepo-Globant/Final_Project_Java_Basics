package org.globant.university.data;


public abstract class Teacher {
    private String firstName;
    private String lastName;
    private String fullName;
    private String teacherModality;

    public Teacher(String firstName, String lastName, String teacherModality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = this.firstName + " " + this.lastName;
        this.teacherModality = teacherModality;
    }
    public String getFullName() {
        return fullName;
    }
    public String getNameUpperCase() {
        return fullName.toUpperCase();
    }
    abstract protected double calculateSalary();

    @Override
    public String toString() {
        return ">> Name: " + fullName + "\n" +
                "   Salary: " + calculateSalary() + "\n" +
                "   " + teacherModality ;
    }
}
