package com.fic.pfc.jpg.ui;

public class PilotoUI {

    private Integer id;
    private String nombre;
    private EscuderiaUI escuderia;
    private PaisUI pais;

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

    public EscuderiaUI getEscuderia() {
        return this.escuderia;
    }

    public void setEscuderia(final EscuderiaUI escuderia) {
        this.escuderia = escuderia;
    }

    public PaisUI getPais() {
        return this.pais;
    }

    public void setPais(final PaisUI pais) {
        this.pais = pais;
    }

}
