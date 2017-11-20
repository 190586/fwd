package com.fwd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "home";
    }

    @RequestMapping(value = "/testi-regist", method = RequestMethod.GET)
    public String testiRegist() {
        return "testi-regist";
    }

    @RequestMapping(value = "/testi-submit", method = RequestMethod.GET)
    public String testiSubmit() {
        return "testi-submit";
    }

    @RequestMapping(value = "/testi-thanks", method = RequestMethod.GET)
    public String testiThanks() {
        return "testi-thanks";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin/content";
    }

    @RequestMapping(value = "/admin/pages-content-panel", method = RequestMethod.GET)
    public String adminpagescontentpanel() {
        return "admin/pages-content-panel";
    }

    @RequestMapping(value = "/admin/addpage-content-panel", method = RequestMethod.GET)
    public String adminaddpagecontentpanel() {
        return "admin/addpage-content-panel";
    }

    @RequestMapping(value = "/admin/users-content-panel", method = RequestMethod.GET)
    public String adminuserscontentpanel() {
        return "admin/users-content-panel";
    }
    
    @RequestMapping(value = "/admin/testimoni-content-panel", method = RequestMethod.GET)
    public String admintestimonicontentpanel() {
        return "admin/testimoni-content-panel";
    }

    @RequestMapping(value = "/admin/menu-content-panel", method = RequestMethod.GET)
    public String adminmenucontentpanel() {
        return "admin/menu-content-panel";
    }

    @RequestMapping(value = "/admin/profile-content-panel", method = RequestMethod.GET)
    public String adminprofilecontentpanel() {
        return "admin/profile-content-panel";
    }
    
    /*
    @RequestMapping(value = "/admin/pages", method = RequestMethod.GET)
    public String adminpages() {
        return "/admin/pages";
    }
    
    @RequestMapping(value = "/admin/addpage", method = RequestMethod.GET)
    public String adminaddpage() {
        return "/admin/addpage";
    }
    
    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String adminusers() {
        return "/admin/users";
    }
    
    @RequestMapping(value = "/admin/testimoni", method = RequestMethod.GET)
    public String admintestimoni() {
        return "/admin/testimoni";
    }
    
    @RequestMapping(value = "/admin/menu", method = RequestMethod.GET)
    public String adminmenu() {
        return "/admin/menu";
    }
    
    @RequestMapping(value = "/admin/profile", method = RequestMethod.GET)
    public String adminprofile() {
        return "/admin/profile";
    }
    
    */

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String error403() {
        return "error/403";
    }

}
