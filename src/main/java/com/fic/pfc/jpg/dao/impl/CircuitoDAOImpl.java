package com.fic.pfc.jpg.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.fic.pfc.jpg.dao.CircuitoDAO;
import com.fic.pfc.jpg.model.Circuito;

@Repository
public class CircuitoDAOImpl implements CircuitoDAO {

    private HibernateTemplate hibernate;
    private Session session;

    @Autowired
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.hibernate = new HibernateTemplate(sessionFactory);
        this.session = sessionFactory.openSession();
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

    public List<Circuito> find(final Map<String, Object> params) {
        String sql = "SELECT * FROM CIRCUITO";

        if ((params != null) && !params.isEmpty()) {
            sql = sql.concat(" WHERE ");
        }
        for (final String param : params.keySet()) {
            if (params.get(param) instanceof String) {
                sql = sql.concat(param + "= '" + params.get(param) + "' and ");
            } else if (params.get(param) instanceof Integer) {
                sql = sql.concat(param + "=" + params.get(param) + " and ");
            }
        }

        sql = StringUtils.removeEnd(sql, "and ");
        sql = sql.concat(" order by nombre asc");

        final SQLQuery query = this.session.createSQLQuery(sql);
        query.addEntity(Circuito.class);
        final List<Circuito> results = query.list();
        return results;
    }

}
