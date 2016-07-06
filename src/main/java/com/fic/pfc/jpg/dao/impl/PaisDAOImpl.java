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

import com.fic.pfc.jpg.dao.PaisDAO;
import com.fic.pfc.jpg.model.Pais;

@Repository
public class PaisDAOImpl implements PaisDAO {

    private HibernateTemplate hibernate;
    private Session session;

    @Autowired
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.hibernate = new HibernateTemplate(sessionFactory);
        this.session = sessionFactory.openSession();
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

    public List<Pais> find(final Map<String, Object> params) {
        String sql = "SELECT * FROM PAIS";

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
        query.addEntity(Pais.class);
        final List<Pais> results = query.list();
        return results;
    }

}
