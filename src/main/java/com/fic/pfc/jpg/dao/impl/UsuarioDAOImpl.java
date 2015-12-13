package com.fic.pfc.jpg.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.fic.pfc.jpg.dao.UsuarioDAO;
import com.fic.pfc.jpg.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    private HibernateTemplate hibernate;

    @Autowired
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.hibernate = new HibernateTemplate(sessionFactory);
    }

    public void save(final Usuario usuario) {
        this.hibernate.save(usuario);
    }

    public List<Usuario> findAll() {
        return this.hibernate.loadAll(Usuario.class);
    }

    public Usuario find(final Integer id) {
        return this.hibernate.get(Usuario.class, id);
    }

    public void delete(final Usuario user) {
        this.hibernate.delete(user);
    }

}
