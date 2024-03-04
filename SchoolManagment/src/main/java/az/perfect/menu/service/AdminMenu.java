/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.menu.service;

import az.perfect.config.Context;
import az.perfect.dao.impl.AdminDaoInter;
import az.perfect.dao.impl.SchoolDaoInter;
import az.perfect.dao.inter.AdminInterFace;
import az.perfect.dao.inter.SchoolInterFace;
import az.perfect.dao.inter.StudentInterFace;
import az.perfect.dao.inter.TeacherInterFace;
import az.perfect.entity.Admin;
import az.perfect.entity.School;
import az.perfect.entity.Student;
import az.perfect.entity.Teacher;
import az.perfect.menu.MenuUtil;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Behruz Tapdiqov
 */
public class AdminMenu implements MenuService {

    AdminInterFace admin = Context.inctanceAdmin();
    SchoolInterFace school = Context.inctanceSchool();
    StudentInterFace student = Context.inctanceStudent();
    TeacherInterFace teacher = Context.inctanceTeacher();

    @Override
    public void prosess() {
        Scanner sc = new Scanner(System.in);
        String name = MenuUtil.textAl("Admin menyusuna daxil oldunuz" + "\nAdmin adinizi daxil edin");
        String pasword = MenuUtil.textAl("Admin parolunuzu daxil edin");
        Admin ab = new Admin(name, pasword);
        ab = admin.getAdminbyId(1);
        int user = 0;
        if (name.equals(ab.getName()) && pasword.equals(ab.getPasword())) {

            user = MenuUtil.ededAl("Please ,Select Menu"
                    + """
                      
                         1.ShowSchool
                         2.AddSchool
                         3.EditSchool
                         4.DeleteSchool
                         5.ShowTeacher
                         6.AddTeacher
                         7.EditTeacher
                         8.DeleteTeacher
                         9.ShowStudent
                        10.AddStudent
                        11.EditStudent
                        12.DeleteStudent
                        13.Exit  
                        """);
        } else {
            System.out.println("Name or pasword is incorrect!!!");
            prosess();
        }

        switch (user) {

            case 1:
                System.out.println(school.getallScholls());
                break;
            case 2:
                int school_id = MenuUtil.ededAl("School_Id");
                String sc_name = MenuUtil.textAl("School_name");
                School s = new School(school_id, sc_name);
                school.insert(s);
                System.out.println("Daxil etdiyiniz melumatlar esasinda mekteb elave olundu");
                break;

            case 3:
                System.out.println("Nece nomreli mektebin melumatlarini deyismek isteyirsiniz?");
                int number = sc.nextInt();
                School a = school.getSchollbyId(number);
                System.out.println("Deyismek istediyinizi qeyd edin:"
                        + """
                          
                        1.School_name
                                       """);
                int data = sc.nextInt();
                switch (data) {

                    case 1:
                        a.setScholl_name(MenuUtil.textAl("Yeni mekteb adini daxil edin"));
                        break;
                    default:
                        System.out.println("Zehmet olmazsa duzgun secim edin!");
                }
                school.update(a);
                System.out.println("Mekteb melumatlari deyisildi");

                break;
            case 4:
                System.out.println("Nece nomreli mektebi silmek isteyirsiniz?");
                int n = sc.nextInt();
                School b = school.getSchollbyId(n);
                LinkedList<School> schools = new LinkedList<>();
                String cavab = MenuUtil.textAl("Silmek istediyinize eminsiniz?"
                        + """
                          
                        1.beli
                        2.xeyr
                        """);
                if (cavab.equalsIgnoreCase("beli")) {
                    schools.remove(b);
                    school.delete(n);
                    System.out.println("Mekteb silindi");
                } else if (cavab.equalsIgnoreCase("xeyr")) {

                    System.out.println("Silinme legv olundu!");
                }

                break;
            case 5:
                System.out.println(teacher.getallTeachers());

                break;
            case 6:
                int teacher_id = MenuUtil.ededAl("Id-ni daxil edin");
                String tc_name = MenuUtil.textAl("Muellim adini daxil edin");
                String tc_surname = MenuUtil.textAl("Muellim soyadini daxil edin");
                int tc_age = MenuUtil.ededAl("Muellim yasini daxil edin");
                String tc_pasword = MenuUtil.textAl("Muellimin parolunu  daxil edin");
                int scholl_id = MenuUtil.ededAl("Mekteb ID-ni daxil edin");
                Teacher t = new Teacher(tc_name, tc_surname, tc_age, new School(scholl_id), teacher_id, tc_pasword);
                teacher.insert(t);
                break;
            case 7:
                System.out.println("Nece nomreli muellimin melumatlarini deyismek isteyirsiniz?");
                int num = sc.nextInt();
                Teacher ts = teacher.getTeacherbyId(num);
                System.out.println("Hansi melumati deyismek isteyirsiniz?"
                        + """ 
                                                 
                            1.name
                            2.surname                          
                            3.age  
                            4.pasword
                            5.school_id     """);

                int d = sc.nextInt();

                switch (d) {
                    case 1:
                        ts.setName(MenuUtil.textAl("Yeni adi daxil edin"));
                        break;
                    case 2:
                        ts.setSurname(MenuUtil.textAl("Yeni soyadi daxil edin"));
                        break;
                    case 3:
                        ts.setAge(MenuUtil.ededAl("Yeni yasi daxil edin"));
                        break;
                    case 4:
                        ts.setPasword(MenuUtil.textAl("Yeni parolu daxil edin"));
                        break;
                    case 5:
                        ts.setScholl(new School(MenuUtil.ededAl("Yeni ID-ni daxil edin")));
                        break;
                    default:
                        System.out.println("Duzgun secim edin!!!");
                }
                teacher.update(ts);

                break;
            case 8:
                System.out.println("Nece nomreli muellimin melumatlarini silmek isteyirsiniz?");
                int m = sc.nextInt();
                Teacher h = teacher.getTeacherbyId(m);
                LinkedList<Teacher> teachers = new LinkedList<>();
                String c = MenuUtil.textAl("Silmek istediyinize eminsiniz?"
                        + """
                          
                        1.beli
                        2.xeyr
                        """);
                if (c.equalsIgnoreCase("beli")) {
                    teachers.remove(h);
                    teacher.delete(m);
                    System.out.println("Muellim melumatlari silindi");
                } else if (c.equalsIgnoreCase("xeyr")) {
                    System.out.println("Silinme legv olundu!");
                }

                break;
            case 9:
                System.out.println(student.getAllStudents());

                break;
            case 10:
                int st_id = MenuUtil.ededAl("Id-ni daxil edin");
                String st_name = MenuUtil.textAl("Telebenin adini daxil edin");
                String st_surname = MenuUtil.textAl("Telebenin soyadini daxil edin");
                int st_age = MenuUtil.ededAl("Telebenin yasini daxil edin");
                String st_pasword = MenuUtil.textAl("Telebenin parolunu  daxil edin");
                int schoosl_id = MenuUtil.ededAl("Mekteb ID-ni daxil edin");
                int tc_id = MenuUtil.ededAl("Muellim ID-ni daxil edin");
                Student v = new Student(st_id, st_name, st_surname,
                        st_age, st_pasword, new School(schoosl_id), new Teacher(tc_id));
                student.insert(v);
                break;

            case 11:
                System.out.println("Nece nomreli telebenin melumatlarini deyismek isteyirsiniz?");
                int e = sc.nextInt();
                Student f = student.getStudnetbyId(e);
                System.out.println("Hansi melumati deyismek isteyirsiniz?"
                        + """
                           
                               1.name
                               2.surname                                                               
                               3.age  
                               4.pasword
                               5.school_ID
                               6.teacher_ID    """);
                int j = sc.nextInt();
                switch (j) {
                    case 1:
                        f.setName(MenuUtil.textAl("Yeni adi daxil edin"));
                        break;
                    case 2:
                        f.setSurname(MenuUtil.textAl("Yeni soyadi daxil edin"));
                        break;
                    case 3:
                        f.setAge(MenuUtil.ededAl("Yeni yasi daxil edin "));
                        break;
                    case 4:
                        f.setPasword(MenuUtil.textAl("Yeni parolu daxil edin"));
                        break;
                    case 5:
                        f.setScholl(new School(MenuUtil.ededAl("Yeni School_ID daxil edin")));
                        break;
                    case 6:
                        f.setTeacher(new Teacher(MenuUtil.ededAl("Yeni Teacher_ID daxil edin")));
                        break;
                    default:
                        throw new AssertionError();
                }
                student.update(f);

                break;
            case 12:
                System.out.println("Nece nomreli telebenin melumatlarini silmek isteyirsiniz?");
                int p = sc.nextInt();
                Student r = student.getStudnetbyId(p);
                LinkedList<Student> students = new LinkedList<>();
                String cs = MenuUtil.textAl("Silmek istediyinize eminsiniz?"
                        + """
                          
                        1.beli
                        2.xeyr
                        """);
                if (cs.equalsIgnoreCase("beli")) {
                    students.remove(r);
                    student.delete(p);
                    System.out.println("Telebe melumatlari silindi");
                } else if (cs.equalsIgnoreCase("xeyr")) {
                    System.out.println("Silinme legv olundu!");
                }

                break;
            case 13:
                System.exit(0);

                break;

            default:
                System.out.println("Please,Choose The Correct Menu");
        }

    }

}
