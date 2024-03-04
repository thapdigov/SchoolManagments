/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.config;

import az.perfect.dao.impl.AdminDaoInter;
import az.perfect.dao.impl.SchoolDaoInter;
import az.perfect.dao.impl.StudentDaoInter;
import az.perfect.dao.impl.TeacherDaoInter;
import az.perfect.dao.inter.AdminInterFace;
import az.perfect.dao.inter.SchoolInterFace;
import az.perfect.dao.inter.StudentInterFace;
import az.perfect.dao.inter.TeacherInterFace;

/**
 *
 * @author Behruz Tapdiqov
 */
public class Context {

    public static StudentInterFace inctanceStudent() {
        return new StudentDaoInter();
    }

    public static TeacherInterFace inctanceTeacher() {
        return new TeacherDaoInter();
    }

    public static AdminInterFace inctanceAdmin() {
        return new AdminDaoInter();
    }

    public static SchoolInterFace inctanceSchool() {
        return new SchoolDaoInter();
    }

}
