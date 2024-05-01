package org.example.modole3_minitest4.service;

import org.example.modole3_minitest4.model.Present;

import java.util.List;

public interface IPresentService {
    List<Present> findAll();
    void save(Present present);
    Present findById(int id);
    void  update(int id, Present present);
    void remove(int id);
}
