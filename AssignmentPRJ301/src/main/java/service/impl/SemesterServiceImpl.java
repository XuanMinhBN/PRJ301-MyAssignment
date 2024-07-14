/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.SemesterDAO;
import dao.impl.SemesterDAOImpl;
import entity.Semester;
import java.util.ArrayList;
import service.SemesterService;

/**
 *
 * @author admin
 */
public class SemesterServiceImpl implements SemesterService{
    SemesterDAO semesterDAO = new SemesterDAOImpl();

    @Override
    public ArrayList<Semester> getAll() throws Exception {
        return semesterDAO.getAll();
    }

    @Override
    public void addNewSemester(Semester semester) throws Exception {
        semesterDAO.addNewSemester(semester);
    }

    @Override
    public Semester getSemesterById(int id) throws Exception {
        return semesterDAO.getSemesterById(id);
    }

    @Override
    public void updateSemester() throws Exception {
        semesterDAO.updateSemester();
    }
    
}
