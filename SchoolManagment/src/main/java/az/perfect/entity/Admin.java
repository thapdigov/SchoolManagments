/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.entity;

/**
 *
 * @author Behruz Tapdiqov
 */
public class Admin {

    private int Admin_id;
    private String name;
    private String pasword;

    public Admin() {
    }

    public Admin(String name, String pasword) {
        this.name = name;
        this.pasword = pasword;
    }

    public Admin(int Admin_id, String name, String pasword) {
        this.Admin_id = Admin_id;
        this.name = name;
        this.pasword = pasword;
    }

    public int getAdmin_id() {
        return Admin_id;
    }

    public void setAdmin_id(int Admin_id) {
        this.Admin_id = Admin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    @Override
    public String toString() {
        return "Admin_id=" + Admin_id + ", name=" + name + ", pasword=" + pasword;
    }

}
