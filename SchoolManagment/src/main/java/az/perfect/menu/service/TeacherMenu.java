/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.menu.service;

import az.perfect.config.Context;
import az.perfect.dao.inter.TeacherInterFace;
import az.perfect.entity.School;
import az.perfect.entity.Student;
import az.perfect.entity.Teacher;
import az.perfect.menu.MenuUtil;

/**
 *
 * @author Behruz Tapdiqov
 */
public class TeacherMenu implements MenuService {
    
    private static TeacherInterFace teacher = Context.inctanceTeacher();
    private static boolean logeddin = false;
    
    @Override
    public void prosess() {
        
        while (true) {
            System.out.println("Teacher menyusuna daxil oldunuz!!");
            int user = MenuUtil.ededAl("Please ,Select Menu!!"
                    + """
                  
                 1.Login
                 2.Register
                 3.ShowAllTeachers
                 4.Exit
                """);
            
            switch (user) {
                case 1:
                    login();
                    
                    break;
                case 2:
                    if (logeddin) {
                        System.out.println("Siz qeydiyatdan kecmisiniz!!!");
                    } else {
                        register();
                        
                    }
                    break;
                case 3:
                    if (logeddin) {
                        System.out.println(teacher.getallTeachers());
                    } else {
                        login();
                    }
                    break;
                case 4:
                    int id = MenuUtil.ededAl("Teacher ID:");
                    Teacher t = new Teacher(id);
                    int cavab = MenuUtil.ededAl("LogOut etmek istediyinize eminsiniz?"
                            + """
                              
                              1.beli
                              2.xeyr
                              """);
                    switch (cavab) {
                        case 1:
                            teacher.delete(id);
                            System.out.println("LogOut olundu:");
                            
                            break;
                        case 2:
                            System.out.println("LogOut legv olundu");
                            
                            break;
                        default:
                            System.out.println("Duzgun secim edin!!!");
                    }
                    
                    break;
                case 5:
                    System.exit(0);
                
                default:
                    System.out.println("Duzgun secim edin!!!");
            }
            
        }
    }
    
    public static void login() {
        System.out.println("Please ,Sign in:");
        int tc_id = MenuUtil.ededAl("Teacher ID-ni daxil edin!");
        String pasword = MenuUtil.textAl("Teacher pasword daxil edin!");
        Teacher tc = new Teacher(tc_id, pasword);
        
        if (tc != null) {
            logeddin = true;
        }
        
    }
    
    public static void register() {
        
        String tc_name = MenuUtil.textAl("Muellim adini daxil edin");
        String tc_surname = MenuUtil.textAl("Muellim soyadini daxil edin");
        int tc_age = MenuUtil.ededAl("Muellim yasini daxil edin");
        String tc_pasword = MenuUtil.textAl("Muellimin parolunu  daxil edin");
        int scholl_id = MenuUtil.ededAl("Mekteb ID-ni daxil edin");
        Teacher tc = new Teacher(tc_name, tc_surname,
                tc_age, tc_pasword, new School(scholl_id));
        
        teacher.insert(tc);
        System.out.println("-------------");
        int id = teacher.getTeachertByPasword(tc.getPasword());
        System.out.println("Siz qeydiyyatdan kecdiniz, Sizin ID: " + id);
        
    }
    
}
