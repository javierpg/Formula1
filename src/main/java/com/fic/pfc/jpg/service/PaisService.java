package com.fic.pfc.jpg.service;

import java.util.List;

import com.fic.pfc.jpg.model.Pais;

public interface PaisService {

    public void save(Pais pais);

    public List<Pais> findAll();

    public void delete(Integer id);

}
