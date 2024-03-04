/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.dao.impl;

import az.perfect.config.AbstractDao;
import static az.perfect.config.AbstractDao.connect;
import az.perfect.dao.inter.TeacherInterFace;
import az.perfect.entity.School;
import az.perfect.entity.Teacher;
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
public class TeacherDaoInter extends AbstractDao implements TeacherInterFace {

    @Override
    public void update(Teacher t) {

        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("update Teacher set teacher_name=?,teacher_surname=?,teacher_age=?,"
                    + "teacher_pasword=?,schooll_id=? where tc_id=?"
            );

            st.setString(1, t.getName());
            st.setString(2, t.getSurname());
            st.setInt(3, t.getAge());
            st.setString(4, t.getPasword());
            st.setInt(5, t.getScholl().getScholl_id());
            st.setInt(6, t.getTeacher_id());
            st.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public void insert(Teacher t) {
        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("insert into Teacher (teacher_name,teacher_surname,teacher_age,"
                    + "teacher_pasword,schooll_id) values(?,?,?,?,?)"
            );

            st.setString(1, t.getName());
            st.setString(2, t.getSurname());
            st.setInt(3, t.getAge());
            st.setString(4, t.getPasword());
            st.setInt(5, t.getScholl().getScholl_id());
            st.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("delete from teacher where tc_id=?");
            st.setInt(1, id);
            st.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public Teacher getTeacherbyId(int id) {
        Teacher t = null;
        try (Connection conn = connect();) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from allinfo where tc_id=" + id);
            while (rs.next()) {
                t = getTeacher(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return t;

    }

    @Override
    public List<Teacher> getallTeachers() {
        List<Teacher> list = new LinkedList<>();
        try (Connection conn = connect();) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from allinfo ");
            while (rs.next()) {
                list.add(getTeacher(rs));
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return list;
    }

    @Override
    public Teacher getTeachertByIdByPasword(int id, String pasword) {
        Teacher t = null;
        try (Connection conn = connect();) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from allinfo where tc_id=" + id + " and teacher_pasword=" + pasword);
            while (rs.next()) {
                t = getTeacher(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return t;
    }

    public static Teacher getTeacher(ResultSet rs) throws SQLException {

        int teacher_id = rs.getInt("tc_id");
        String t_name = rs.getString("teacher_name");
        String tc_surname = rs.getString("teacher_surname");
        int tc_age = rs.getInt("teacher_age");
        String tc_pasword = rs.getString("teacher_pasword");
        int scholl_id = rs.getInt("schooll_id");
        String scholl_name = rs.getString("school_name");
        return new Teacher(t_name, tc_surname, tc_age, new School(scholl_id, scholl_name), teacher_id, tc_pasword);

    }

    @Override
    public int getTeachertByPasword(String pasword) {

        Integer t = null;

        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("select tc_id from allinfo where teacher_pasword=?");
            st.setString(1, pasword);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                
                t = rs.getInt("tc_id");

            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return t;
    }

}
