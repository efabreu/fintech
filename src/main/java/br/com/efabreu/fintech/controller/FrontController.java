package br.com.efabreu.fintech.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			mv.addObject("endereco", ip.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		mv.addObject("id", 1L);
		
		mv.setViewName("index");		
		return mv;

	}

}
