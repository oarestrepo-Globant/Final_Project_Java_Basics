package org.globant.university.data;

public class TeacherPartTime extends Teacher{
    private double salary;
    private double activeWeeklyHours;

    public TeacherPartTime(String name, double salary, double weeklyHours) {
        super(name);
        this.salary = salary;
        this.activeWeeklyHours = weeklyHours;
    }

    @Override
    protected double calculateSalary() {
        return salary * activeWeeklyHours;
    }
}
