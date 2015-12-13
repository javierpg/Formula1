package com.fic.pfc.jpg.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.fic.pfc.jpg.dao.CircuitoDAO;
import com.fic.pfc.jpg.model.Circuito;

@Repository
public class CircuitoDAOImpl implements CircuitoDAO {

    private HibernateTemplate hibernate;

    @Autowired
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.hibernate = new HibernateTemplate(sessionFactory);
    }

    public void save(final Circuito circuito) {
        this.hibernate.save(circuito);
    }

    public List<Circuito> findAll() {
        return this.hibernate.loadAll(Circuito.class);
    }

    public Circuito find(final Integer id) {
        return this.hibernate.get(Circuito.class, id);
    }

    public void delete(final Circuito circuito) {
        this.hibernate.delete(circuito);
    }

}
