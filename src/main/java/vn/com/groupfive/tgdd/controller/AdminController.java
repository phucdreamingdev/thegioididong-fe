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
		return "admin/layout-admin";
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

	@GetMapping("product/add")
	public String addProduct() {
		return "admin/fragments/products/products-add";
	}

	@GetMapping("product/list")
	public String listProduct() {
		return "admin/fragments/products/products-list";
	}

	@GetMapping("branch/list")
	public String listBranch() {
		return "admin/fragments/branch/branch-list";
	}

	@GetMapping("branch/add")
	public String addBranch() {
		return "admin/fragments/branch/branch-add";
	}

	@GetMapping("order/list")
	public String listOrder() {
		return "admin/fragments/order/order-list";
	}

	@GetMapping("order/add")
	public String addOrder() {
		return "admin/fragments/order/order-add";
	}

	@GetMapping("promotion/list")
	public String listPromotion() {
		return "admin/fragments/promotion/promotion-list";
	}

	@GetMapping("promotion/add")
	public String addPromotion() {
		return "admin/fragments/promotion/promotion-add";
	}

	@GetMapping("transaction/list")
	public String listTransaction() {
		return "admin/fragments/transaction/transaction-list";
	}

	@GetMapping("transaction/add")
	public String addTransaction() {
		return "admin/fragments/transaction/transaction-add";
	}

	@GetMapping("member/list")
	public String listMember() {
		return "admin/fragments/member/member-list";
	}

	@GetMapping("member/add")
	public String addMember() {
		return "admin/fragments/member/member-add";
	}

}
