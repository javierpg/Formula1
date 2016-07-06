package com.fic.pfc.jpg.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fic.pfc.jpg.dao.EscuderiaDAO;
import com.fic.pfc.jpg.dao.PaisDAO;
import com.fic.pfc.jpg.dao.PilotoDAO;
import com.fic.pfc.jpg.model.Piloto;
import com.fic.pfc.jpg.service.PilotoService;
import com.fic.pfc.jpg.ui.PilotoUI;
import com.fic.pfc.jpg.utils.AdapterEntity;
import com.fic.pfc.jpg.utils.AdapterUI;

@Service
public class PilotoServiceImpl implements PilotoService {

    @Resource(name = "PilotoDAO")
    private PilotoDAO dao;
    @Resource(name = "PaisDAO")
    private PaisDAO paisDao;
    @Resource(name = "EscuderiaDAO")
    private EscuderiaDAO escuderiaDao;

    @Transactional
    public void save(final PilotoUI pilotoUI) {
        final Piloto piloto = AdapterEntity.adapt(pilotoUI);
        this.dao.save(piloto);
    }

    @Transactional
    public List<PilotoUI> findAll() {
        final List<PilotoUI> result = new ArrayList<PilotoUI>();
        result.addAll(AdapterUI.adaptListPiloto(this.dao.findAll()));
        return result;
    }

    @Transactional
    public void delete(final Integer id) {
        final Piloto piloto = this.dao.find(id);
        if (piloto != null) {
            this.dao.delete(piloto);
        }
    }

    @Transactional
    public PilotoUI find(final Integer id) {
        final Piloto piloto = this.dao.find(id);
        return AdapterUI.adapt(piloto);
    }

    @Transactional
    public List<PilotoUI> find(final PilotoUI pilotoUI) {
        final Map<String, Object> params = new HashMap<String, Object>();
        if (pilotoUI.getId() != null) {
            params.put("id_piloto", pilotoUI.getId());
        }
        if (StringUtils.isNotBlank(pilotoUI.getNombre())) {
            params.put("nombre", pilotoUI.getNombre());
        }
        if ((pilotoUI.getIdEscuderia() != null) && (pilotoUI.getIdEscuderia() != 0)) {
            params.put("id_escuderia", pilotoUI.getIdEscuderia());
        }

        if ((pilotoUI.getIdPais() != null) && (pilotoUI.getIdPais() != 0)) {
            params.put("id_pais", pilotoUI.getIdPais());
        }
        final List<Piloto> listaPiloto = this.dao.find(params);
        final List<PilotoUI> resultados = new ArrayList<PilotoUI>();
        for (final Piloto piloto : listaPiloto) {
            resultados.add(AdapterUI.adapt(piloto));
        }
        return resultados;
    }
}
