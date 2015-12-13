package com.fic.pfc.jpg.utils;

import java.util.ArrayList;
import java.util.List;

import com.fic.pfc.jpg.model.Circuito;
import com.fic.pfc.jpg.model.Escuderia;
import com.fic.pfc.jpg.model.Pais;
import com.fic.pfc.jpg.model.Piloto;
import com.fic.pfc.jpg.model.Usuario;
import com.fic.pfc.jpg.ui.CircuitoUI;
import com.fic.pfc.jpg.ui.EscuderiaUI;
import com.fic.pfc.jpg.ui.PaisUI;
import com.fic.pfc.jpg.ui.PilotoUI;
import com.fic.pfc.jpg.ui.UsuarioUI;

public class AdapterEntity {

    public static Usuario adapt(final UsuarioUI usuario) {
        final Usuario adapted = new Usuario();
        adapted.setId(usuario.getId());
        adapted.setNombre(usuario.getNombre());
        adapted.setCorreo(usuario.getCorreo());
        adapted.setIdRol(usuario.getIdRol());
        adapted.setPassword(usuario.getPassword());
        return adapted;
    }

    public static List<Usuario> adaptListUsuario(final List<UsuarioUI> usuarios) {
        final List<Usuario> listAdapted = new ArrayList<Usuario>();
        for (final UsuarioUI usuario : usuarios) {
            listAdapted.add(adapt(usuario));
        }
        return listAdapted;
    }

    public static Piloto adapt(final PilotoUI piloto) {
        final Piloto adapted = new Piloto();
        adapted.setId(piloto.getId());
        adapted.setNombre(piloto.getNombre());
        adapted.setPais(adapt(piloto.getPais()));
        adapted.setEscuderia(adapt(piloto.getEscuderia()));
        return adapted;
    }

    public static List<Piloto> adaptListPiloto(final List<PilotoUI> pilotos) {
        final List<Piloto> listAdapted = new ArrayList<Piloto>();
        for (final PilotoUI piloto : pilotos) {
            listAdapted.add(adapt(piloto));
        }
        return listAdapted;
    }

    public static Escuderia adapt(final EscuderiaUI escuderia) {
        final Escuderia adapted = new Escuderia();
        adapted.setId(escuderia.getId());
        adapted.setNombre(escuderia.getNombre());
        adapted.setPais(adapt(escuderia.getPais()));
        return adapted;
    }

    public static List<Escuderia> adaptListEscuderia(final List<EscuderiaUI> escuderias) {
        final List<Escuderia> listAdapted = new ArrayList<Escuderia>();
        for (final EscuderiaUI escuderia : escuderias) {
            listAdapted.add(adapt(escuderia));
        }
        return listAdapted;
    }

    public static Pais adapt(final PaisUI pais) {
        final Pais adapted = new Pais();
        adapted.setId(pais.getId());
        adapted.setNombre(pais.getNombre());
        return adapted;
    }

    public static List<Pais> adaptListPais(final List<PaisUI> paises) {
        final List<Pais> listAdapted = new ArrayList<Pais>();
        for (final PaisUI pais : paises) {
            listAdapted.add(adapt(pais));
        }
        return listAdapted;
    }

    public static Circuito adapt(final CircuitoUI circuito) {
        final Circuito adapted = new Circuito();
        adapted.setId(circuito.getId());
        adapted.setNombre(circuito.getNombre());
        adapted.setPais(adapt(circuito.getPais()));
        return adapted;
    }

    public static List<Circuito> adaptListadapt(final List<CircuitoUI> circuitos) {
        final List<Circuito> listAdapted = new ArrayList<Circuito>();
        for (final CircuitoUI circuito : circuitos) {
            listAdapted.add(adapt(circuito));
        }
        return listAdapted;
    }
}
