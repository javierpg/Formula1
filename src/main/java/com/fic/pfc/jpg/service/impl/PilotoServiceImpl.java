package com.fic.pfc.jpg.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fic.pfc.jpg.dao.PilotoDAO;
import com.fic.pfc.jpg.model.Piloto;
import com.fic.pfc.jpg.service.PilotoService;

@Service
public class PilotoServiceImpl implements PilotoService {

    @Resource(name = "PilotoDAO")
    private PilotoDAO dao;

    @Transactional
    public void save(final Piloto piloto) {
        this.dao.save(piloto);
    }

    @Transactional
    public List<Piloto> findAll() {
        final List<Piloto> result = new ArrayList<Piloto>();
        result.addAll(this.dao.findAll());
        return result;
    }

    @Transactional
    public void delete(final Integer id) {
        final Piloto piloto = this.dao.find(id);
        if (piloto != null) {
            this.dao.delete(piloto);
        }
    }

}
