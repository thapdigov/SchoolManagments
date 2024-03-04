/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.menu.service;

import az.perfect.config.Context;
import az.perfect.dao.inter.StudentInterFace;
import az.perfect.entity.School;
import az.perfect.entity.Student;
import az.perfect.entity.Teacher;
import az.perfect.menu.MenuUtil;
import java.util.Scanner;

/**
 *
 * @author Behruz Tapdiqov
 */
public class StudentMenu implements MenuService {

    private static StudentInterFace student = Context.inctanceStudent();
    private static boolean logeddin = false;
    Student st;

    @Override
    public void prosess() {
        System.out.println("Student menyusuna daxil oldunuz!!");

        while (true) {
            int user = MenuUtil.ededAl("Please ,Select Menu!!"
                    + """
                  
                 1.Login
                 2.Register
                 3.ShowAllStudents
                 4.LogOut
                 5.Exit    
                """);

            switch (user) {
                case 1:
                    login();
                    break;
                case 2:
                    if (logeddin) {
                        System.out.println("Siz qeydiyyatdan kecmisiniz!");
                    } else {
                        register();
                    }

                    break;
                case 3:
                    if (logeddin) {
                        System.out.println(Context.inctanceTeacher().getallTeachers());
                    } else {
                        login();
                    }

                    break;

                case 4:
                    logeddin = false;

                    break;
                case 5:
                    System.exit(0);

                    break;

                default:
                    System.out.println("Duzgun secim edin!!!");
            }

        }
    }

    public static void login() {
        System.out.println("Please,Sign in:");
        int ID = MenuUtil.ededAl("Id");
        String pasword = MenuUtil.textAl("Pasword");
        Student st = student.getStudentByIdByPasword(ID, pasword);
        if (st != null) {
            logeddin = true;
        }

    }

    public static void register() {
        String st_name = MenuUtil.textAl("Telebenin adini daxil edin");
        String st_surname = MenuUtil.textAl("Telebenin soyadini daxil edin");
        int st_age = MenuUtil.ededAl("Telebenin yasini daxil edin");
        String st_pasword = MenuUtil.textAl("Telebenin parolunu  daxil edin");
        int schoosl_id = MenuUtil.ededAl("Mekteb ID-ni daxil edin");
        int tc_id = MenuUtil.ededAl("Muellim ID-ni daxil edin");
        Student st = new Student(st_name, st_surname, st_age,
                st_pasword, new School(schoosl_id), new Teacher(tc_id));

        student.insert(st);

        System.out.println("----------------------");

        int id = student.getStudentByPasword(st.getPasword());
        System.out.println("Siz qeydiyyatdan kecdiniz:Sizin ID: " + id);

    }

}
