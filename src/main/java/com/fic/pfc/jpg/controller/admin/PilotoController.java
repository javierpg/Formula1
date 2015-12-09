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

import com.fic.pfc.jpg.model.Piloto;
import com.fic.pfc.jpg.service.PilotoService;

@Controller
@RequestMapping("admin/piloto")
public class PilotoController {

    private static final Logger LOG = LoggerFactory.getLogger(PilotoController.class);
    @Autowired
    private PilotoService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView pilotoEntrada() {
        LOG.info("Entrando en administracion/Piloto");
        final ModelAndView mv = new ModelAndView("piloto", "piloto", new Piloto());
        mv.addObject("pilotos", this.service.findAll());
        return mv;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView addPiloto(final Locale locale, @ModelAttribute("piloto") final Piloto piloto,
            final BindingResult result) {
        LOG.info("Anadiendo piloto" + piloto.getNombre());
        this.service.save(piloto);

        final ModelAndView mv = new ModelAndView("piloto");
        return mv;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePiloto(@PathVariable("id") final int id) {
        LOG.info("Borrando piloto" + id);
        this.service.delete(id);
        return "redirect:/admin/piloto";
    }

}
