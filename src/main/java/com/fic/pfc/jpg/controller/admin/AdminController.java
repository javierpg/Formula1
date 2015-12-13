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

import com.fic.pfc.jpg.service.UsuarioService;
import com.fic.pfc.jpg.ui.UsuarioUI;

@Controller
@RequestMapping("admin/adminHome")
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private UsuarioService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView adminEntrada() {
        LOG.info("Entrando en administracion");
        final ModelAndView mv = new ModelAndView("adminHome", "usuario", new UsuarioUI());
        mv.addObject("users", this.service.findAll());
        return mv;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView addUser(final Locale locale, @ModelAttribute("usuario") final UsuarioUI usuario,
            final BindingResult result) {
        LOG.info("Anadiendo usuario" + usuario.getNombre() + " " + usuario.getCorreo());
        usuario.setIdRol(1);
        this.service.save(usuario);

        final ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") final int id) {
        LOG.info("Borrando usuario" + id);
        this.service.delete(id);
        return "redirect:/admin/adminHome";
    }

}
