package com.fic.pfc.jpg.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "piloto")
public class Piloto implements Serializable {

    private static final long serialVersionUID = -7750259878397150767L;

    @Id
    @Column(name = "id_piloto")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nombre;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_escuderia")
    private Escuderia escuderia;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_pais")
    private Pais pais;

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public Escuderia getEscuderia() {
        return this.escuderia;
    }

    public void setEscuderia(final Escuderia escuderia) {
        this.escuderia = escuderia;
    }

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(final Pais pais) {
        this.pais = pais;
    }

}
