package com.fic.pfc.jpg.controller.admin;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fic.pfc.jpg.service.UsuarioService;
import com.fic.pfc.jpg.ui.UsuarioUI;
import com.github.leleuj.ss.oauth.client.authentication.OAuthAuthenticationToken;

@Controller
@RequestMapping("admin/adminHome")
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private UsuarioService service;

    @Secured(value = "IS_AUTHENTICATED_FULLY")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView adminEntrada() {
        LOG.info("Entrando en administracion");
        final ModelAndView mv = new ModelAndView("adminHome", "usuario", new UsuarioUI());
        mv.addObject("users", this.service.findAll());
        final OAuthAuthenticationToken oa = (OAuthAuthenticationToken) SecurityContextHolder.getContext()
                .getAuthentication();
        // oa.setAuthenticated(false);
        // final Iterator<GrantedAuthority> i = oa.getAuthorities().iterator();
        // while (i.hasNext()) {
        // final GrantedAuthority ga = i.next();
        // oa.getAuthorities().remove(ga);
        // }
        // System.out.println("name: " + oa.getUserProfile().getAttributes().get("name"));
        // System.out.println("mail: " + oa.getUserProfile().getAttributes().get("email"));

        // if (oa != null){
        // new SecurityContextLogoutHandler().logout(request, response, oa);
        // }
        // return "redirect:/login?logout";
        final ModelAndView mv2 = new ModelAndView("userHome");
        return mv;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logoutPage(final HttpServletRequest request, final HttpServletResponse response) {
        // final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // final OAuthAuthenticationToken oa = (OAuthAuthenticationToken) SecurityContextHolder.getContext()
        // .getAuthentication();
        // if (auth != null) {
        // final SecurityContextLogoutHandler sclh = new SecurityContextLogoutHandler();
        // sclh.setClearAuthentication(true);
        // sclh.setInvalidateHttpSession(true);
        // sclh.logout(request, response, oa);
        //
        // }
        // oa.setAuthenticated(false);
        SecurityContextHolder.createEmptyContext();
        SecurityContextHolder.clearContext();
        request.changeSessionId();

        // final OAuthAuthenticationToken oa = (OAuthAuthenticationToken) SecurityContextHolder.getContext()
        // .getAuthentication();
        // System.out.println("name: " + oa.getUserProfile().getAttributes().get("name"));
        // System.out.println("mail: " + oa.getUserProfile().getAttributes().get("email"));
        // try {
        // request.logout();
        // } catch (final ServletException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // System.out.println("name: " + oa.getUserProfile().getAttributes().get("name"));
        // System.out.println("mail: " + oa.getUserProfile().getAttributes().get("email"));
        return "redirect:/index/index";// You can redirect wherever you want, but generally it's a good practice to
        // show login screen again.
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
