/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.GradeDAO;
import dao.impl.GradeDAOImpl;
import entity.Grade;
import java.util.ArrayList;
import service.GradeService;

/**
 *
 * @author admin
 */
public class GradeServiceImpl implements GradeService{
    GradeDAO gradeDAO = new GradeDAOImpl();

    @Override
    public ArrayList<Grade> getGradesByEids(int[] examIds) throws Exception {
        return gradeDAO.getGradesByEids(examIds);
    }

    @Override
    public void saveGradesByCourse(int courseId, ArrayList<Grade> grades) throws Exception {
        gradeDAO.saveGradesByCourse(courseId, grades);
    }

}
