package com.fic.pfc.jpg.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
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

    @Transactional
    public List<PaisUI> find(final PaisUI paisUI) {
        final Map<String, Object> params = new HashMap<String, Object>();
        if (paisUI.getId() != null) {
            params.put("id_pais", paisUI.getId());
        }
        if (StringUtils.isNotBlank(paisUI.getNombre())) {
            params.put("nombre", paisUI.getNombre());
        }

        final List<Pais> listaPais = this.dao.find(params);
        final List<PaisUI> resultados = new ArrayList<PaisUI>();
        for (final Pais pais : listaPais) {
            resultados.add(AdapterUI.adapt(pais));
        }
        return resultados;
    }

}
