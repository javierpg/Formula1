package com.fic.pfc.jpg.dao;

import java.util.List;
import java.util.Map;

import com.fic.pfc.jpg.model.Circuito;

public interface CircuitoDAO {

    public void save(Circuito circuito);

    public List<Circuito> findAll();

    public Circuito find(Integer id);

    public void delete(Circuito circuito);

    public List<Circuito> find(Map<String, Object> params);
}
