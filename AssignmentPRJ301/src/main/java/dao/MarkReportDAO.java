/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.MarkReport;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface MarkReportDAO {
    ArrayList<MarkReport> getReportList(int id) throws Exception; 
    
    void insertStudentReport(int stuId, int subId) throws Exception;
    
    void updateMarkStatus() throws Exception;
}
