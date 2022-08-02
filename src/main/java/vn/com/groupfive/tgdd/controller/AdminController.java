package vn.com.groupfive.tgdd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.com.groupfive.tgdd.payload.request.CategoryRequest;


@Controller
@RequestMapping(value = "admin")
public class AdminController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	HttpSession session;

	@GetMapping(value = "dashboard")
	public String adminHome(Model model) {
		return "admin/fragments/dashboard";
	}

	/*
	 * ================================CATEGORY================================
	 */


	// Get Category Level 0
	@ModelAttribute("categoriesLevel0")
	public Object response0() {
		String resourceUrl0 = "http://localhost:8001/customer/get-all-category-by-level/0";
		ResponseEntity<Object> response0 = restTemplate.getForEntity(resourceUrl0, Object.class);
		return response0.getBody();
	}

	// Get Category Level 1
	@ModelAttribute("categoriesLevel1")
	public Object response1() {
		String resourceUrl1 = "http://localhost:8001/customer/get-all-category-by-level/1";
		ResponseEntity<Object> response1 = restTemplate.getForEntity(resourceUrl1, Object.class);
		return response1.getBody();
	}

	// Get Category Level 2
	@ModelAttribute("categoriesLevel2")
	public Object response2() {
		String resourceUrl2 = "http://localhost:8001/customer/get-all-category-by-level/2";
		ResponseEntity<Object> response2 = restTemplate.getForEntity(resourceUrl2, Object.class);
		return response2.getBody();
	}

	// Render Category
	@GetMapping(value = "categories-list")
	public String categoryList() {
		return "admin/fragments/category/category-list";
	}

	@GetMapping(value = "categories-add")
	public String categoryAdd(@ModelAttribute("category") CategoryRequest category) {
		return "admin/fragments/category/category-add";
	}

	@PostMapping(value = "categories-add")
	public String categoryAddResult(@ModelAttribute("category") CategoryRequest category) {
		// Set header type for request header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = "http://localhost:8001/admin/create-new-category";
		ResponseEntity<Object> categoryResult = restTemplate.postForEntity(url, category, Object.class);
		return "redirect:/admin/categories-list";
	}

	/*
	 * ================================PRODUCT================================
	 */

	@GetMapping(value = "product-add")
	public String addProduct(Model model) {

		return "admin/fragments/products/products-add";
	}

	@GetMapping(value = "product-list")
	public String listProduct(Model model) {

		return "admin/fragments/products/products-list";
	}

	/*
	 * ================================BRANCH================================
	 */

	@GetMapping(value = "branch-list")
	public String listBranch(Model model) {

		String resource = "http://localhost:3000/branchs";

		ResponseEntity<Object> response = restTemplate.getForEntity(resource, Object.class);

		model.addAttribute("branchs", response.getBody());

		return "admin/fragments/branch/branch-list";
	}

	@GetMapping(value = "branch-add")
	public String addBranch(Model model) {

		return "admin/fragments/branch/branch-add";
	}

	/*
	 * ================================ORDER================================
	 */

	@GetMapping(value = "order-list")
	public String listOrder(Model model) {

		String resource = "http://localhost:3000/orders";

		ResponseEntity<Object> response = restTemplate.getForEntity(resource, Object.class);

		model.addAttribute("orders", response.getBody());
		return "admin/fragments/order/order-list";
	}

	@GetMapping(value = "order-list-member")
	public String listMemberOrder(Model model) {

		String resource = "http://localhost:3000/order-members";

		ResponseEntity<Object> response = restTemplate.getForEntity(resource, Object.class);

		model.addAttribute("orderMembers", response.getBody());
		return "admin/fragments/order/order-member-list";
	}

	@GetMapping(value = "order-add")
	public String addOrder(Model model) {

		return "admin/fragments/order/order-add";
	}

	/*
	 * ================================PROMOTION================================
	 */

	@GetMapping(value = "promotion-list")
	public String listPromotion(Model model) {
		String resource = "http://localhost:3000/promotions";

		ResponseEntity<Object> response = restTemplate.getForEntity(resource, Object.class);

		model.addAttribute("promotions", response.getBody());
		return "admin/fragments/promotion/promotion-list";
	}

	@GetMapping(value = "promotion-add")
	public String addPromotion(Model model) {

		return "admin/fragments/promotion/promotion-add";
	}

	/*
	 * ================================TRANSACTION================================
	 */

	@GetMapping(value = "transaction-list")
	public String listTransaction(Model model) {
		String resource = "http://localhost:3000/transactions";

		ResponseEntity<Object> response = restTemplate.getForEntity(resource, Object.class);

		model.addAttribute("transactions", response.getBody());
		return "admin/fragments/transaction/transaction-list";
	}

	@GetMapping(value = "transaction-add")
	public String addTransaction(Model model) {

		return "admin/fragments/transaction/transaction-add";
	}

	/*
	 * ================================MEMBER================================
	 */

	@GetMapping(value = "member-list")
	public String listMember(Model model) {
		String resource = "http://localhost:3000/members";

		ResponseEntity<Object> response = restTemplate.getForEntity(resource, Object.class);

		model.addAttribute("members", response.getBody());
		return "admin/fragments/member/member-list";
	}

	@GetMapping(value = "member-add")
	public String addMember(Model model) {

		return "admin/fragments/member/member-add";
	}

}
