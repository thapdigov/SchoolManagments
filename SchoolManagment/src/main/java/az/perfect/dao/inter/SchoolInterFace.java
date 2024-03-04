/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package az.perfect.dao.inter;

import az.perfect.entity.School;
import java.util.List;

/**
 *
 * @author Behruz Tapdiqov
 */
public interface SchoolInterFace {
    void update(School s);

    void insert(School s);

    void delete(int id);

    School getSchollbyId(int id);

    List<School> getallScholls();
    
}
