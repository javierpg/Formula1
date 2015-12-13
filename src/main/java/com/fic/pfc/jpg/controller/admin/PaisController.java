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
    public ModelAndView paisEntrada() {
        LOG.info("Entrando en administracion/Pais");
        final ModelAndView mv = new ModelAndView("pais", "pais", new Pais());
        mv.addObject("paises", this.service.findAll());
        return mv;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addPais(final Locale locale, @ModelAttribute("pais") final PaisUI pais,
            final BindingResult result) {
        LOG.info("Anadiendo pais" + pais.getNombre());
        this.service.save(pais);

        final ModelAndView mv = new ModelAndView("pais");
        return "redirect:/admin/pais";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePais(@PathVariable("id") final int id) {
        LOG.info("Borrando pais" + id);
        this.service.delete(id);
        return "redirect:/admin/pais";
    }

}
