package com.fic.pfc.jpg.controller.admin;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fic.pfc.jpg.model.Circuito;
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
    public ModelAndView circuitoEntrada() {
        LOG.info("Entrando en administracion/circuito");
        final ModelAndView mv = new ModelAndView("circuito", "circuito", new Circuito());
        mv.addObject("circuitos", this.service.findAll());
        mv.addObject("paises", this.paisService.findAll());
        return mv;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addCircuito(final Locale locale, @ModelAttribute("circuito") final CircuitoUI circuito,
            final BindingResult result) {
        LOG.info("Anadiendo circuito" + circuito.getNombre());
        this.service.save(circuito);

        final ModelAndView mv = new ModelAndView("circuito");
        return "redirect:/admin/circuito";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCircuito(@PathVariable("id") final int id) {
        LOG.info("Borrando circuito" + id);
        this.service.delete(id);
        return "redirect:/admin/circuito";
    }

}
