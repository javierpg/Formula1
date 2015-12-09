package com.fic.pfc.jpg.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.fic.pfc.jpg.dao.EscuderiaDAO;
import com.fic.pfc.jpg.model.Escuderia;

@Repository
public class EscuderiaDAOImpl implements EscuderiaDAO {
    private HibernateTemplate hibernate;

    @Autowired
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.hibernate = new HibernateTemplate(sessionFactory);
    }

    public void save(final Escuderia escuderia) {
        this.hibernate.save(escuderia);
    }

    public List<Escuderia> findAll() {
        return this.hibernate.loadAll(Escuderia.class);
    }

    public Escuderia find(final Integer id) {
        return this.hibernate.load(Escuderia.class, id);
    }

    public void delete(final Escuderia escuderia) {
        this.hibernate.delete(escuderia);
    }

}
