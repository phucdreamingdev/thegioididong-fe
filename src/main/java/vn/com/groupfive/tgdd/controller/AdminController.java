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
@RequestMapping(value = "admin")
public class AdminController {

	@GetMapping(value = "dashboard")
	public String adminHome(Model model) {
		return "admin/fragments/dashboard";
	}

	@GetMapping(value = "categories/add")
	public String categoryAdd(Model model) {
		return "admin/fragments/category/category-add";
	}

	@GetMapping(value = "categories/list")
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
		model.addAttribute("category", true);

		return "admin/fragments/category/category-list";
	}

	@GetMapping(value = "product/add")
	public String addProduct(Model model) {

		return "admin/fragments/products/products-add";
	}

	@GetMapping(value = "product/list")
	public String listProduct(Model model) {

		return "admin/fragments/products/products-list";
	}

	@GetMapping(value = "branch/list")
	public String listBranch(Model model) {

		return "admin/fragments/branch/branch-list";
	}

	@GetMapping(value = "branch/add")
	public String addBranch(Model model) {

		return "admin/fragments/branch/branch-add";
	}

	@GetMapping(value = "order/list")
	public String listOrder(Model model) {

		return "admin/fragments/order/order-list";
	}

	@GetMapping(value = "order/add")
	public String addOrder(Model model) {

		return "admin/fragments/order/order-add";
	}

	@GetMapping(value = "promotion/list")
	public String listPromotion(Model model) {

		return "admin/fragments/promotion/promotion-list";
	}

	@GetMapping(value = "promotion/add")
	public String addPromotion(Model model) {

		return "admin/fragments/promotion/promotion-add";
	}

	@GetMapping(value = "transaction/list")
	public String listTransaction(Model model) {

		return "admin/fragments/transaction/transaction-list";
	}

	@GetMapping(value = "transaction/add")
	public String addTransaction(Model model) {

		return "admin/fragments/transaction/transaction-add";
	}

	@GetMapping(value = "member/list")
	public String listMember(Model model) {

		return "admin/fragments/member/member-list";
	}

	@GetMapping(value = "member/add")
	public String addMember(Model model) {

		return "admin/fragments/member/member-add";
	}

}
