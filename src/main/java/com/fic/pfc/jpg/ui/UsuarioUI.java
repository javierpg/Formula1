package com.fic.pfc.jpg.ui;

public class UsuarioUI {

    private Integer id;
    private String nombre;
    private String correo;
    private String password;
    private Integer idRol;

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

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(final String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Integer getIdRol() {
        return this.idRol;
    }

    public void setIdRol(final Integer idRol) {
        this.idRol = idRol;
    }

}
