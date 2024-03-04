/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.dao.impl;

import az.perfect.config.AbstractDao;
import static az.perfect.config.AbstractDao.connect;
import az.perfect.dao.inter.StudentInterFace;
import az.perfect.entity.School;
import az.perfect.entity.Student;
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
public class StudentDaoInter extends AbstractDao implements StudentInterFace {

    @Override
    public void update(Student s) {
        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("update student set st_name=?,st_surname=?,st_age=?,"
                    + "st_pasword=?,scholl_id=?,teacher_id=? where st_id=?"
            );
            st.setString(1, s.getName());
            st.setString(2, s.getSurname());
            st.setInt(3, s.getAge());
            st.setString(4, s.getPasword());
            st.setInt(5, s.getScholl().getScholl_id());
            st.setInt(6, s.getTeacher().getTeacher_id());
            st.setInt(7, s.getStudent_id());
            st.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public void insert(Student s) {
        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("insert into Student (st_name,st_surname,st_age,"
                    + "st_pasword,scholl_id,teacher_id) values(?,?,?,?,?,?)"
            );
            st.setString(1, s.getName());
            st.setString(2, s.getSurname());
            st.setInt(3, s.getAge());
            st.setString(4, s.getPasword());
            st.setInt(5, s.getScholl().getScholl_id());
            st.setInt(6, s.getTeacher().getTeacher_id());

            st.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    @Override
    public void delete(int id) {
        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("delete from Student where st_id=?");
            st.setInt(1, id);
            st.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    @Override
    public Student getStudnetbyId(int id) {
        Student s = null;

        try (Connection conn = connect();) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select*from allinfo_new where st_id=" + id);
            while (rs.next()) {
                s = getStudent(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return s;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> list = new LinkedList<>();

        try (Connection conn = connect();) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select*from allinfo_new");
            while (rs.next()) {
                list.add(getStudent(rs));
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return list;
    }

    @Override
    public Student getStudentByIdByPasword(int id, String pasword) {
        Student s = null;

        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("select* from allinfo_new where st_id=? and st_pasword=?");
            st.setInt(1, id);
            st.setString(2, pasword);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                s = getStudent(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return s;

    }

    public static Student getStudent(ResultSet rs) throws SQLException {
        int st_id = rs.getInt("st_id");
        String st_name = rs.getString("st_name");
        String st_surname = rs.getString("st_surname");
        int st_age = rs.getInt("st_age");
        String st_pasword = rs.getString("st_pasword");
        int school_id = rs.getInt("school_id");
        String school_name = rs.getString("school_name");
        int tc_id = rs.getInt("tc_id");
        String tc_name = rs.getString("teacher_name");
        String tc_surname = rs.getString("teacher_surname");
        int tc_age = rs.getInt("teacher_age");

        return new Student(st_id, st_name, st_surname,
                st_age, st_pasword, new School(school_id, school_name), new Teacher(tc_id, tc_name, tc_surname, tc_age));
    }

    @Override
    public int getStudentByPasword(String pasword) {

        Integer i = null;

        try (Connection conn = connect();) {
            PreparedStatement st = conn.prepareStatement("select st_id from allinfo_new where st_pasword=?");
            st.setString(1, pasword);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                i = rs.getInt("st_id");

            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return i;
    }

  

}
