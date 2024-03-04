/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.entity;

/**
 *
 * @author Behruz Tapdiqov
 */
public class Student extends Person {

    private int Student_id;
    private String pasword;
    private School scholl;
    private Teacher teacher;

    public Student() {
    }

    public Student(int Student_id, String pasword) {
        this.Student_id = Student_id;
        this.pasword = pasword;
    }

   

    public Student(int Student_id) {
        this.Student_id = Student_id;
    }

    public Student(int Student_id, String name, String surname, int age, String pasword, School scholl, Teacher teacher) {
        super(name, surname, age);
        this.Student_id = Student_id;
        this.pasword = pasword;
        this.scholl = scholl;
        this.teacher = teacher;
    }

    public Student(String name, String surname, int age, String pasword, School scholl, Teacher teacher) {
        super(name, surname, age);
        this.pasword = pasword;
        this.scholl = scholl;
        this.teacher = teacher;
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int Student_id) {
        this.Student_id = Student_id;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return super.toString() + "\nStudent_id=" + Student_id + "\npasword=" + pasword + "\nscholl=" + scholl + "\nteacher=" + teacher + "\n";
    }

}
