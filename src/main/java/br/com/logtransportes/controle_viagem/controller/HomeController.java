package br.com.logtransportes.controle_viagem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Welcome to Log Transportes!";
	}

}