/*
    Improvements Added:
    1. Moved switch-case implementations inside a callable function for better code organization
    2. Changed some terminologies (e.g. 'delete' to 'remove' [user-friendly])
    3. Added additional comments for better code organization

    Further Suggestions:
    1. Consider making another class for the switch-case implementations in `Main.java`
    2. Current codebase is confusing (some file implementations are redundant)
*/

package main;

import features.*;
import models.*;
import util.*;

import java.util.Scanner;

public class Main {
    // SUGGESTION: Consider making another class for the switch-case implementations in `Main.java`
    // [ METHOD ]: Add a student to the 'classroom'
    public void addStudent() {
        System.out.print("Name: "); String n = sc.nextLine();
        System.out.print("Email: "); String e = sc.nextLine();
        System.out.print("Phone: "); String p = sc.nextLine();
        System.out.print("Pass: "); String pw = sc.nextLine();
        User s = um.addStudent(n, e, p, pw);
        System.out.println("Student added: " + s.userId);
    }

    // [ METHOD ]: Remove a student from the 'classroom'
    public void removeStudent() {
        System.out.print("Student ID: ");
        String id = sc.nextLine();
        System.out.println(um.deleteStudent(id) ? "Deleted" : "Not found");
    }

    // [ METHOD ]: Add a course to the course list
    public void addCourse() {
        System.out.print("Course Name: "); String cn = sc.nextLine();
        System.out.print("Duration: "); String d = sc.nextLine();
        CourseModel c = cm.addCourse(cn, d);
        System.out.println("Course added: " + c.courseId);
    }

    // [ METHOD ]: Remove a course from the course list
    public void removeCourse() {
            System.out.print("Course ID: ");
        String id = sc.nextLine();
        System.out.println(cm.deleteCourse(id) ? "Deleted" : "Not found");
    }

    // [ METHOD ]: Enroll a student to a specified course
    public void enrollStudent() {
        System.out.print("Course ID: ");
        String id = sc.nextLine();
        System.out.println(cm.deleteCourse(id) ? "Deleted" : "Not found");
    }

    // [ METHOD ]: Unenroll a student from a specified course
    public void unenrollStudent() {
        System.out.print("Student ID: "); String sid = sc.nextLine();
        System.out.print("Course ID: "); String cid = sc.nextLine();
        System.out.println(em.unenroll(sid, cid) ? "Unenrolled" : "Failed");
    }

    // [ METHOD ]: Login user
    public void login() {
        System.out.print("Email: "); String e = sc.nextLine();
        System.out.print("Pass: "); String pw = sc.nextLine();
        LoginModel lm = new LoginModel(e, pw);
        User u = em.login(lm);
        System.out.println(u != null ? "Login Success " + u.userType : "Invalid");
    }

    // [ METHOD ]: Display list of current users
    public void displayUsersList() {
        for (int i = 0; i < Utils.userCount; i++) {
            User u = Utils.users[i];
            System.out.println(u.userId + " " + u.username + " " + u.userType);
        }
    }

    // [ METHOD ]: Display list of available courses
    public void displayCoursesList() {
        for (int i = 0; i < Utils.courseCount; i++) {
            CourseModel c = Utils.courses[i];
            System.out.println(c.courseId + " " + c.courseName);
        }
    }

    public void main(String[] args) {
        UserManagement um = new UserManagement();
        CourseManagement cm = new CourseManagement();
        EnrollmentManagement em = new EnrollmentManagement();

        // creating default admin for example
        em.register("Admin", "admin@example.com", "000", "admin123", "admin");

        Scanner sc = new Scanner(System.in);
        while (true) {
            // UPDATE: Changed the term 'delete' to 'remove'
            // UPDATE: Separate line prints for easier debugging
            System.out.print("Add Student\n");
            System.out.print("Remove Student\n");
            System.out.print("Add Course\n");
            System.out.print("Remove Course\n");
            System.out.print("Enroll Student\n");
            System.out.print("Unenroll Student\n");
            System.out.print("Login\n");
            System.out.print("Display Users List\n");
            System.out.print("Display Courses List\n");
            System.out.print("Exit\n");
            System.out.println("------------------");

            // Prompt user to enter choice
            System.out.print(" Please Enter Your Choice : ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 0) break;
            switch (ch) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> addCourse();
                case 4 -> removeCourse();
                case 5 -> enrollStudent();
                case 6 -> unenrollStudent();
                case 7 -> login();
                case 8 -> displayUsersList();
                case 9 -> displayCourseList();
            }
        }
        sc.close();
    }
}
