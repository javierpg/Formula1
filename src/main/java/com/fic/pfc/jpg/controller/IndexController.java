package com.fic.pfc.jpg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("index")
public class IndexController {

    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    // para pasar parametros en la url ej. /index/index?id=1
    // public ModelAndView index(@RequestParam("id") Long id) {
    // con la anotacion @Respondebody le digo al controller que no devuelvo una url sino un objeto para la jsp que est
    // aabierta
    @RequestMapping("/index")
    public ModelAndView index() {
        LOG.info("Entrando en la app");
        final ModelAndView mv = new ModelAndView("index");
        return mv;
    }

}
