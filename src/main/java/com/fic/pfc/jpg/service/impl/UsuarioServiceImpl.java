package com.fic.pfc.jpg.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fic.pfc.jpg.dao.UsuarioDAO;
import com.fic.pfc.jpg.model.Usuario;
import com.fic.pfc.jpg.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Resource(name = "UsuarioDAO")
    private UsuarioDAO dao;

    @Transactional
    public void save(final Usuario usuario) {
        this.dao.save(usuario);

    }

    @Transactional
    public List<Usuario> findAll() {
        final List<Usuario> result = new ArrayList<Usuario>();
        result.addAll(this.dao.findAll());
        return result;
    }

    @Transactional
    public void delete(final Integer id) {
        final Usuario usuario = this.dao.find(id);
        if (usuario != null) {
            this.dao.delete(usuario);
        }
    }

}
