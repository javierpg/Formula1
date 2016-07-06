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
import com.fic.pfc.jpg.ui.EscuderiaUI;

@Controller
@RequestMapping("admin/escuderia")
public class EscuderiaController {

    private static final Logger LOG = LoggerFactory.getLogger(EscuderiaController.class);
    @Autowired
    private EscuderiaService service;
    @Autowired
    private PaisService paisService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView escuderiaEntrada(final HttpServletRequest request) {
        LOG.info("Entrando en administracion/Escuderia");
        final ModelAndView mv = new ModelAndView("escuderia", "escuderia", new EscuderiaUI());
        if (request.getSession().getAttribute("escuderias") != null) {
            mv.addObject("escuderias", request.getSession().getAttribute("escuderias"));
            request.getSession().removeAttribute("escuderias");
        } else {
            mv.addObject("escuderias", this.service.findAll());
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
    public String addEscuderia(final HttpServletRequest request, final Locale locale,
            @ModelAttribute("escuderia") final EscuderiaUI escuderia,
            final BindingResult result) {
        LOG.info("Anadiendo escuderia" + escuderia.getNombre());
        try {
            this.service.save(escuderia);
        } catch (final Exception ex) {
            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/admin/escuderia";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEscuderia(final HttpServletRequest request, @PathVariable("id") final int id) {
        LOG.info("Borrando escuderia" + id);
        try {
            this.service.delete(id);
        } catch (final DataIntegrityViolationException ex) {
            request.getSession().setAttribute("errorMessage",
                    "No se puede eliminar la entidad con id: " + id + " porque esta siendo usado por otra entidad.");
        } catch (final Exception ex) {
            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/admin/escuderia";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchEscuderia(final HttpServletRequest request,
            @ModelAttribute("escuderia") final EscuderiaUI escuderia) {
        LOG.info("Buscando escuderia");
        try {
            request.getSession().setAttribute("escuderias", this.service.find(escuderia));
        } catch (final Exception ex) {
            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/admin/escuderia";
    }

}
