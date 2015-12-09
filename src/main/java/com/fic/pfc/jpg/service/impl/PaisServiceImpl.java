package com.fic.pfc.jpg.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fic.pfc.jpg.dao.PaisDAO;
import com.fic.pfc.jpg.model.Pais;
import com.fic.pfc.jpg.service.PaisService;

@Service
public class PaisServiceImpl implements PaisService {

    @Resource(name = "PaisDAO")
    private PaisDAO dao;

    @Transactional
    public void save(final Pais pais) {
        this.dao.save(pais);
    }

    @Transactional
    public List<Pais> findAll() {
        final List<Pais> result = new ArrayList<Pais>();
        result.addAll(this.dao.findAll());
        return result;
    }

    @Transactional
    public void delete(final Integer id) {
        final Pais pais = this.dao.find(id);
        if (pais != null) {
            this.dao.delete(pais);
        }
    }

}
