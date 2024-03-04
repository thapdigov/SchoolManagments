/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.entity;

/**
 *
 * @author Behruz Tapdiqov
 */
public class Teacher extends Person {

    private int Teacher_id;
    private String pasword;
    private School scholl;

    public Teacher() {
    }

    public Teacher(int Teacher_id, String pasword) {
        this.Teacher_id = Teacher_id;
        this.pasword = pasword;
    }

    public Teacher(String name, String surname, int age, String pasword, School scholl) {
        super(name, surname, age);
        this.pasword = pasword;
        this.scholl = scholl;
    }

    public Teacher(int Teacher_id) {
        this.Teacher_id = Teacher_id;
    }

    public Teacher(int Teacher_id, String name, String surname, int age) {
        super(name, surname, age);
        this.Teacher_id = Teacher_id;
    }

    public Teacher(String name, String surname, int age, School scholl, int Teacher_id, String pasword) {
        super(name, surname, age);
        this.Teacher_id = Teacher_id;
        this.pasword = pasword;
        this.scholl = scholl;
    }

    public int getTeacher_id() {
        return Teacher_id;
    }

    public void setTeacher_id(int Teacher_id) {
        this.Teacher_id = Teacher_id;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public School getScholl() {
        return scholl;
    }

    public void setScholl(School scholl) {
        this.scholl = scholl;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTeacher_id=" + Teacher_id + "\npasword=" + pasword + "\nscholl=" + scholl;
    }

}
