package org.globant.university.data;

public class Student {
    static int consecutive = 1000;
    private String firstName;
    private String lastName;
    final private String fullName;
    //puedo usar age con localDate, asi se actualiza siempre la edad
    private int age;
    final private int id;
    //NO PUEDE HABER DOS STUDIANTES IGUALES, TENDRIA QUE CREAR UN ATRIBUTO DNI
    public Student(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = this.firstName + " " + this.lastName;
        this.age = age;
        this.consecutive = this.consecutive + 1;
        this.id = consecutive;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString(){
        return ">> Name: " + this.fullName + "\n" +
                "   Age: " + this.age + "\n" +
                "   Id: " + this.id + "\n" ;
    }
    //NO PUEDE HABER DOS STUDIANTES IGUALES, TENDRIA QUE CREAR UN ATRIBUTO DNI
    //incrementar la edad
}
