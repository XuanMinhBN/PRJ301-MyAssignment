/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class Course {
    private Long id;
    private String courseCode;
    private String courseName;
    private List<Map<String, Double>> studentList;
    private Double averageMark;
    private boolean status;
}
