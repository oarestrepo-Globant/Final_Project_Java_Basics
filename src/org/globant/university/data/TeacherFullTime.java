package org.globant.university.data;
import java.time.LocalDate;
import java.time.Period;

public class TeacherFullTime extends Teacher {
    private double salary;
    static private double multiplier = 1.1;
    private final LocalDate entryDate;

    public TeacherFullTime(String firstName, String lastName, double salary, String entryDate){
        super(firstName,lastName, "Full Time");
        this.salary = salary;
        this.entryDate = LocalDate.parse(entryDate);
    }
    public int calculateExperienceYears() {
        LocalDate actualDate = LocalDate.now();
        Period period = Period.between(entryDate, actualDate) ;
        return period.getYears();
    }
    @Override
    protected double calculateSalary() {
        if (calculateExperienceYears() >= 1) {
            return salary * (multiplier * calculateExperienceYears());
        } else {
            return salary;
        }
    }

}

