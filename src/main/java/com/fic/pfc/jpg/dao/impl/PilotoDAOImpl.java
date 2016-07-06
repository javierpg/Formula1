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

import com.fic.pfc.jpg.dao.PilotoDAO;
import com.fic.pfc.jpg.model.Piloto;

@Repository
public class PilotoDAOImpl implements PilotoDAO {

    private HibernateTemplate hibernate;
    private Session session;

    @Autowired
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.hibernate = new HibernateTemplate(sessionFactory);
        this.session = sessionFactory.openSession();
    }

    public void save(final Piloto piloto) {
        this.hibernate.save(piloto);
    }

    public List<Piloto> findAll() {
        return this.hibernate.loadAll(Piloto.class);
    }

    public Piloto find(final Integer id) {
        return this.hibernate.get(Piloto.class, id);
    }

    public void delete(final Piloto piloto) {
        this.hibernate.delete(piloto);
    }

    public List<Piloto> find(final Map<String, Object> params) {
        String sql = "SELECT * FROM PILOTO";

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
        query.addEntity(Piloto.class);
        // if (piloto.getId() != null) {
        // query.setParameter("id_piloto", piloto.getId());
        // }
        // if ((piloto.getEscuderia().getId() != null) && (piloto.getEscuderia().getId() != 0)) {
        // query.setParameter("id_escuderia", piloto.getEscuderia().getId());
        // }
        //
        // if ((piloto.getPais().getId() != null) && (piloto.getPais().getId() != 0)) {
        // query.setParameter("id_pais", piloto.getPais().getId());
        // }
        final List<Piloto> results = query.list();
        return results;
    }
}
