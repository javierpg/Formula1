package com.fic.pfc.jpg.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fic.pfc.jpg.dao.CircuitoDAO;
import com.fic.pfc.jpg.model.Circuito;
import com.fic.pfc.jpg.service.CircuitoService;
import com.fic.pfc.jpg.ui.CircuitoUI;
import com.fic.pfc.jpg.utils.AdapterEntity;
import com.fic.pfc.jpg.utils.AdapterUI;

@Service
public class CircuitoServiceImpl implements CircuitoService {

    @Resource(name = "CircuitoDAO")
    private CircuitoDAO dao;

    @Transactional
    public void save(final CircuitoUI circuito) {
        this.dao.save(AdapterEntity.adapt(circuito));
    }

    @Transactional
    public List<CircuitoUI> findAll() {
        final List<CircuitoUI> result = new ArrayList<CircuitoUI>();
        result.addAll(AdapterUI.adaptListCircuito(this.dao.findAll()));
        return result;
    }

    @Transactional
    public void delete(final Integer id) {
        final Circuito circuito = this.dao.find(id);
        if (circuito != null) {
            this.dao.delete(circuito);
        }
    }

    @Transactional
    public CircuitoUI find(final Integer id) {
        final Circuito circuito = this.dao.find(id);
        return AdapterUI.adapt(circuito);
    }

}
