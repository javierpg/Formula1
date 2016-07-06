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
import com.fic.pfc.jpg.model.Escuderia;
import com.fic.pfc.jpg.model.Pais;
import com.fic.pfc.jpg.service.EscuderiaService;
import com.fic.pfc.jpg.ui.EscuderiaUI;
import com.fic.pfc.jpg.utils.AdapterEntity;
import com.fic.pfc.jpg.utils.AdapterUI;

@Service
public class EscuderiaServiceImpl implements EscuderiaService {

    @Resource(name = "EscuderiaDAO")
    private EscuderiaDAO dao;
    @Resource(name = "PaisDAO")
    private PaisDAO paisDao;

    @Transactional
    public void save(final EscuderiaUI escuderiaUI) {
        final Pais pais = this.paisDao.find(escuderiaUI.getIdPais());
        final Escuderia escuderia = AdapterEntity.adapt(escuderiaUI);
        escuderia.setPais(pais);
        this.dao.save(escuderia);
    }

    @Transactional
    public List<EscuderiaUI> findAll() {
        final List<EscuderiaUI> result = new ArrayList<EscuderiaUI>();
        result.addAll(AdapterUI.adaptListEscuderia(this.dao.findAll()));
        return result;
    }

    @Transactional
    public void delete(final Integer id) {
        final Escuderia escuderia = this.dao.find(id);
        if (escuderia != null) {
            this.dao.delete(escuderia);
        }
    }

    @Transactional
    public EscuderiaUI find(final Integer id) {
        final Escuderia escuderia = this.dao.find(id);
        return AdapterUI.adapt(escuderia);
    }

    public List<EscuderiaUI> find(final EscuderiaUI escuderiaUI) {
        final Map<String, Object> params = new HashMap<String, Object>();

        if ((escuderiaUI.getId() != null) && (escuderiaUI.getId() != 0)) {
            params.put("id_escuderia", escuderiaUI.getId());
        }

        if (StringUtils.isNotBlank(escuderiaUI.getNombre())) {
            params.put("nombre", escuderiaUI.getNombre());
        }

        if ((escuderiaUI.getIdPais() != null) && (escuderiaUI.getIdPais() != 0)) {
            params.put("id_pais", escuderiaUI.getIdPais());
        }

        final List<Escuderia> listaEscuderia = this.dao.find(params);
        final List<EscuderiaUI> resultados = new ArrayList<EscuderiaUI>();
        for (final Escuderia escuderia : listaEscuderia) {
            resultados.add(AdapterUI.adapt(escuderia));
        }
        return resultados;
    }

}
