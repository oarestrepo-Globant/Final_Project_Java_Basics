package org.globant.university.data;

import java.util.List;

public class Student {
    static int consecutive = 1000;
    private String firstName;
    private String lastName;
    final private String fullName;
    private int age;
    final private int id;

    public Student(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = this.firstName + " " + this.lastName;
        this.age = age;
        this.consecutive = this.consecutive + 1;
        this.id = consecutive;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString(){
        return " Name: " + this.fullName + "\n" +
                " Age: " + this.age + "\n" +
                " Id: " + this.id + "\n" ;
    }

    //incrementar la edad
}
