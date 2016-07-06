package com.fic.pfc.jpg.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
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

    public List<CircuitoUI> find(final CircuitoUI circuitoUI) {
        final Map<String, Object> params = new HashMap<String, Object>();

        if ((circuitoUI.getId() != null) && (circuitoUI.getId() != 0)) {
            params.put("id_circuito", circuitoUI.getId());
        }

        if (StringUtils.isNotBlank(circuitoUI.getNombre())) {
            params.put("nombre", circuitoUI.getNombre());
        }

        if ((circuitoUI.getIdPais() != null) && (circuitoUI.getIdPais() != 0)) {
            params.put("id_pais", circuitoUI.getIdPais());
        }

        final List<Circuito> listaCircuito = this.dao.find(params);
        final List<CircuitoUI> resultados = new ArrayList<CircuitoUI>();
        for (final Circuito circuito : listaCircuito) {
            resultados.add(AdapterUI.adapt(circuito));
        }
        return resultados;
    }

}
