package com.fic.pfc.jpg.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.fic.pfc.jpg.dao.PilotoDAO;
import com.fic.pfc.jpg.model.Piloto;

@Repository
public class PilotoDAOImpl implements PilotoDAO {

    private HibernateTemplate hibernate;

    @Autowired
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.hibernate = new HibernateTemplate(sessionFactory);
    }

    public void save(final Piloto piloto) {
        this.hibernate.save(piloto);
    }

    public List<Piloto> findAll() {
        return this.hibernate.loadAll(Piloto.class);
    }

    public Piloto find(final Integer id) {
        return this.hibernate.load(Piloto.class, id);
    }

    public void delete(final Piloto piloto) {
        this.hibernate.delete(piloto);
    }

}
