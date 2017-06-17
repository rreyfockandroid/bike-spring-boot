package pl.home.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.home.spring.bean.BeanFactory;
import pl.home.spring.bean.BikesCollectionBean;

@Controller
public class WelcomeController {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private BikesCollectionBean bikesCollection;
	@Autowired
	private BeanFactory beanFactory;
	
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	private String messCannondale = "Cannondale are probably the best bikes on the world";
	private String messKona = "Kona is USA firm";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		System.out.println("remote user: " + request.getRemoteUser());
		model.put("message", this.message);
		return "welcome";
	}
	
	@RequestMapping("/about")
	public String about(Map<String, Object> model) {
		List<String> info = bikesCollection.getBikesName();
		model.put("bikes", info);
		model.put("bikes2", beanFactory.bikesBean().getBikesName());
		return "about";
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
	
	@RequestMapping("/login")
	public String login(Map<String, Object> model) {
		return "login";
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