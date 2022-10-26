package org.globant.university.view;
import org.globant.university.data.Student;
import org.globant.university.data.Teacher;
import org.globant.university.data.TeacherFullTime;
import org.globant.university.data.TeacherPartTime;

public class Main {
    public static void main(String[] args) {
        //Initialize minimum 6 different students
        Student student1 = new Student("Oscar", "Restrepo", 33);
        Student student2 = new Student("Andres", "Borrero", 30);
        Student student3 = new Student("Luisa", "Farias", 25);
        Student student4 = new Student("Daniela", "Cordoba", 22);
        Student student5 = new Student("Henry", "Escobar", 34);
        Student student6 = new Student("Juliana", "Rengifo", 27);

        TeacherFullTime teacher1 = new TeacherFullTime("Gilberto", 1000);
        System.out.println(teacher1);
        TeacherFullTime teacher2 = new TeacherFullTime("Ana", 1000, "1998-02-02" );
        System.out.println(teacher2);
        System.out.println("/////////////");

        TeacherPartTime teacher3 = new TeacherPartTime("Soy Partime", 1000, 2.5);
        System.out.println(teacher3);
        TeacherPartTime teacher4 = new TeacherPartTime("Soy Partime", 1000, 5);
        System.out.println(teacher4);
    }



    //Initialize minimum 2 different teachers of each type (full time, part time)
    // Initialize minimum 4 different classes including its teacher , students and other relevant data
}
