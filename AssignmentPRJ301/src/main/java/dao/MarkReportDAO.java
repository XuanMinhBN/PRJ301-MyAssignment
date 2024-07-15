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
    ArrayList<MarkReport> getReportList() throws Exception; 
}
