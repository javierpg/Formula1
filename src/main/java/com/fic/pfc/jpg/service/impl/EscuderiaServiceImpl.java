package com.fic.pfc.jpg.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

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
        final Pais pais = this.paisDao.find(escuderiaUI.getPais().getId());
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

}
