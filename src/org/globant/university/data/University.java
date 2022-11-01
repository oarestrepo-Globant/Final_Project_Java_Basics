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
    public List<Teacher> getTeachersList() {
        return teachersList;
    }
    public String getEnrolledCoursesOfStudent(int id){
        String enrolledCoursesOfStudent = "";
        for (Course course: this.coursesList) {
            course.verifyEnrolledStudent(id);
            enrolledCoursesOfStudent = enrolledCoursesOfStudent.concat(course.verifyEnrolledStudent(id))  ;
        }
        return enrolledCoursesOfStudent.equals("") ? "The student has not enrolled courses yet" : enrolledCoursesOfStudent;
    };
    public Student getStudentById(int id){
        Student studentFounded = new Student();
        for(Student student: studentsList){
            if(student.getId() == id){
                studentFounded = student;
            }
        }
        return studentFounded ;
    }

    public Course getLastCourseCreated(){
        Course course = getCourseByIndex(coursesList.size() - 1);
        return course;
    }

    public String createCourse(String name, int classRoomNumber, Teacher teacherAssigned){
        String message = "";
        for (Course courseToCompare: this.coursesList) {
            //verifica que no haya dos cursos con nombres iguales
            if(name.equals(courseToCompare.getName()) ){
                message = "The course " +  name + " already exists";
                return message ;
            }
        }
        message = "The course has been successfully created";
        Course course = new Course(name, classRoomNumber, teacherAssigned);
        coursesList.add(course);
        return message;
    };

    public void createStudentInitializer(String firstName, String lastName, int age){
        Student student = new Student(firstName, lastName, age);
        this.studentsList.add(student);
    }
    public Student createStudent(String firstName, String lastName, int age){
        Student student = new Student(firstName, lastName, age);
        return student;
    }

    public void addStudentToCourse(Student student, Course course){
        course.addStudent(student);
    };

    public void createTeacherFullTime(String firstName, String lastName, int salary, String entryDate){
        Teacher teacherFullTime = new TeacherFullTime(firstName, lastName, salary, entryDate);
        this.teachersList.add(teacherFullTime);
    }

    public void createTeacherPartTime(String firstName, String lastName, double salary, double hours){
        Teacher teacherPartTime = new TeacherPartTime(firstName, lastName, salary, hours);
        this.teachersList.add(teacherPartTime);
    }

}
