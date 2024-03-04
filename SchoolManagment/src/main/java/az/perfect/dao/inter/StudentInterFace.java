/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package az.perfect.dao.inter;

import az.perfect.entity.Student;
import java.util.List;

/**
 *
 * @author Behruz Tapdiqov
 */
public interface StudentInterFace {

    void update(Student s);

    void insert(Student s);

    void delete(int id);

    Student getStudnetbyId(int id);

    List<Student> getAllStudents();



    Student getStudentByIdByPasword(int id, String pasword);

    int getStudentByPasword(String pasword);

}
