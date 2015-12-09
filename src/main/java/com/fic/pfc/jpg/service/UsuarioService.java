package com.fic.pfc.jpg.service;

import java.util.List;

import com.fic.pfc.jpg.model.Usuario;

public interface UsuarioService {

    public void save(Usuario usuario);

    public List<Usuario> findAll();

    public void delete(Integer id);

}
