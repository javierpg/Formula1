package com.fic.pfc.jpg.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fic.pfc.jpg.model.Usuario;

@Controller
@RequestMapping("admin")
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping(value = "/adminHome", method = RequestMethod.GET)
    public ModelAndView adminEntrada() {
        LOG.info("Entrando en administracion");
        final ModelAndView mv = new ModelAndView("adminHome", "usuario", new Usuario());
        return mv;
    }

    @RequestMapping(value = "/adminHome", method = RequestMethod.POST)
    public ModelAndView prueba(@ModelAttribute("usuario") final Usuario usuario, final BindingResult result) {
        LOG.info("Probando");
        System.out.println("Usuario: " + usuario.getNombre());
        final ModelAndView mv = new ModelAndView("index");
        return mv;
    }

}
