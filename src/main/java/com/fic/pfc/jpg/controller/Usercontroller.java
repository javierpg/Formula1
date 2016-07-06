package com.fic.pfc.jpg.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.leleuj.ss.oauth.client.authentication.OAuthAuthenticationToken;

@Controller
@RequestMapping("user")
public class UserController {

    // @Secured(value = "IS_AUTHENTICATED_FULLY")
    @Secured(value = "IS_AUTHENTICATED_FULLY")
    @RequestMapping("/userHome")
    public ModelAndView userHome() {
        final ModelAndView mv = new ModelAndView("userHome");
        // mv.addObject("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final OAuthAuthenticationToken oa = (OAuthAuthenticationToken) SecurityContextHolder.getContext()
                .getAuthentication();
        System.out.println("name: " + oa.getUserProfile().getAttributes().get("name"));
        System.out.println("mail: " + oa.getUserProfile().getAttributes().get("email"));
        // mv.addObject("name", oa.getUserProfile().getAttributes().get("name"));
        // mv.addObject("mail", oa.getUserProfile().getAttributes().get("email"));
        return mv;
    }
}
