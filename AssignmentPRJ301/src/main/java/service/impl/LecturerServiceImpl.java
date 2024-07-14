/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.LecturerDAO;
import dao.impl.LecturerDAOImpl;
import entity.Lecturer;
import java.util.ArrayList;
import service.LecturerService;

/**
 *
 * @author admin
 */
public class LecturerServiceImpl implements LecturerService{
    LecturerDAO lecturerDAO = new LecturerDAOImpl();
    
    @Override
    public ArrayList<Lecturer> getAll() throws Exception {
        return lecturerDAO.getAll();
    }

    @Override
    public Lecturer getLecturerById(int id) throws Exception {
        return lecturerDAO.getLecturerById(id);
    }
    
}
