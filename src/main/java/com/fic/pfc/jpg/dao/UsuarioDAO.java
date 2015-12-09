package com.fic.pfc.jpg.dao;

import java.util.List;

import com.fic.pfc.jpg.model.Usuario;

public interface UsuarioDAO {

    public void save(Usuario usuario);

    public List<Usuario> findAll();

    public Usuario find(Integer id);

    public void delete(Usuario user);
}
