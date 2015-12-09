package com.fic.pfc.jpg.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fic.pfc.jpg.dao.EscuderiaDAO;
import com.fic.pfc.jpg.model.Escuderia;
import com.fic.pfc.jpg.service.EscuderiaService;

@Service
public class EscuderiaServiceImpl implements EscuderiaService {

    @Resource(name = "EscuderiaDAO")
    private EscuderiaDAO dao;

    @Transactional
    public void save(final Escuderia escuderia) {
        this.dao.save(escuderia);
    }

    @Transactional
    public List<Escuderia> findAll() {
        final List<Escuderia> result = new ArrayList<Escuderia>();
        result.addAll(this.dao.findAll());
        return result;
    }

    @Transactional
    public void delete(final Integer id) {
        final Escuderia escuderia = this.dao.find(id);
        if (escuderia != null) {
            this.dao.delete(escuderia);
        }
    }

}
