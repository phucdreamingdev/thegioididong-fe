package vn.com.groupfive.tgdd.controller;

import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

	@Autowired
	RestTemplate restTemplate;

	// Get All Products
	@RequestMapping(value = "/")
	public String getAllProduct(Model model) {
		String resourceProductUrl = "http://localhost:8001/customer/get-all-products-new";
		ResponseEntity<Object> productsResponse = restTemplate.getForEntity(resourceProductUrl, Object.class);
		model.addAttribute("productsVersionColors", productsResponse.getBody());
		return "fragments/all-products";
	}

	// Get Product By Caterogy
	@RequestMapping(value = "/category/{id}")
	public String getProductByCategoryId(@PathVariable("id") Long categoryId, Model model) {
		String resourceProduct = "http://localhost:8001/customer/get-all-products-by-category-id-new" + "/"
				+ categoryId;
		ResponseEntity<Object> productResponse = restTemplate.getForEntity(resourceProduct, Object.class);
		model.addAttribute("productsVersionColors", productResponse.getBody());
		return "fragments/all-products";
	}

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

	// This attribute use for format price in VNĐ
	@ModelAttribute("priceFormatter")
	public NumberFormat formatPrice() {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		return currencyVN;
	}

	@RequestMapping("/cart")
	public String cart() {
		return "fragments/cart";
	}

	@RequestMapping("/cart-empty")
	public String cartEmpty() {
		return "fragments/cart-empty";
	}

	@RequestMapping("/lich-su-mua-hang/dang-nhap")
	public String login() {
		return "fragments/login-history";
	}

	// Login by Phone Number
	@RequestMapping(value = "/lich-su-mua-hang/dang-nhap", method = RequestMethod.POST)
	public String loginOTPRedirect(String phone, HttpSession session) {
		// Set header type for request header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("phone", phone);
		session.setAttribute("phone", phone);
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		String url = "http://localhost:8001/customer/sendotp";
		restTemplate.postForEntity(url, request, String.class);
		return "redirect:/lich-su-mua-hang/dang-nhap/otp";
	}

	// Get OTP phone number
	@RequestMapping(value = "/lich-su-mua-hang/dang-nhap/otp", method = RequestMethod.POST)
	public String verifyOtp(@RequestParam(name = "phone", required = false) String phone,
			@RequestParam(name = "otp", required = false) String otp, HttpSession httpSession) {
		// Set header type for request header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

		map.add("phone", String.valueOf(httpSession.getAttribute("phone")));
		map.add("otp", otp);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		String url = "http://localhost:8001/customer/verifyotp";

		ResponseEntity<Object> response = restTemplate.postForEntity(url, request, Object.class);
		if (response.getStatusCode() == HttpStatus.OK) {
			return "redirect:/lich-su-mua-hang";
		}
		return "forward:/lich-su-mua-hang/dang-nhap";
	}

	// @RequestMapping("/lich-su-mua-hang/dang-nhap/otp")
	// public String loginOTP() {
	// return "fragments/login-otp";
	// }

	@RequestMapping(value = "/lich-su-mua-hang/{id}")
	public String historyProduct(@PathVariable("id") Long id, Model model) {
		String resourceProductUrl = "http://localhost:8001/member/get-member-order-by-member-id" + "/" + id;
		ResponseEntity<Object> productsResponse = restTemplate.getForEntity(resourceProductUrl, Object.class);
		model.addAttribute("historyProducts", productsResponse.getBody());
		return "fragments/history-products";
	}

	@RequestMapping("/lich-su-mua-hang/don-hang/{id}")
	public String orderDetail(@PathVariable("id") Long id, Model model) {
		String resourceProductUrl = "http://localhost:8001/member/get-order-detail-by-member-order-id" + "/" + id;
		ResponseEntity<Object> orderDetail = restTemplate.getForEntity(resourceProductUrl, Object.class);
		model.addAttribute("orderDetails", orderDetail.getBody());
		return "fragments/order-detail";
	}

	// @RequestMapping("/lich-su-mua-hang")
	// public String historyProduct() {
	// return "fragments/history-products";
	// }

	@RequestMapping("/lich-su-mua-hang/thong-tin-ca-nhan")
	public String profile() {
		return "fragments/profile";
	}

	// Get Product Details
	@RequestMapping("/product-detail/{id}")
	public String productDetail(@PathVariable("id") Long id, Model model) {
		String resourceProduct = "http://localhost:8001/customer/get-product-slim-by-id" + "/" + id;
		ResponseEntity<Object> product = restTemplate.getForEntity(resourceProduct, Object.class);
		model.addAttribute("productDetails", product.getBody());
		return "fragments/product-detail";
	}

}
