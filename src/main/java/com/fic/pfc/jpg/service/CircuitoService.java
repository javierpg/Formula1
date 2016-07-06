package com.fic.pfc.jpg.service;

import java.util.List;

import com.fic.pfc.jpg.ui.CircuitoUI;

public interface CircuitoService {

    public void save(CircuitoUI circuito);

    public List<CircuitoUI> findAll();

    public CircuitoUI find(Integer id);

    public void delete(Integer id);

    public List<CircuitoUI> find(CircuitoUI circuito);

}
