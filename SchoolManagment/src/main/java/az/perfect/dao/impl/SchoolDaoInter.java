/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.dao.impl;

import az.perfect.config.AbstractDao;
import static az.perfect.config.AbstractDao.connect;
import az.perfect.dao.inter.SchoolInterFace;
import az.perfect.entity.School;
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
public class SchoolDaoInter extends AbstractDao implements SchoolInterFace {

    @Override
    public void update(School s) {
        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("update school set school_name=? where school_id=?");
            st.setString(1, s.getScholl_name());
            st.setInt(2, s.getScholl_id());
            st.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());

        }
    }

    @Override
    public void insert(School s) {
        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("insert into school (school_name) values(?)");
            st.setString(1, s.getScholl_name());
            st.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());

        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("delete from  school where school_id=?");
            st.setInt(1, id);
            st.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());

        }
    }

    @Override
    public School getSchollbyId(int id) {
        School s = null;
        try (Connection conn = connect();) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select *from school where school_id=" + id);
            while (rs.next()) {
                s = getSchool(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());

        }
        return s;

    }

    @Override
    public List<School> getallScholls() {
        List<School> list = new LinkedList<>();
        try (Connection conn = connect();) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select *from school");
            while (rs.next()) {
                list.add(getSchool(rs));
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());

        }
        return list;
    }

    public static School getSchool(ResultSet rs) throws SQLException {
        int scholl_id = rs.getInt("school_id");
        String scholl_name = rs.getString("school_name");
        return new School(scholl_id, scholl_name);

    }

}
