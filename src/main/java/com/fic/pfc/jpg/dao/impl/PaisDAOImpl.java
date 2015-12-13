package com.fic.pfc.jpg.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.fic.pfc.jpg.dao.PaisDAO;
import com.fic.pfc.jpg.model.Pais;

@Repository
public class PaisDAOImpl implements PaisDAO {

    private HibernateTemplate hibernate;

    @Autowired
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.hibernate = new HibernateTemplate(sessionFactory);
    }

    public void save(final Pais pais) {
        this.hibernate.save(pais);
    }

    public List<Pais> findAll() {
        return this.hibernate.loadAll(Pais.class);
    }

    public Pais find(final Integer id) {
        return this.hibernate.get(Pais.class, id);
    }

    public void delete(final Pais pais) {
        this.hibernate.delete(pais);
    }

}
