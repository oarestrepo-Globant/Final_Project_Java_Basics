package org.globant.university.data;

import java.util.ArrayList;
import java.util.List;

public class Course {
    //CADA COURSE DEBERIA TENER ID?
    private String name;
    private int classRoomNumber;
    private Teacher assignedTeacher;
    protected List<Student> studentsList;

    public Course(String name, int classRoomNumber) {
        this.name = name;
        this.classRoomNumber = classRoomNumber;
        this.studentsList = new ArrayList<>();
    }

    public Course(String name, int classRoomNumber, Teacher assignedTeacher) {
        this.name = name;
        this.classRoomNumber = classRoomNumber;
        this.assignedTeacher = assignedTeacher;
        this.studentsList = new ArrayList<>();
    }

    public String getName() {
        return name.toUpperCase();
    }

    public int getClassRoomNumber() {
        return classRoomNumber;
    }
    public String printStudentsList(){
        String stringList = "";
        for (Student student: studentsList) {
            stringList = stringList + student;
        }
        return stringList;
    }
    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }
    public void setTeacher(Teacher teacher){
        this.assignedTeacher = teacher;
    }

    public void addStudent(Student student){
        for (Student studentToCompare: this.studentsList)
            if (student.getId() == studentToCompare.getId()) {
                return;
            }
        this.studentsList.add(student);
    }
    public String verifyEnrolledStudent(int studentId){
        String enrolledCourse = "";
        for (Student student:studentsList) {
            if(studentId == student.getId()){
                enrolledCourse = getName() + "\n";
            }
        }
        return enrolledCourse;
    }

    @Override
    public String toString() {
        return ">>>>> " + name.toUpperCase() +" STUDENTS LIST <<<<< \n" +
                " TEACHER: " + assignedTeacher.getNameUpperCase() + "\n" +
                " CLASSROOM #" + classRoomNumber + "\n\n" +
                " STUDENTS \n" +
                printStudentsList() + "\n";
    }


    //Evaluar si es necesario getTeacher, getName, demas getters
    //setTeacher por si cambian de profe en medio de la cursada
    //setClassRoom# por si cambian de salon en medio de la cursada
}
