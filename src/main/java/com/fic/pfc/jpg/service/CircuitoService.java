package com.fic.pfc.jpg.service;

import java.util.List;

import com.fic.pfc.jpg.model.Circuito;

public interface CircuitoService {

    public void save(Circuito circuito);

    public List<Circuito> findAll();

    public void delete(Integer id);

}
