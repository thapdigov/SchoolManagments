/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.dao.impl;

import az.perfect.config.AbstractDao;
import static az.perfect.config.AbstractDao.connect;
import az.perfect.dao.inter.AdminInterFace;
import az.perfect.entity.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Behruz Tapdiqov
 */
public class AdminDaoInter extends AbstractDao implements AdminInterFace {

    @Override
    public void update(Admin a) {
        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("update Admins set admin_pasword=?,admin_name=? where admin_id=? ");
            st.setString(1, a.getPasword());
            st.setString(2, a.getName());
            st.setInt(3, a.getAdmin_id());
            st.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());

        }

    }

    @Override
    public void insert(Admin a) {

        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("insert into Admins  (admin_pasword,admin_name,admin_id) values(?,?,?) ");
            st.setString(1, a.getPasword());
            st.setString(2, a.getName());
            st.setInt(3, a.getAdmin_id());
            st.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());

        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("delete from Admins  where admin_id=? ");
            st.setInt(1, id);
            st.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public Admin getAdminbyId(int id) {
        Admin a = null;
        try (Connection conn = connect();) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select*from Admins where admin_id=" + id);
            while (rs.next()) {

                a = getAdmin(rs);

            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return a;

    }

    @Override
    public List<Admin> getallAdmins() {
        List<Admin> list = new LinkedList<>();
        try (Connection conn = connect();) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select*from Admins ");
            while (rs.next()) {

                list.add(getAdmin(rs));

            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return list;
    }

    @Override
    public Admin getAdmintByIdByPasword(int id, String pasword) {
        Admin a = null;
        try (Connection conn = connect();) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select*from Admins where admin_id=" + id + " and admin_pasword=" + pasword);
            while (rs.next()) {

                a = getAdmin(rs);

            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return a;
    }

    public static Admin getAdmin(ResultSet rs) throws SQLException {
        int admin_id = rs.getInt("admin_id");
        String name = rs.getString("admin_name");
        String pasword = rs.getString("admin_pasword");
        return new Admin(admin_id, name, pasword);

    }

    @Override
    public Admin getAdmin(String name, String pasword) {
        Admin a = null;
        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("select * from Admins where admin_name=? and admin_pasword=?");
            st.setString(1, name);
            st.setString(2, pasword);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String admin_name = rs.getString("admin_name");
                String admin_pasword = rs.getString("admin_pasword");
                a = new Admin(admin_name, admin_pasword);

            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return a;

    }

}
