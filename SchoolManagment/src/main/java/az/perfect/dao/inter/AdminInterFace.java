/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package az.perfect.dao.inter;

import az.perfect.entity.Admin;
import java.util.List;

/**
 *
 * @author Behruz Tapdiqov
 */
public interface AdminInterFace {

    void update(Admin a);

    void insert(Admin a);

    void delete(int id);

    Admin getAdminbyId(int id);

    Admin getAdmin(String name, String pasword);

    List<Admin> getallAdmins();

    Admin getAdmintByIdByPasword(int id, String pasword);

}
