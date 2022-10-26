package org.globant.university.data;
import java.time.LocalDate;
import java.time.Period;

public class TeacherFullTime extends Teacher {
    private double salary;
    static private double multiplier = 1.1;
    private final LocalDate entryDate;
    public TeacherFullTime(String name, double salary) {
        super(name);
        this.entryDate = LocalDate.now();
        this.salary = salary;
    }
    public TeacherFullTime(String name, double salary, String entryDate){
        super(name);
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

    //salary return solo dos decimales
    //generar reporte con fecha de corte futura
}

