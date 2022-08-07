package vn.com.groupfive.tgdd.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.groupfive.tgdd.payload.request.CategoryRequest;
import vn.com.groupfive.tgdd.payload.request.ProductCreateRequest;
import vn.com.groupfive.tgdd.payload.request.PromotionRequest;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

	private final String CATE_LOGO_DIR = "src\\main\\resources\\static\\images\\category-logo\\";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	HttpSession session;

	/*
	 * =============================================
	 * DASHBOARD ADMIN PAGE
	 * =============================================
	 */
	@GetMapping(value = "dashboard")
	public String adminHome(Model model) {
		return "admin/fragments/dashboard";
	}

	/*
	 * ================================CATEGORY================================
	 */

	/*
	 * =============================================
	 * GET CATEGORY BY LEVEL 0
	 * =============================================
	 */
	@ModelAttribute("categoriesLevel0")
	public Object response0() {
		String resourceUrl0 = "http://localhost:8001/admin/get-all-category-by-level/0";
		ResponseEntity<Object> response0 = restTemplate.getForEntity(resourceUrl0, Object.class);
		return response0.getBody();
	}

	/*
	 * =============================================
	 * GET CATEGORY BY LEVEL 1
	 * =============================================
	 */
	@ModelAttribute("categoriesLevel1")
	public Object response1() {
		String resourceUrl1 = "http://localhost:8001/admin/get-all-category-by-level/1";
		ResponseEntity<Object> response1 = restTemplate.getForEntity(resourceUrl1, Object.class);
		return response1.getBody();
	}

	/*
	 * =============================================
	 * GET CATEGORY BY LEVEL 2
	 * =============================================
	 */
	@ModelAttribute("categoriesLevel2")
	public Object response2() {
		String resourceUrl2 = "http://localhost:8001/admin/get-all-category-by-level/2";
		ResponseEntity<Object> response2 = restTemplate.getForEntity(resourceUrl2, Object.class);
		return response2.getBody();
	}

	/*
	 * =============================================
	 * CATEGORY LIST PAGE
	 * =============================================
	 */
	@GetMapping(value = "categories-list")
	public String categoryList() {
		return "admin/fragments/category/category-list";
	}

	/*
	 * =============================================
	 * CATEGORY ADD PAGE
	 * =============================================
	 */
	@GetMapping(value = "categories-add")
	public String categoryAdd(@ModelAttribute("category") CategoryRequest category) {
		return "admin/fragments/category/category-add";
	}

	/*
	 * =============================================
	 * CATEGORY ADD FUNCTIONS
	 * =============================================
	 */
	@PostMapping(value = "categories-add")
	public String categoryAddResult(@ModelAttribute("category") CategoryRequest category,
			@RequestParam(name = "logoURL", required = false) MultipartFile logoURL,
			RedirectAttributes redirectAttributes) throws IOException {
		// Check logo null
		if (!logoURL.isEmpty()) {
			String fileName = StringUtils.cleanPath(logoURL.getOriginalFilename());

			// save the file on the local file system
			Path path = Paths.get(CATE_LOGO_DIR + fileName);
			Files.copy(logoURL.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			category.setLogo("/images/category-logo/" + logoURL.getOriginalFilename());

		}
		// Set header type for request header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = "http://localhost:8001/admin/create-new-category";
		ResponseEntity<Object> categoryResult = restTemplate.postForEntity(url, category, Object.class);
		if (categoryResult.getStatusCode() == HttpStatus.OK) {
			redirectAttributes.addFlashAttribute("messages", "Successfully added..");
			return "redirect:/admin/categories-list";
		}
		return "redirect:/admin/categories-list";
	}

	/*
	 * ================================PRODUCT================================
	 */

	@GetMapping(value = "product-add")
	public String addProduct(@ModelAttribute("product") ProductCreateRequest product,
			RedirectAttributes redirectAttributes) {
		// Set header type for request header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = "http://localhost:8001/admin/create-new-product";
		ResponseEntity<Object> categoryResult = restTemplate.postForEntity(url, product, Object.class);
		if (categoryResult.getStatusCode() == HttpStatus.OK) {
			redirectAttributes.addFlashAttribute("messages", "Successfully added..");
			return "redirect:/admin/categories-list";
		}
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
		String resource = "http://localhost:8001/admin/get-all-branch";
		ResponseEntity<Object> response = restTemplate.getForEntity(resource, Object.class);
		model.addAttribute("branchsList", response.getBody());

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
		String resource = "http://localhost:8001/admin/get-all-order";
		ResponseEntity<Object> response = restTemplate.getForEntity(resource, Object.class);
		model.addAttribute("ordersLists", response.getBody());
		return "admin/fragments/order/order-list";
	}

	@GetMapping(value = "order-members-list")
	public String listMemberOrder(Model model) {
		String resource = "http://localhost:3000/order-members";
		ResponseEntity<Object> response = restTemplate.getForEntity(resource, Object.class);
		model.addAttribute("orderMembers", response.getBody());
		return "admin/fragments/order/order-member-list";
	}

	/*
	 * ================================PROMOTION================================
	 */

	@GetMapping(value = "promotion-list")
	public String listPromotion(Model model) {
		String resource = "http://localhost:8001/admin/get-all-promotion";
		ResponseEntity<Object> response = restTemplate.getForEntity(resource, Object.class);
		model.addAttribute("promotionsList", response.getBody());
		return "admin/fragments/promotion/promotion-list";
	}

	@GetMapping(value = "promotion-add")
	public String addPromotion(Model model) {
		return "admin/fragments/promotion/promotion-add";
	}

	@PostMapping(value = "promotion-add")
	public String promotionAddResult(@ModelAttribute("promotion") PromotionRequest promotion) {
		// Set header type for request header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = "http://localhost:8001/admin/create-new-promotion";
		ResponseEntity<Object> promotionResult = restTemplate.postForEntity(url, promotion, Object.class);
		if (promotionResult.getStatusCode() == HttpStatus.OK) {
			return "redirect:/admin/promotion-list";
		}
		return "redirect:/admin/promotion-list";
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
		String resource = "http://localhost:8001/admin/get-all-member";
		ResponseEntity<Object> response = restTemplate.getForEntity(resource, Object.class);
		model.addAttribute("members", response.getBody());
		return "admin/fragments/member/member-list";
	}

	/*
	 * =============================================
	 * THIS FUNCTIONS USE FOR FORMAT PRICE TO 'VNĐ'
	 * =============================================
	 */
	@ModelAttribute("priceFormatter")
	public NumberFormat formatPrice() {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		return currencyVN;
	}

}
