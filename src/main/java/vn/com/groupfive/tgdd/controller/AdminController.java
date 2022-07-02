package vn.com.groupfive.tgdd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin")
	public String adminHome() {
		return "admin/admin-home";
	}

	@GetMapping("/login")
	public String loginAdmin() {
		return "admin/pages/login";
	}

	@GetMapping("/admin/products-list")
	public String listProduct() {
		return "admin/pages/product/products-list";
	}

	@GetMapping("/admin/products-add")
	public String addProduct() {
		return "admin/pages/product/products-add";
	}
}
