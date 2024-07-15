/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.SubjectDAO;
import dao.impl.SubjectDAOImpl;
import entity.Subject;
import java.util.ArrayList;
import service.SubjectService;

/**
 *
 * @author admin
 */
public class SubjectServiceImpl implements SubjectService{
    SubjectDAO subjectDAO = new SubjectDAOImpl();

    @Override
    public ArrayList<Subject> getAllSubject() throws Exception {
        return subjectDAO.getAllSubject();
    }   

    @Override
    public Subject getSubjectById(int id) throws Exception {
        return subjectDAO.getSubjectById(id);
    }

    @Override
    public Subject getSubjectByCourseId(int id) throws Exception {
        return subjectDAO.getSubjectByCourseId(id);
    }
}
