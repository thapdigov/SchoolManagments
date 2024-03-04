/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.menu;

import java.util.Scanner;

/**
 *
 * @author Behruz Tapdiqov
 */
public class MenuUtil {

    public static void startMenu() {

        int userName = ededAl("Welcome to School Managment,Please select item from Menu!!"
                + """
                      
                  1.Admin
                  2.Student
                  3.Teacher
                                """);

        Menu.find(userName).Enumprosess();

    }

    public static String textAl(String baslig) {
        Scanner sc = new Scanner(System.in);
        System.out.println(baslig + ":");
        return sc.nextLine();
    }

    public static int ededAl(String baslig) {
        Scanner sc = new Scanner(System.in);
        System.out.println(baslig + ":");
        return sc.nextInt();
    }

}
