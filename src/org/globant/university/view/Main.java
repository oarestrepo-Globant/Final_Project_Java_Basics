package org.globant.university.view;
import org.globant.university.data.*;
import org.globant.university.persistence.DataInitializer;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
       University myUniversity = DataInitializer.createUniversity();
       Scanner scan = new Scanner(System.in);

       int option = 0;
       boolean exit = false;
       do{
           System.out.println("***** WELCOME TO GLOBANT UNIVERSITY *****\n" +
                   " 1. PRINT ALL TEACHERS\n" +
                   " 2. PRINT ALL COURSES\n" +
                   " 3. CREATE STUDENT\n" +
                   " 4. CREATE COURSE\n" +
                   " 5. SEARCH COURSES OF STUDENT\n" +
                   " 6. EXIT");

           option = scan.nextInt();
           scan = new Scanner(System.in);

           switch(option){
               case 1:
                   printTeachersData(myUniversity);
               break;
               case 2:
                   printListOfCourses(myUniversity);
               break;
               case 3:
                   createStudent(myUniversity);
                   break;
               case 4:
                   createCourse(myUniversity);
                   break;
               case 5:
                   printStudentCourses(myUniversity);
               break;
               case 6:
                   exit = true;
                   break;
               default :
                   System.out.println("Please enter option between 1 - 6 \n");
                   break;
           }
       }while(option != 6);
    }

    public static void printTeachersData(University university){
        System.out.println("***** GLOBANT TEACHERS LIST *****");
        for (Teacher teacher: university.getTeachersList()) {
            System.out.println(teacher);
        }
        System.out.println("");
    }
    public static void printListOfCourses(University university){
        Scanner scan = new Scanner(System.in);

        int counter = 0;
        System.out.println("***** GLOBANT COURSES *****\n");

        for (Course course: university.getCoursesList()) {
            counter++;
            System.out.println(counter + ". " + university.getCourseNameFromCoursesList(course));
        }
        /*counter++;
        System.out.println(counter + ". Exit\n");*/
        System.out.println( "Select an option to print related data");

        int option = scan.nextInt();
        scan = new Scanner(System.in);
        System.out.println(university.getCourseByIndex(option - 1));
    }
    public static boolean verifyStringIsWord(String word){
        return word.matches("^[a-zA-Z ]*$");
    }
    public static boolean verifyStringIsInt(String word){
        return word.matches("[0-9]+");
    }
    public static void createStudent(University university){
        Scanner scan = new Scanner(System.in);

        boolean  nameAccepted;
        String firstName ;
        do{
            System.out.println(" > Enter student´s first name");
            firstName = scan.nextLine();
            scan = new Scanner(System.in);

            nameAccepted = verifyStringIsWord(firstName);
            if(!nameAccepted){
                System.out.println(" ERROR: This field only accepts letters\n");
                nameAccepted = false;
            }
        }while(!nameAccepted);
        System.out.println("");

        boolean lastNameAccepted;
        String lastName;
        do{
           System.out.println(" > Enter student´s last name");
           lastName = scan.nextLine();
           scan = new Scanner(System.in);

           lastNameAccepted = verifyStringIsWord(lastName);
           if(!lastNameAccepted){
               System.out.println(" ERROR: This field only accepts letters\n");
               lastNameAccepted = false;
           }
        }while(!lastNameAccepted);
        System.out.println("");

        boolean ageAccepted = true;
        String stringAge;
        do{
            System.out.println(" > Enter student´s age");
            stringAge = scan.nextLine();
            scan = new Scanner(System.in);

            ageAccepted = stringAge.matches("[0-9]+");

            if (!ageAccepted){
                System.out.println(" ERROR: This field only accepts numbers between 18 - 99\n");
                ageAccepted = false;
            }
        }while(!ageAccepted);
        int age = parseInt(stringAge);
        System.out.println("");

        //obtener el curos para añadir el estudiant
        //1. print courses list Names
        //2. capturar la opcion seleccionada
        //3. obtener el Course dada la opcion seleccionada
        //4. addStudentToCourse(Student, Course)
        int counter = 0;

        boolean verified = true;
        do{
            System.out.println("***** GLOBANT COURSES *****\n");

            for (Course course: university.getCoursesList()) {
                counter++;
                System.out.println(counter + ". " + university.getCourseNameFromCoursesList(course));
            }
            System.out.println( "Select a course to add student");

        }while(!verified);


        int option = scan.nextInt();
        scan = new Scanner(System.in);
        Course course = university.getCourseByIndex(option - 1);


        Student student = university.createStudent(firstName, lastName, age);
        university.addStudentToCourse( student, course);
        System.out.println("The student " + firstName + " " + lastName + " has been created");
        System.out.println(student.getFullName() + " has been added to " + course.getName() + " course\n" );
    }
    public static void createCourse(University university){
        Scanner scan = new Scanner(System.in);

        boolean verifiedCourseName;
        String courseName;
        do{
            System.out.println(" > Enter the name of the course");
            courseName = scan.nextLine();
            scan = new Scanner(System.in);

            verifiedCourseName = verifyStringIsWord(courseName);
            //deberia comprobar si el nombre ya existe
            if(!verifiedCourseName){
                System.out.println(" ERROR: This field only accepts letters\n");
                verifiedCourseName = false;
            }
        }while(!verifiedCourseName);
        System.out.println("");

        boolean verifiedNumber;
        String classRoomNumber;
        do{
            System.out.println(" > Enter the classroom number");
            classRoomNumber = scan.nextLine();
            scan = new Scanner(System.in);

            verifiedNumber = verifyStringIsInt(classRoomNumber);
            //deberia comprobar si el classroom ya existe
            if(!verifiedNumber){
                System.out.println(" ERROR: This field only accepts numbers\n");
                verifiedNumber = false;
            }
        }while(!verifiedNumber);

        int courseRoomNumber = parseInt(classRoomNumber);
        System.out.println("");

        Teacher teacher = getTeacherToBeAssigned(university);
        System.out.println("The course " + courseName + " has been created\n");
        university.createCourse(courseName, courseRoomNumber, teacher);

        //      >>>>>   ADD STUDENT TO COURSE  <<<<<
        addStudentToCourse(university);

    }
    public static Teacher getTeacherToBeAssigned(University university){
        Scanner scan = new Scanner(System.in);
        int counter = 0;

        System.out.println("***** GLOBANT TEACHERS *****");
        for (Teacher teacher: university.getTeachersList()) {
            counter++;
            System.out.println(counter + ". " + teacher.getFullName());
        }

        int option = scan.nextInt();
        scan = new Scanner(System.in);
        Teacher teacherToBeAssigned = university.getTeacherByIndex(option - 1);
        return teacherToBeAssigned;
    }

    public static void printStudentCourses(University university){
        Scanner scan = new Scanner(System.in);

        System.out.println(" > Enter the student Id");
        int id = scan.nextInt();
        scan = new Scanner(System.in);

        Student student =  university.getStudentById(id);
        System.out.println(">>>>> " + student.getFullName() +  " ENROLLED COURSES <<<<<");
        System.out.println(university.getEnrolledCoursesOfStudent(id) + "\n");
    }

    public static void addStudentToCourse(University university){
        Scanner scan = new Scanner(System.in);
        int studentId = 0;
        String option = "";

        boolean correctOption = true;
        do{
            System.out.println("Add student to course?\n" +
                    "1. Yes\n" +
                    "2. No\n");
            option = scan.nextLine();
            scan = new Scanner(System.in);
            if(verifyStringIsInt(option) && (option.equals("1") || option.equals("2"))){
                correctOption = true;
            } else{
                correctOption = false;
                System.out.println("Please enter number between 1 - 2\n");
            }
        }while(!correctOption);

        boolean exit = false;
        switch(option){
            case "1":
                //1. ME PASAN EL ID DEL ESTUDIANTE A AGREGAR

                System.out.println(" > Enter student Id");
                studentId = scan.nextInt();
                scan = new Scanner(System.in);

                //2. BUSCO EL ESTUDIANTE Y LO DEVUELVO
                Student student = university.getStudentById(studentId);

                //3. Obtengo el curso al que estoy añadiendo estudiantes
                Course createdCourse = university.getLastCourseCreated();

                //4. añado el estudiante al curso si encuentra al estudiante
                if(student.getId() == 0){
                    System.out.println("There is not student with id #" + studentId + "\n");
                    addStudentToCourse(university);
                }
                else {
                    university.addStudentToCourse(student, createdCourse);
                    System.out.println(" > Student succesfully added\n");
                    addStudentToCourse(university);
                }
                break;
            case "2":
                exit = true;
                break;
        }
    }
}












