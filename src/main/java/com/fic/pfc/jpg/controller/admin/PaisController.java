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

import com.fic.pfc.jpg.model.Pais;
import com.fic.pfc.jpg.service.PaisService;
import com.fic.pfc.jpg.ui.PaisUI;

@Controller
@RequestMapping("admin/pais")
public class PaisController {

    private static final Logger LOG = LoggerFactory.getLogger(PaisController.class);
    @Autowired
    private PaisService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView paisEntrada(final HttpServletRequest request) {
        LOG.info("Entrando en administracion/Pais");
        final ModelAndView mv = new ModelAndView("pais", "pais", new Pais());
        if (request.getSession().getAttribute("paises") != null) {
            mv.addObject("paises", request.getSession().getAttribute("paises"));
            request.getSession().removeAttribute("paises");
        } else {
            mv.addObject("paises", this.service.findAll());
        }

        if (request.getSession().getAttribute("errorMessage") != null) {
            mv.addObject("hasErrors", true);
            mv.addObject("errorMessage", request.getSession().getAttribute("errorMessage"));
            request.getSession().removeAttribute("errorMessage");
        }

        return mv;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addPais(final HttpServletRequest request, final Locale locale,
            @ModelAttribute("pais") final PaisUI pais,
            final BindingResult result) {
        LOG.info("Anadiendo pais" + pais.getNombre());
        try {
            this.service.save(pais);
        } catch (final Exception ex) {
            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }
        final ModelAndView mv = new ModelAndView("pais");
        return "redirect:/admin/pais";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePais(final HttpServletRequest request, @PathVariable("id") final int id) {
        LOG.info("Borrando pais" + id);
        try {
            this.service.delete(id);
        } catch (final DataIntegrityViolationException ex) {
            request.getSession().setAttribute("errorMessage",
                    "No se puede eliminar la entidad con id: " + id + " porque esta siendo usado por otra entidad.");
        } catch (final Exception ex) {
            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/admin/pais";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPais(final HttpServletRequest request, @ModelAttribute("pais") final PaisUI paisUI) {
        LOG.info("Buscando pais");
        try {
            request.getSession().setAttribute("paises", this.service.find(paisUI));
        } catch (final Exception ex) {
            request.getSession().setAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/admin/pais";
    }

}
