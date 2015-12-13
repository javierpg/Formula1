package com.fic.pfc.jpg.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fic.pfc.jpg.dao.UsuarioDAO;
import com.fic.pfc.jpg.model.Usuario;
import com.fic.pfc.jpg.service.UsuarioService;
import com.fic.pfc.jpg.ui.UsuarioUI;
import com.fic.pfc.jpg.utils.AdapterEntity;
import com.fic.pfc.jpg.utils.AdapterUI;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Resource(name = "UsuarioDAO")
    private UsuarioDAO dao;

    @Transactional
    public void save(final UsuarioUI usuario) {
        this.dao.save(AdapterEntity.adapt(usuario));

    }

    @Transactional
    public List<UsuarioUI> findAll() {
        final List<UsuarioUI> result = new ArrayList<UsuarioUI>();
        result.addAll(AdapterUI.adaptListUsuario(this.dao.findAll()));
        return result;
    }

    @Transactional
    public void delete(final Integer id) {
        final Usuario usuario = this.dao.find(id);
        if (usuario != null) {
            this.dao.delete(usuario);
        }
    }

    @Transactional
    public UsuarioUI find(final Integer id) {
        final Usuario usuario = this.dao.find(id);
        return AdapterUI.adapt(usuario);
    }

}
