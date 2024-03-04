/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.entity;

/**
 *
 * @author Behruz Tapdiqov
 */
public class School {

    private int Scholl_id;
    private String scholl_name;

    public School() {
    }

    public School(int Scholl_id) {
        this.Scholl_id = Scholl_id;
    }

    public School(int Scholl_id, String scholl_name) {
        this.Scholl_id = Scholl_id;
        this.scholl_name = scholl_name;
    }

    public School(String scholl_name) {
        this.scholl_name = scholl_name;
    }

    public int getScholl_id() {
        return Scholl_id;
    }

    public void setScholl_id(int Scholl_id) {
        this.Scholl_id = Scholl_id;
    }

    public String getScholl_name() {
        return scholl_name;
    }

    public void setScholl_name(String scholl_name) {
        this.scholl_name = scholl_name;
    }

    @Override
    public String toString() {
        return "\nScholl_id=" + Scholl_id + "\nscholl_name=" + scholl_name;
    }

}
