package com.fic.pfc.jpg.controller.admin;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fic.pfc.jpg.service.EscuderiaService;
import com.fic.pfc.jpg.service.PaisService;
import com.fic.pfc.jpg.service.PilotoService;
import com.fic.pfc.jpg.ui.PilotoUI;

@Controller
@RequestMapping("admin/piloto")
public class PilotoController {
    private static final Logger LOG = LoggerFactory.getLogger(PilotoController.class);
    @Autowired
    private PilotoService service;
    @Autowired
    private PaisService paisService;
    @Autowired
    private EscuderiaService escuderiasService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView pilotoEntrada(final HttpServletRequest request) {
        LOG.info("Entrando en administracion/Piloto");
        final ModelAndView mv = new ModelAndView("piloto", "piloto", new PilotoUI());
        if (request.getSession().getAttribute("pilotos") != null) {
            mv.addObject("pilotos", request.getSession().getAttribute("pilotos"));
            request.getSession().removeAttribute("pilotos");
        } else {
            mv.addObject("pilotos", this.service.findAll());
        }
        if (request.getSession().getAttribute("errorMessage") != null) {
            mv.addObject("hasErrors", true);
            mv.addObject("errorMessage", request.getSession().getAttribute("errorMessage"));
            request.getSession().removeAttribute("errorMessage");
        }
        mv.addObject("paises", this.paisService.findAll());
        mv.addObject("escuderias", this.escuderiasService.findAll());
        return mv;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addPiloto(final HttpServletRequest request, final Locale locale,
            @ModelAttribute("piloto") final PilotoUI piloto,
            final BindingResult result) {
        LOG.info("Anadiendo piloto" + piloto.getNombre());
        try {
            this.service.save(piloto);
        } catch (final Exception ex) {
            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/admin/piloto";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePiloto(final HttpServletRequest request, @PathVariable("id") final int id) {
        LOG.info("Borrando piloto" + id);
        try {
            this.service.delete(id);
        } catch (final DataIntegrityViolationException ex) {
            request.getSession().setAttribute("errorMessage",
                    "No se puede eliminar la entidad con id: " + id + " porque esta siendo usado por otra entidad.");
        } catch (final Exception ex) {
            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/admin/piloto";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPiloto(final HttpServletRequest request, @ModelAttribute("piloto") final PilotoUI pilotoUI) {
        LOG.info("Buscando piloto");
        try {
            request.getSession().setAttribute("pilotos", this.service.find(pilotoUI));
        } catch (final Exception ex) {
            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/admin/piloto";
    }

}
