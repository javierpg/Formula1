package com.fic.pfc.jpg.dao;

import java.util.List;
import java.util.Map;

import com.fic.pfc.jpg.model.Pais;

public interface PaisDAO {

    public void save(Pais pais);

    public List<Pais> findAll();

    public Pais find(Integer id);

    public void delete(Pais pais);

    public List<Pais> find(Map<String, Object> params);
}
