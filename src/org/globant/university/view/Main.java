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
                   //search courses of student
                   break;
//               case 6:
//                   exit = true;
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
        System.out.println("***** GLOBANT COURSES *****");
        for (Course course: university.getCoursesList()) {
            counter++;
            System.out.println(counter + ". " + university.getCourseNameFromCoursesList(course));
        }
        counter++;
        System.out.println(counter + ". Exit\n");

        int option = scan.nextInt();
        scan = new Scanner(System.in);
        System.out.println(university.getCourseByIndex(option - 1));
    }
    public static boolean verifyStringIsWord(String word){
        return word.matches("^[a-zA-Z]*$");
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

        university.createStudent(firstName, lastName, age);
        System.out.println("The student " + firstName + " " + lastName + " has been created\n");
    }
    public static void createCourse(University university){
        Scanner scan = new Scanner(System.in);

        boolean verifiedFirstName;
        String courseName;
        do{
            System.out.println(" > Enter the name of the course");
            courseName = scan.nextLine();
            scan = new Scanner(System.in);

            verifiedFirstName = verifyStringIsWord(courseName);

            if(!verifiedFirstName){
                System.out.println(" ERROR: This field only accepts letters\n");
                verifiedFirstName = false;
            }
        }while(!verifiedFirstName);
        System.out.println("");

        boolean verifiedNumber;
        String classRoomNumber;
        do{
            System.out.println(" > Enter the classroom number");
            classRoomNumber = scan.nextLine();
            scan = new Scanner(System.in);

            verifiedNumber = verifyStringIsInt(classRoomNumber);

            if(!verifiedNumber){
                System.out.println(" ERROR: This field only accepts numbers\n");
                verifiedNumber = false;
            }
        }while(!verifiedNumber);
        int courseRoomNumber = parseInt(classRoomNumber);
        System.out.println("");

        // imprimir lista de nombres de profesores
        // me dan el nombre/id de un profesor
        // lo busco en university.teachersList
        // le paso el teacher a university.createCourse()
    }
}












