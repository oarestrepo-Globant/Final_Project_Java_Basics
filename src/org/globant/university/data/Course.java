package org.globant.university.data;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private int classRoomNumber;
    private Teacher assignedTeacher;
    List<Student> studentsList;

    public Course(String name, int classRoomNumber) {
        this.name = name;
        this.classRoomNumber = classRoomNumber;
        this.studentsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getClassRoomNumber() {
        return classRoomNumber;
    }

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }
    public String printStudentsList(){
        String stringList ="";
        for (Student student: studentsList) {
            stringList = stringList + student;
        }
        return stringList;
    }
    public String addStudent(Student student){
        for (Student studentToCompare: studentsList) {
            if(student.getId() == studentToCompare.getId()){
                return "The student " + student.getFullName() + " is already on the list \n";
            }
        }
        studentsList.add(student);
        return "The student has been successfully added";
    }

    public void setTeacher(Teacher teacher){
        assignedTeacher = teacher;
    }

    @Override
    public String toString() {
        return"***** " + name.toUpperCase() +" STUDENTS LIST *****\n" +
                " CLASSROOM #" + classRoomNumber + "\n" +
                " TEACHER: " + assignedTeacher.getNameUpperCase() + "\n\n" +
                " STUDENTS \n" +
                printStudentsList();
    }


    //Evaluar si es necesario getTeacher, getName, demas getters
    //setTeacher por si cambian de profe en medio de la cursada
    //setClassRoom# por si cambian de salon en medio de la cursada
}
