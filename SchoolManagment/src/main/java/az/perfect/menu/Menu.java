/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package az.perfect.menu;

import az.perfect.menu.service.AdminMenu;
import az.perfect.menu.service.MenuService;
import az.perfect.menu.service.StudentMenu;
import az.perfect.menu.service.TeacherMenu;
import az.perfect.menu.service.UnknownMenu;

/**
 *
 * @author Behruz Tapdiqov
 */
public enum Menu {
    ADMIN(1, "Admin", new AdminMenu()),
    STUDENT(2, "Student", new StudentMenu()),
    TEACGER(3, "Teacher", new TeacherMenu()),
    UNKNOWN(new UnknownMenu());

    private int number;
    private String text;
    private MenuService service;

    private Menu(int number, String text, MenuService service) {
        this.number = number;
        this.text = text;
        this.service = service;
    }

    private Menu(MenuService service) {
        this.service = service;
    }

    private Menu() {
    }

    public static Menu find(int selectedMenu) {

        Menu menu[] = Menu.values();
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].number == selectedMenu) {
                return menu[i];
            }

        }
        return UNKNOWN;
    }

    public void Enumprosess() {
        service.prosess();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MenuService getService() {
        return service;
    }

    public void setService(MenuService service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return number + "." + text;
    }

}
