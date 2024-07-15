/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.MarkReportDAO;
import dao.impl.MarkReportDAOImpl;
import entity.MarkReport;
import java.util.ArrayList;
import service.MarkReportService;

/**
 *
 * @author admin
 */
public class MarkReportServiceImpl implements MarkReportService{
    MarkReportDAO markReportDAO = new MarkReportDAOImpl();
    
    @Override
    public ArrayList<MarkReport> getReportList(int id) throws Exception {
        return markReportDAO.getReportList(id);
    }

    @Override
    public void insertStudentReport(int stuId, int subId) throws Exception {
        markReportDAO.insertStudentReport(stuId,subId);
    }

    @Override
    public void updateMarkStatus() throws Exception {
        markReportDAO.updateMarkStatus();
    }
    
}
