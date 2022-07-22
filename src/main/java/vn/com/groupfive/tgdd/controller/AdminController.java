package vn.com.groupfive.tgdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping({ "", "home" })
	public String adminHome(Model model) {

		model.addAttribute("admin", true);
		return "admin/fragments/dashboard";
	}

	@GetMapping("categories-add")
	public String categoryAdd(Model model) {
		model.addAttribute("category", true);
		return "admin/fragments/category/category-add";
	}

	@GetMapping("categories-list")
	public String categoryList(Model model) {
		String resourceUrl0 = "http://localhost:8001/customer/get-all-category-by-level/0";
		String resourceUrl1 = "http://localhost:8001/customer/get-all-category-by-level/1";
		String resourceUrl2 = "http://localhost:8001/customer/get-all-category-by-level/2";

		ResponseEntity<Object> response0 = restTemplate.getForEntity(resourceUrl0, Object.class);
		ResponseEntity<Object> response1 = restTemplate.getForEntity(resourceUrl1, Object.class);
		ResponseEntity<Object> response2 = restTemplate.getForEntity(resourceUrl2, Object.class);

		model.addAttribute("categoriesLevel0", response0.getBody());
		model.addAttribute("categoriesLevel1", response1.getBody());
		model.addAttribute("categoriesLevel2", response2.getBody());
		model.addAttribute("category", true);

		return "admin/fragments/category/category-list";
	}

	@GetMapping("product-add")
	public String addProduct(Model model) {
		model.addAttribute("product", true);
		return "admin/fragments/products/products-add";
	}

	@GetMapping("product-list")
	public String listProduct(Model model) {
		model.addAttribute("product", true);
		return "admin/fragments/products/products-list";
	}

	@GetMapping("branch-list")
	public String listBranch(Model model) {
		model.addAttribute("branch", true);
		return "admin/fragments/branch/branch-list";
	}

	@GetMapping("branch-add")
	public String addBranch(Model model) {
		model.addAttribute("branch", true);
		return "admin/fragments/branch/branch-add";
	}

	@GetMapping("order-list")
	public String listOrder(Model model) {
		model.addAttribute("order", true);
		return "admin/fragments/order/order-list";
	}

	@GetMapping("order-add")
	public String addOrder(Model model) {
		model.addAttribute("order", true);
		return "admin/fragments/order/order-add";
	}

	@GetMapping("promotion-list")
	public String listPromotion(Model model) {
		model.addAttribute("promotion", true);
		return "admin/fragments/promotion/promotion-list";
	}

	@GetMapping("promotion-add")
	public String addPromotion(Model model) {
		model.addAttribute("promotion", true);
		return "admin/fragments/promotion/promotion-add";
	}

	@GetMapping("transaction-list")
	public String listTransaction(Model model) {
		model.addAttribute("transaction", true);
		return "admin/fragments/transaction/transaction-list";
	}

	@GetMapping("transaction-add")
	public String addTransaction(Model model) {
		model.addAttribute("transaction", true);
		return "admin/fragments/transaction/transaction-add";
	}

	@GetMapping("member-list")
	public String listMember(Model model) {
		model.addAttribute("member", true);
		return "admin/fragments/member/member-list";
	}

	@GetMapping("member-add")
	public String addMember(Model model) {
		model.addAttribute("member", true);
		return "admin/fragments/member/member-add";
	}

	@ModelAttribute("dashboard")
	public boolean dashboard() {
		return false;
	}

	@ModelAttribute("product")
	public boolean product() {
		return false;
	}

	@ModelAttribute("branch")
	public boolean branch() {
		return false;
	}

	@ModelAttribute("transaction")
	public boolean transaction() {
		return false;
	}

	@ModelAttribute("promotion")
	public boolean promotion() {
		return false;
	}

	@ModelAttribute("order")
	public boolean order() {
		return false;
	}

	@ModelAttribute("member")
	public boolean member() {
		return false;
	}

}
