package com.fwd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/home";
    }
	
	
	@RequestMapping(value = "/testi-regist", method = RequestMethod.GET)
    public String testiRegist() {
        return "/testi-regist";
    }
    
	@RequestMapping(value = "/testi-submit", method = RequestMethod.GET)
    public String testiSubmit() {
        return "/testi-submit";
    }
    
	@RequestMapping(value = "/testi-thanks", method = RequestMethod.GET)
    public String testiThanks() {
        return "/testi-thanks";
    }


	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "/admin";
    }
    
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
    
	@RequestMapping(value = "/admin/adduser", method = RequestMethod.GET)
    public String adminadduser() {
        return "/admin/adduser";
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
    
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        return "/user";
    }

	@RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "/about";
    }

	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

	@RequestMapping(value = "/403", method = RequestMethod.GET)
    public String error403() {
        return "/error/403";
    }

}
