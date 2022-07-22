package vn.com.groupfive.tgdd.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping({ "", "home" })
	public String adminHome() {
		return "admin/fragments/dashboard";
	}

	@GetMapping("categories/add")
	public String categoryAdd() {
		return "admin/fragments/category/category-add";
	}

	@GetMapping("categories/list")
	public String categoryList(Model model) {
		RestTemplate restTemplate = new RestTemplate();

		String resourceUrl0 = "http://localhost:8001/customer/get-all-category-by-level/0";
		String resourceUrl1 = "http://localhost:8001/customer/get-all-category-by-level/1";
		String resourceUrl2 = "http://localhost:8001/customer/get-all-category-by-level/2";

		ResponseEntity<Object> response0 = restTemplate.getForEntity(resourceUrl0, Object.class);
		ResponseEntity<Object> response1 = restTemplate.getForEntity(resourceUrl1, Object.class);
		ResponseEntity<Object> response2 = restTemplate.getForEntity(resourceUrl2, Object.class);

		model.addAttribute("categoriesLevel0", response0.getBody());
		model.addAttribute("categoriesLevel1", response1.getBody());
		model.addAttribute("categoriesLevel2", response2.getBody());

		return "admin/fragments/category/category-list";
	}

	@GetMapping("products/add")
	public String addProduct() {
		return "admin/fragments/products/products-add";
	}

	@GetMapping("products/list")
	public String listProduct() {
		return "admin/fragments/products/products-list";
	}

}
