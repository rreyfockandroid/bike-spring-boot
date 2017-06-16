package pl.home.spring.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@Value("${welcome.message:test}")
	private String message = "Hello World";
	private String messCannondale = "Cannondale are probably the best bikes on the world";
	private String messKona = "Kona is USA firm";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
	
	@RequestMapping("/cannondale")
	public String cannondale(Map<String, Object> model) {
		model.put("bikeDesc", this.messCannondale);
		return "bikes";
	}

	@RequestMapping("/kona")
	public String kona(Map<String, Object> model) {
		model.put("bikeDesc", this.messKona);
		return "bikes";
	}
	
	@RequestMapping("/5xx")
	public void ServiceUnavailable() {
		System.out.println("Exception");
		throw new RuntimeException("ABC");
	}
	
	@RequestMapping("/404")
	public void Error404() {
		System.out.println("Exception");
		throw new RuntimeException("ABC");
	}
}