package com.fic.pfc.jpg.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fic.pfc.jpg.dao.PaisDAO;
import com.fic.pfc.jpg.model.Pais;
import com.fic.pfc.jpg.service.PaisService;
import com.fic.pfc.jpg.ui.PaisUI;
import com.fic.pfc.jpg.utils.AdapterEntity;
import com.fic.pfc.jpg.utils.AdapterUI;

@Service
public class PaisServiceImpl implements PaisService {

    @Resource(name = "PaisDAO")
    private PaisDAO dao;

    @Transactional
    public void save(final PaisUI pais) {
        this.dao.save(AdapterEntity.adapt(pais));
    }

    @Transactional
    public List<PaisUI> findAll() {
        final List<PaisUI> result = new ArrayList<PaisUI>();
        result.addAll(AdapterUI.adaptListPais(this.dao.findAll()));
        return result;
    }

    @Transactional
    public void delete(final Integer id) {
        final Pais pais = this.dao.find(id);
        if (pais != null) {
            this.dao.delete(pais);
        }
    }

    @Transactional
    public PaisUI find(final Integer id) {
        final Pais pais = this.dao.find(id);
        return AdapterUI.adapt(pais);
    }

}
