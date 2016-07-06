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

import com.fic.pfc.jpg.dao.EscuderiaDAO;
import com.fic.pfc.jpg.model.Escuderia;

@Repository
public class EscuderiaDAOImpl implements EscuderiaDAO {
    private HibernateTemplate hibernate;
    private Session session;

    @Autowired
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.hibernate = new HibernateTemplate(sessionFactory);
        this.session = sessionFactory.openSession();
    }

    public void save(final Escuderia escuderia) {
        this.hibernate.save(escuderia);
    }

    public List<Escuderia> findAll() {
        return this.hibernate.loadAll(Escuderia.class);
    }

    public Escuderia find(final Integer id) {
        return this.hibernate.get(Escuderia.class, id);
    }

    public void delete(final Escuderia escuderia) {
        this.hibernate.delete(escuderia);
    }

    public List<Escuderia> find(final Map<String, Object> params) {
        String sql = "SELECT * FROM ESCUDERIA";

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
        query.addEntity(Escuderia.class);
        final List<Escuderia> results = query.list();
        return results;
    }

}
