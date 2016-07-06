package com.fic.pfc.jpg.service;

import java.util.List;

import com.fic.pfc.jpg.ui.EscuderiaUI;

public interface EscuderiaService {

    public void save(EscuderiaUI escuderia);

    public List<EscuderiaUI> findAll();

    public EscuderiaUI find(Integer id);

    public void delete(Integer id);

    public List<EscuderiaUI> find(EscuderiaUI escuderia);

}
