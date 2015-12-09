package com.fic.pfc.jpg.dao;

import java.util.List;

import com.fic.pfc.jpg.model.Escuderia;

public interface EscuderiaDAO {

    public void save(Escuderia escuderia);

    public List<Escuderia> findAll();

    public Escuderia find(Integer id);

    public void delete(Escuderia escuderia);
}
