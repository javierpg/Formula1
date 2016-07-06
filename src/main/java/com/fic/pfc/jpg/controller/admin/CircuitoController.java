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

import com.fic.pfc.jpg.service.CircuitoService;
import com.fic.pfc.jpg.service.PaisService;
import com.fic.pfc.jpg.ui.CircuitoUI;

@Controller
@RequestMapping("admin/circuito")
public class CircuitoController {

    private static final Logger LOG = LoggerFactory.getLogger(CircuitoController.class);
    @Autowired
    private CircuitoService service;
    @Autowired
    private PaisService paisService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView circuitoEntrada(final HttpServletRequest request) {
        LOG.info("Entrando en administracion/circuito");
        final ModelAndView mv = new ModelAndView("circuito", "circuito", new CircuitoUI());
        if (request.getSession().getAttribute("circuitos") != null) {
            mv.addObject("circuitos", request.getSession().getAttribute("circuitos"));
            request.getSession().removeAttribute("circuitos");
        } else {
            mv.addObject("circuitos", this.service.findAll());
        }
        if (request.getSession().getAttribute("errorMessage") != null) {
            mv.addObject("hasErrors", true);
            mv.addObject("errorMessage", request.getSession().getAttribute("errorMessage"));
            request.getSession().removeAttribute("errorMessage");
        }
        mv.addObject("paises", this.paisService.findAll());
        return mv;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addCircuito(final HttpServletRequest request, final Locale locale,
            @ModelAttribute("circuito") final CircuitoUI circuito,
            final BindingResult result) {
        LOG.info("Anadiendo circuito" + circuito.getNombre());
        try {
            this.service.save(circuito);
        } catch (final Exception ex) {
            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }
        final ModelAndView mv = new ModelAndView("circuito");
        return "redirect:/admin/circuito";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCircuito(final HttpServletRequest request, @PathVariable("id") final int id) {
        LOG.info("Borrando circuito" + id);
        try {
            this.service.delete(id);
        } catch (final DataIntegrityViolationException ex) {
            request.getSession().setAttribute("errorMessage",
                    "No se puede eliminar la entidad con id: " + id + " porque esta siendo usado por otra entidad.");
        } catch (final Exception ex) {
            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/admin/circuito";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchCircuito(final HttpServletRequest request, @ModelAttribute("circuito") final CircuitoUI circuito) {
        LOG.info("Buscando circuito");
        try {
            request.getSession().setAttribute("circuitos", this.service.find(circuito));
        } catch (final Exception ex) {
            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/admin/circuito";
    }

}
