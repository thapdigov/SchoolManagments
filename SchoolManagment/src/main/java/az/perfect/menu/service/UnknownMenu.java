/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.menu.service;

import az.perfect.menu.MenuUtil;

/**
 *
 * @author Behruz Tapdiqov
 */
public class UnknownMenu implements MenuService {

    @Override
    public void prosess() {
        System.out.println("Please,Choose the correct Menu!!1");
        MenuUtil.startMenu();

    }

}
