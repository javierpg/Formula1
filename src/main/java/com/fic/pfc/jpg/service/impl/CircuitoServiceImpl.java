package com.fic.pfc.jpg.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fic.pfc.jpg.dao.CircuitoDAO;
import com.fic.pfc.jpg.model.Circuito;
import com.fic.pfc.jpg.service.CircuitoService;

@Service
public class CircuitoServiceImpl implements CircuitoService {

    @Resource(name = "CircuitoDAO")
    private CircuitoDAO dao;

    @Transactional
    public void save(final Circuito circuito) {
        this.dao.save(circuito);
    }

    @Transactional
    public List<Circuito> findAll() {
        final List<Circuito> result = new ArrayList<Circuito>();
        result.addAll(this.dao.findAll());
        return result;
    }

    @Transactional
    public void delete(final Integer id) {
        final Circuito circuito = this.dao.find(id);
        if (circuito != null) {
            this.dao.delete(circuito);
        }
    }

}
