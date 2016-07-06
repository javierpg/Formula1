package com.fic.pfc.jpg.dao;

import java.util.List;
import java.util.Map;

import com.fic.pfc.jpg.model.Piloto;

public interface PilotoDAO {

    public void save(Piloto piloto);

    public List<Piloto> findAll();

    public Piloto find(Integer id);

    public void delete(Piloto piloto);

    // public List<Piloto> find(Piloto piloto);
    public List<Piloto> find(final Map<String, Object> params);
}
