package vn.com.groupfive.tgdd.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/home", "/index"})
	public String home() {
		return "index";
	}
	
	@GetMapping("/dtdd")
	public String phonePage() {
		return "pages/category/dtdd";
	}
	
	@GetMapping("/laptop-ldp")
	public String laptopPage() {
		return "pages/category/laptop-ldp";
	}
}
