package com.fic.pfc.jpg.service;

import java.util.List;

import com.fic.pfc.jpg.ui.PaisUI;

public interface PaisService {

    public void save(PaisUI pais);

    public List<PaisUI> findAll();

    public PaisUI find(Integer id);

    public void delete(Integer id);

    public List<PaisUI> find(final PaisUI pais);

}
