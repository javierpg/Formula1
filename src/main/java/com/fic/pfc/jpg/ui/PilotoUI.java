package com.fic.pfc.jpg.ui;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PilotoUI {

    private Integer id;
    private String nombre;
    private Integer idEscuderia;
    private String nombreEscuderia;
    private Integer idPais;
    private String nombrePais;

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof PilotoUI)) {
            return false;
        }
        final PilotoUI castOther = (PilotoUI) other;
        return new EqualsBuilder().append(this.id, castOther.id).append(this.nombre, castOther.nombre)
                .append(this.idEscuderia, castOther.idEscuderia)
                .append(this.nombreEscuderia, castOther.nombreEscuderia)
                .append(this.idPais, castOther.idPais).append(this.nombrePais, castOther.nombrePais).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).append(this.nombre).append(this.idEscuderia)
                .append(this.nombreEscuderia)
                .append(this.idPais).append(this.nombrePais).toHashCode();
    }

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

    public Integer getIdEscuderia() {
        return this.idEscuderia;
    }

    public void setIdEscuderia(final Integer idEscuderia) {
        this.idEscuderia = idEscuderia;
    }

    public String getNombreEscuderia() {
        return this.nombreEscuderia;
    }

    public void setNombreEscuderia(final String nombreEscuderia) {
        this.nombreEscuderia = nombreEscuderia;
    }

    public Integer getIdPais() {
        return this.idPais;
    }

    public void setIdPais(final Integer idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return this.nombrePais;
    }

    public void setNombrePais(final String nombrePais) {
        this.nombrePais = nombrePais;
    }

}
