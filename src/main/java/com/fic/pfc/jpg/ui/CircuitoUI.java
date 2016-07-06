package com.fic.pfc.jpg.ui;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CircuitoUI {

    private Integer id;
    private String nombre;
    private String nombrePais;
    private Integer idPais;

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof CircuitoUI)) {
            return false;
        }
        final CircuitoUI castOther = (CircuitoUI) other;
        return new EqualsBuilder().append(this.id, castOther.id).append(this.nombre, castOther.nombre)
                .append(this.nombrePais, castOther.nombrePais).append(this.idPais, castOther.idPais).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).append(this.nombre).append(this.nombrePais).append(this.idPais)
                .toHashCode();
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

    public String getNombrePais() {
        return this.nombrePais;
    }

    public void setNombrePais(final String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public Integer getIdPais() {
        return this.idPais;
    }

    public void setIdPais(final Integer idPais) {
        this.idPais = idPais;
    }

}
