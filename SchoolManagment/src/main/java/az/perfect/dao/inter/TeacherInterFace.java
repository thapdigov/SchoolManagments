/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package az.perfect.dao.inter;

import az.perfect.entity.Teacher;
import java.util.List;

/**
 *
 * @author Behruz Tapdiqov
 */
public interface TeacherInterFace {

    void update(Teacher t);

    void insert(Teacher t);

    void delete(int id);

    Teacher getTeacherbyId(int id);

    List<Teacher> getallTeachers();

    Teacher getTeachertByIdByPasword(int id, String pasword);

    int getTeachertByPasword(String pasword);

}
