/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Behruz Tapdiqov
 */
public abstract class AbstractDao {

    public static Connection connect() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolManagment", "Behruz", "7586");

    }

}
