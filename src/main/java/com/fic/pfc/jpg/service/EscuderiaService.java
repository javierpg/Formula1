package com.fic.pfc.jpg.service;

import java.util.List;

import com.fic.pfc.jpg.model.Escuderia;

public interface EscuderiaService {

    public void save(Escuderia escuderia);

    public List<Escuderia> findAll();

    public void delete(Integer id);

}
