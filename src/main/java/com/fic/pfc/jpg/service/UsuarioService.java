package com.fic.pfc.jpg.service;

import java.util.List;

import com.fic.pfc.jpg.ui.UsuarioUI;

public interface UsuarioService {

    public void save(UsuarioUI usuario);

    public List<UsuarioUI> findAll();

    public UsuarioUI find(Integer id);

    public void delete(Integer id);

}
