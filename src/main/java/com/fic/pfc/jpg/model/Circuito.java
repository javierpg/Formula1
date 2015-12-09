package com.fic.pfc.jpg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "circuito")
public class Circuito {

    @Id
    @Column(name = "id_circuito")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nombre;

    // @Column
    // private Pais pais;

    @Column(name = "id_pais")
    private Integer idPais;

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

    public Integer getIdPais() {
        return this.idPais;
    }

    public void setIdPais(final Integer idPais) {
        this.idPais = idPais;
    }

    // public Pais getPais() {
    // return this.pais;
    // }
    //
    // public void setPais(final Pais pais) {
    // this.pais = pais;
    // }

}
