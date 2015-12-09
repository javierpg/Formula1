package com.fic.pfc.jpg.service;

import java.util.List;

import com.fic.pfc.jpg.model.Piloto;

public interface PilotoService {

    public void save(Piloto usuario);

    public List<Piloto> findAll();

    public void delete(Integer id);

}
