package com.fic.pfc.jpg.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fic.pfc.jpg.dao.EscuderiaDAO;
import com.fic.pfc.jpg.dao.PaisDAO;
import com.fic.pfc.jpg.dao.PilotoDAO;
import com.fic.pfc.jpg.model.Escuderia;
import com.fic.pfc.jpg.model.Pais;
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
        final Pais paisPiloto = this.paisDao.find(pilotoUI.getPais().getId());
        final Escuderia escuderia = this.escuderiaDao.find(pilotoUI.getEscuderia().getId());
        final Pais paisEscuderia = this.paisDao.find(escuderia.getPais().getId());
        escuderia.setPais(paisEscuderia);
        pilotoUI.setPais(AdapterUI.adapt(paisPiloto));
        pilotoUI.setEscuderia(AdapterUI.adapt(escuderia));
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

}
