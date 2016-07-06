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

public class AdapterUI {

    public static UsuarioUI adapt(final Usuario usuario) {
        final UsuarioUI adapted = new UsuarioUI();
        adapted.setId(usuario.getId());
        adapted.setNombre(usuario.getNombre());
        adapted.setCorreo(usuario.getCorreo());
        adapted.setIdRol(usuario.getIdRol());
        adapted.setPassword(usuario.getPassword());
        return adapted;
    }

    public static List<UsuarioUI> adaptListUsuario(final List<Usuario> usuarios) {
        final List<UsuarioUI> listAdapted = new ArrayList<UsuarioUI>();
        for (final Usuario usuario : usuarios) {
            listAdapted.add(adapt(usuario));
        }
        return listAdapted;
    }

    public static PilotoUI adapt(final Piloto piloto) {
        final PilotoUI adapted = new PilotoUI();
        adapted.setId(piloto.getId());
        adapted.setNombre(piloto.getNombre());
        adapted.setIdPais(piloto.getPais().getId());
        adapted.setNombrePais(piloto.getPais().getNombre());
        adapted.setIdEscuderia(piloto.getEscuderia().getId());
        adapted.setNombreEscuderia(piloto.getEscuderia().getNombre());
        return adapted;
    }

    public static List<PilotoUI> adaptListPiloto(final List<Piloto> pilotos) {
        final List<PilotoUI> listAdapted = new ArrayList<PilotoUI>();
        for (final Piloto piloto : pilotos) {
            listAdapted.add(adapt(piloto));
        }
        return listAdapted;
    }

    public static EscuderiaUI adapt(final Escuderia escuderia) {
        final EscuderiaUI adapted = new EscuderiaUI();
        adapted.setId(escuderia.getId());
        adapted.setNombre(escuderia.getNombre());
        adapted.setIdPais(escuderia.getPais().getId());
        adapted.setNombrePais(escuderia.getPais().getNombre());
        return adapted;
    }

    public static List<EscuderiaUI> adaptListEscuderia(final List<Escuderia> escuderias) {
        final List<EscuderiaUI> listAdapted = new ArrayList<EscuderiaUI>();
        for (final Escuderia escuderia : escuderias) {
            listAdapted.add(adapt(escuderia));
        }
        return listAdapted;
    }

    public static PaisUI adapt(final Pais pais) {
        final PaisUI adapted = new PaisUI();
        adapted.setId(pais.getId());
        adapted.setNombre(pais.getNombre());
        return adapted;
    }

    public static List<PaisUI> adaptListPais(final List<Pais> paises) {
        final List<PaisUI> listAdapted = new ArrayList<PaisUI>();
        for (final Pais pais : paises) {
            listAdapted.add(adapt(pais));
        }
        return listAdapted;
    }

    public static CircuitoUI adapt(final Circuito circuito) {
        final CircuitoUI adapted = new CircuitoUI();
        adapted.setId(circuito.getId());
        adapted.setNombre(circuito.getNombre());
        adapted.setIdPais(circuito.getPais().getId());
        adapted.setNombrePais(circuito.getPais().getNombre());
        return adapted;
    }

    public static List<CircuitoUI> adaptListCircuito(final List<Circuito> circuitos) {
        final List<CircuitoUI> listAdapted = new ArrayList<CircuitoUI>();
        for (final Circuito circuito : circuitos) {
            listAdapted.add(adapt(circuito));
        }
        return listAdapted;
    }

}
