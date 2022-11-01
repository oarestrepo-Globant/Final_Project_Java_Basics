package org.globant.university.persistence;

import org.globant.university.data.*;

public class DataInitializer {
    public static University createUniversity(){
        University university = new University("Globant");
        loadTeachersIntoUniversity(university);
        loadStudentsIntoUniversity(university);
        loadCoursesIntoUniversity(university);
        studentToCourse(university);
        return university;
    }

    private static void loadTeachersIntoUniversity(University university){
        university.createTeacherFullTime("Gilberto", "Rodriguez", 10000,"2010-09-12");
        university.createTeacherFullTime("Ana","Navia", 10000, "2013-01-02");
        university.createTeacherPartTime("Nubia","Coronado", 1000, 3.5);
        university.createTeacherPartTime("Jaime","Rios", 1000, 5);

    }
    private static void loadStudentsIntoUniversity(University university){
        university.createStudentInitializer("Oscar", "Restrepo", 33);
        university.createStudentInitializer("Andres", "Borrero", 22);
        university.createStudentInitializer("Luisa", "Escobar", 25);
        university.createStudentInitializer("Daniela", "Cordoba", 29);
        university.createStudentInitializer("Martha", "Uribe", 20);
        university.createStudentInitializer("Dario", "Duque", 31);
        university.createStudentInitializer("Fernanda", "Cordero", 28);
        university.createStudentInitializer("Gloria", "Farias", 35);

    }
    private static void loadCoursesIntoUniversity(University university){
        university.createCourse("Java Basics", 101,university.getTeacherByIndex(0));
        university.createCourse("Python Basics", 102,university.getTeacherByIndex(1));
        university.createCourse("Javascript Basics", 103,university.getTeacherByIndex(2));
        university.createCourse("Java Advanced", 104,university.getTeacherByIndex(3));
    }

    private static void studentToCourse(University university){
        university.addStudentToCourse(university.getStudentByIndex(0), university.getCourseByIndex(0));
        university.addStudentToCourse(university.getStudentByIndex(1), university.getCourseByIndex(0));
        university.addStudentToCourse(university.getStudentByIndex(2), university.getCourseByIndex(0));
        university.addStudentToCourse(university.getStudentByIndex(3), university.getCourseByIndex(0));

        university.addStudentToCourse(university.getStudentByIndex(4), university.getCourseByIndex(1));
        university.addStudentToCourse(university.getStudentByIndex(5), university.getCourseByIndex(1));
        university.addStudentToCourse(university.getStudentByIndex(6), university.getCourseByIndex(1));
        university.addStudentToCourse(university.getStudentByIndex(7), university.getCourseByIndex(1));

        university.addStudentToCourse(university.getStudentByIndex(6), university.getCourseByIndex(2));
        university.addStudentToCourse(university.getStudentByIndex(7), university.getCourseByIndex(2));
        university.addStudentToCourse(university.getStudentByIndex(0), university.getCourseByIndex(2));
        university.addStudentToCourse(university.getStudentByIndex(1), university.getCourseByIndex(2));

        university.addStudentToCourse(university.getStudentByIndex(7), university.getCourseByIndex(3));
        university.addStudentToCourse(university.getStudentByIndex(4), university.getCourseByIndex(3));
        university.addStudentToCourse(university.getStudentByIndex(6), university.getCourseByIndex(3));
        university.addStudentToCourse(university.getStudentByIndex(5), university.getCourseByIndex(3));
    }
}