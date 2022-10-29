package org.globant.university.data;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Student> studentsList;
    private List<Teacher> teachersList;
    private List<Course> coursesList;


    public University(String name) {
        this.name = name;
        this.studentsList = new ArrayList<>();
        this.teachersList = new ArrayList<>();
        this.coursesList = new ArrayList<>();
    }
    public String getStudentsList() {
        String print = "";
        for (Student student: studentsList) {
           print =  print + student;
        }
        return "***** GLOBANT STUDENTS LIST ***** \n\n" + print;
    }
    public Student getStudentByIndex(int index){
        return studentsList.get(index);
    }
    public Teacher getTeacherByIndex(int index){
        return teachersList.get(index);
    }
    public Course getCourseByIndex(int index){
        return coursesList.get(index);
    }

    public List<Course> getCoursesList() {
        return coursesList;
    }
    public String getCourseNameFromCoursesList(Course course){
        return course.getName();
    }
    public String getCourseFullData(Course course) {
            String print = "";
            print = print + course;
        return "***** GLOBANT COURSES LIST ***** \n\n" + print;
    }

    public List<Teacher> getTeachersList() {
        return teachersList;
    }

    public void createCourse(String name, int classRoomNumber, Teacher teacherAssigned){
        for (Course courseToCompare: this.coursesList) {
            if(name.equals(courseToCompare.getName()) ){
                return;
            }
            if(classRoomNumber == courseToCompare.getClassRoomNumber()){
                return;
            }
            if(courseToCompare.getAssignedTeacher() == teacherAssigned){
                return;
            }
        }
        Course course = new Course(name, classRoomNumber, teacherAssigned);
        coursesList.add(course);
    };

    public void createStudent(String firstName, String lastName, int age){
        Student student = new Student(firstName, lastName, age);
        this.studentsList.add(student);
    }

    public void addStudentToCourse(Student student, Course course){
        course.addStudent(student);
    };

    //NO PUEDE HABER DOS TEACHERS IGUALES
    public String createTeacherFullTime(String firstName, String lastName, double salary){
        Teacher teacherFullTime = new TeacherFullTime(firstName, lastName, salary);
        this.teachersList.add(teacherFullTime);
        return teacherFullTime.getFullName() + " created as a fullTime";
    }

    public void createTeacherFullTime(String firstName, String lastName, int salary, String entryDate){
        Teacher teacherFullTime = new TeacherFullTime(firstName, lastName, salary, entryDate);
        this.teachersList.add(teacherFullTime);
    }

    //NO PUEDE HABER DOS TEACHERS IGUALES
    public void createTeacherPartTime(String firstName, String lastName, double salary, double hours){
        Teacher teacherPartTime = new TeacherPartTime(firstName, lastName, salary, hours);
        this.teachersList.add(teacherPartTime);
    }

    public String getEnrolledCoursesOfStudent(int id){
        String enrolledCoursesOfStudent = "";
        for (Course course: this.coursesList) {
            course.verifyEnrolledStudent(id);
            enrolledCoursesOfStudent = enrolledCoursesOfStudent.concat(course.verifyEnrolledStudent(id))  ;
        }
        return enrolledCoursesOfStudent.equals("") ? "The student has not enrolled courses yet" : enrolledCoursesOfStudent;
    };

}
