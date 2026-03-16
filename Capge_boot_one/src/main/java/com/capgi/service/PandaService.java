package com.capgi.service;

import com.capgi.entity.Panda;

import java.util.List;

public interface PandaService {

    void save(Panda panda);
//    void update(Panda panda);

    void updatePanda(Integer id, Panda panda);

    List<Panda> findAll();

    void deleteById(Integer id);

    Panda findById(Integer id);
}
