package com.fic.pfc.jpg.ui;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PaisUI {

    private Integer id;
    private String nombre;

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof PaisUI)) {
            return false;
        }
        final PaisUI castOther = (PaisUI) other;
        return new EqualsBuilder().append(this.id, castOther.id).append(this.nombre, castOther.nombre).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).append(this.nombre).toHashCode();
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

}
