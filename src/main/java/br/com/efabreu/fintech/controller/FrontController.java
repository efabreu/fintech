package br.com.efabreu.fintech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.efabreu.fintech.service.UsersService;
import br.com.efabreu.fintech.service.ValueRecordsService;

@RestController
@RequestMapping("/home")
public class FrontController {
	
	@Autowired 
	UsersService authService;
	
	@Autowired 
	ValueRecordsService recordService;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.setViewName("ordensdeservico/index");		
		return mv;

	}

}
