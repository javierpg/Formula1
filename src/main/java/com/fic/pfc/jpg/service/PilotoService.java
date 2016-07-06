package com.fic.pfc.jpg.service;

import java.util.List;

import com.fic.pfc.jpg.ui.PilotoUI;

public interface PilotoService {

    public void save(PilotoUI piloto);

    public List<PilotoUI> findAll();

    public PilotoUI find(Integer id);

    public void delete(Integer id);

    public List<PilotoUI> find(final PilotoUI pilotoUI);

}
