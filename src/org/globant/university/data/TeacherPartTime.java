package org.globant.university.data;

public class TeacherPartTime extends Teacher{
    private double salary;
    private double activeWeeklyHours;

    public TeacherPartTime(String firstName, String lastName, double salary, double weeklyHours) {
        super(firstName, lastName, "Part Time");
        this.salary = salary;
        this.activeWeeklyHours = weeklyHours;

    }

    @Override
    protected double calculateSalary() {
        return salary * activeWeeklyHours;
    }
}
