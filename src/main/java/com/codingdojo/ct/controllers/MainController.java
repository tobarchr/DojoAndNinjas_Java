package com.codingdojo.ct.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.ct.models.Dojo;
import com.codingdojo.ct.models.Ninja;
import com.codingdojo.ct.services.DojoService;
import com.codingdojo.ct.services.NinjaService;

@Controller
public class MainController {
	
	public final DojoService dojoService;
	public final NinjaService ninjaService;
	
	MainController(DojoService dojoService,NinjaService ninjaService){
		this.dojoService=dojoService;
		this.ninjaService=ninjaService;
	}
	
	@RequestMapping("/")
	public String index(Model model){
		return "index.jsp";
	}
	
    @RequestMapping("/dojos/new")
    public String newDojo(Model model) {
		model.addAttribute("dojo",new Dojo());
        return "/dojos/new.jsp";
    }
    
    @RequestMapping(value="/dojos", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "/dojos/new.jsp";
        } else {
        	dojoService.createDojo(dojo);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/ninjas/new")
    public String newNinja(Model model) {
        List<Dojo> dojoList = dojoService.allDojos();
        model.addAttribute("dojo",dojoList);
		model.addAttribute("ninja",new Ninja());
        return "/ninjas/new.jsp";
    }
    
    @RequestMapping(value="/ninjas", method=RequestMethod.POST)
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "/ninjas/new.jsp";
        } else {
        	ninjaService.createNinja(ninja);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/dojos/{id}")
    public String findDojo(@PathVariable("id") Long id,Model model) {
        Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo",dojo);
		return "/dojos/view.jsp";
    }
}
