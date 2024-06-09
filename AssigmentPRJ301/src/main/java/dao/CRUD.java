/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author admin
 */
public interface CRUD<E> {
    List<E> getAll() throws Exception;
    E getOne(int id) throws Exception;
    boolean save(E obj) throws Exception;
    boolean update(E obj) throws Exception;
    boolean delete(int id) throws Exception;
}
