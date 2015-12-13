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
    public ModelAndView escuderiaEntrada() {
        LOG.info("Entrando en administracion/Escuderia");
        final ModelAndView mv = new ModelAndView("escuderia", "escuderia", new EscuderiaUI());
        mv.addObject("escuderias", this.service.findAll());
        mv.addObject("paises", this.paisService.findAll());
        return mv;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addEscuderia(final Locale locale, @ModelAttribute("escuderia") final EscuderiaUI escuderia,
            final BindingResult result) {
        LOG.info("Anadiendo escuderia" + escuderia.getNombre());
        this.service.save(escuderia);
        return "redirect:/admin/escuderia";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEscuderia(@PathVariable("id") final int id) {
        LOG.info("Borrando escuderia" + id);
        this.service.delete(id);
        return "redirect:/admin/escuderia";
    }

}
