package vn.com.groupfive.tgdd.controller;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
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

	/*
	 * =============================================
	 * GET ALL PRODUCT
	 * =============================================
	 */
	@RequestMapping(value = "/")
	public String getAllProduct(Model model) {
		String resourceProductUrl = "http://localhost:8001/customer/get-all-products-new";
		ResponseEntity<Object> productsResponse = restTemplate.getForEntity(resourceProductUrl, Object.class);
		model.addAttribute("productsVersionColors", productsResponse.getBody());
		return "fragments/all-products.html";
	}

	/*
	 * =============================================
	 * GET DETAILS OF PRODUCT
	 * =============================================
	 */
	@RequestMapping("/product-detail/{id}")
	public String productDetail(@PathVariable("id") Long id, Model model) {
		String resourceProduct = "http://localhost:8001/customer/get-product-slim-by-id" + "/" + id;
		ResponseEntity<Object> product = restTemplate.getForEntity(resourceProduct, Object.class);
		model.addAttribute("productDetails", product.getBody());
		return "fragments/product-detail";
	}

	/*
	 * =============================================
	 * GET PRODUCT BY CATEGORY
	 * =============================================
	 */
	@RequestMapping(value = "/category/{id}")
	public String getProductByCategoryId(@PathVariable("id") Long categoryId, Model model) {
		String resourceProduct = "http://localhost:8001/customer/get-all-products-by-category-id-new" + "/"
				+ categoryId;
		ResponseEntity<Object> productResponse = restTemplate.getForEntity(resourceProduct, Object.class);
		model.addAttribute("productsVersionColors", productResponse.getBody());
		return "fragments/all-products";
	}

	/*
	 * =============================================
	 * GET CATEGORY BY LEVEL 0
	 * =============================================
	 */
	@ModelAttribute("categoriesLevel0")
	public Object response0() {
		String resourceUrl0 = "http://localhost:8001/customer/get-all-category-by-level/0";
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
		String resourceUrl1 = "http://localhost:8001/customer/get-all-category-by-level/1";
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
		String resourceUrl2 = "http://localhost:8001/customer/get-all-category-by-level/2";
		ResponseEntity<Object> response2 = restTemplate.getForEntity(resourceUrl2, Object.class);
		return response2.getBody();
	}

	/*
	 * =============================================
	 * THIS ATTRIBUTE USE FOR FORMAT PRICE TO 'VNĐ'
	 * =============================================
	 */

	@ModelAttribute("priceFormatter")
	public NumberFormat formatPrice() {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		
		return currencyVN;
	}
	
	@ModelAttribute("dateFormatter")
	public SimpleDateFormat simpleDateFormat() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat;
	}
	

	@RequestMapping("/cart")
	public String cart() {
		return "fragments/cart";
	}

	@RequestMapping("/cart-empty")
	public String cartEmpty() {
		return "fragments/cart-empty";
	}

	/*
	 * =============================================
	 * CHECK SESSION WITHOUT REQUEST LOGIN
	 * =============================================
	 */
	@RequestMapping("/lich-su-mua-hang/dang-nhap")
	public String login(HttpSession session) {
		Object ob = session.getAttribute("id");
		if (ob != null) {
			return "redirect:/lich-su-don-hang";
		}
		return "fragments/login-history";
	}

	/*
	 * =============================================
	 * LOGIN BY PHONE NUMBER
	 * =============================================
	 */
	@RequestMapping(value = "/lich-su-mua-hang/dang-nhap", method = RequestMethod.POST)
	public String loginOTPRedirect(String phone, HttpSession session) {
		// Set header type for request header
//		HttpHeaders headers = new HttpHeaders();
//		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//		map.add("phone", phone);
//		session.setAttribute("phone", phone);
//		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//		String url = "http://localhost:8001/customer/sendotp";
//		restTemplate.postForEntity(url, request, String.class);
//		REMOVE AFTER COMBINE 
		return "redirect:/lich-su-mua-hang/dang-nhap/otp";
	}

	/*
	 * =============================================
	 * GET OTP PHONE NUMBER
	 * =============================================
	 */
	
	//RENDER PAGE
	@RequestMapping("/lich-su-mua-hang/dang-nhap/otp")
	public String loginOTP() {
		return "fragments/login-otp";
	}
	//POST REQUEST
	@RequestMapping(value = "/lich-su-mua-hang/dang-nhap/otp", method = RequestMethod.POST)
	public String verifyOtp(@ModelAttribute("id") Object id, String phone, String otp, HttpSession httpSession) {
//		// Set header type for request header
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//
//		map.add("phone", String.valueOf(httpSession.getAttribute("phone")));
//		map.add("otp", otp);
//
//		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//		String url = "http://localhost:8001/customer/verifyotp";
//
//		ResponseEntity<Object> response = restTemplate.postForEntity(url, request, Object.class);
//		if (response.getStatusCode() == HttpStatus.OK) {
//			httpSession.setAttribute("id", response.getBody());
//			return "redirect:/lich-su-mua-hang";
//		}
//		return "forward:/lich-su-mua-hang/dang-nhap";
		id = 1;
		httpSession.setAttribute("id", id);
		return "redirect:/lich-su-mua-hang";
	}

	/*
	 * =============================================
	 * LOGOUT MEMBER ACCOUNT
	 * =============================================
	 */
	@RequestMapping(value = "/logout")
	public String memberLogout(HttpSession session) {
		if (session.getAttribute("id") != null) {
			session.removeAttribute("id");
		}
		return "redirect:/lich-su-mua-hang/dang-nhap";
	}

	/*
	 * =============================================
	 * ORDER HISTORY
	 * =============================================
	 */
	@RequestMapping("/lich-su-mua-hang")
	public String historyProduct(HttpSession session, Model model) {
//		String id = String.valueOf(session.getAttribute("id"));
		String id = "1";
		// Get Member Info
		String url = "http://localhost:8001/admin/get-member-by-id" + "?id=" + id;
		ResponseEntity<Object> member = restTemplate.getForEntity(url, Object.class);
		model.addAttribute("member", member.getBody());

		// GET Order
		String urlOrder = "http://localhost:8001/member/get-member-order-by-member-id" + "/" + id;
		ResponseEntity<Object> memberOrder = restTemplate.getForEntity(urlOrder, Object.class);
		model.addAttribute("memberOrders", memberOrder.getBody());

		return "fragments/history-products";
	}

	/*
	 * =============================================
	 * GET ORDER DETAILS
	 * =============================================
	 */
	@RequestMapping("/lich-su-mua-hang/don-hang/{id}")
	public String orderDetail(@PathVariable("id") Long id, Model model) {
		//String id = "1";
		
		String resourceProductUrl1 = "http://localhost:8001/admin/get-member-by-id?id=1";
//		String resourceProductUrl1 = "http://localhost:8001/admin/get-member-by-id" + "/" + id;
		ResponseEntity<Object> productsResponse1 = restTemplate.getForEntity(resourceProductUrl1, Object.class);
		model.addAttribute("member", productsResponse1.getBody());
		
//		String urlOrder = "http://localhost:8001/member/get-member-order-by-member-id" + "/" + id;
//		ResponseEntity<Object> memberOrder = restTemplate.getForEntity(urlOrder, Object.class);
//		model.addAttribute("memberOrders", memberOrder.getBody());
		
		String resourceProductUrl = "http://localhost:8001/member/get-order-detail-by-member-order-id" + "/" + id;
		ResponseEntity<Object> orderDetail = restTemplate.getForEntity(resourceProductUrl, Object.class);
		model.addAttribute("orderDetails", orderDetail.getBody());
		return "fragments/order-detail";
	}
	
	

	/*
	 * =============================================
	 * GET INFORMATION PROFILES
	 * =============================================
	 */
	@RequestMapping("/lich-su-mua-hang/thong-tin-ca-nhan")
	public String profile(Model model, HttpSession session) {
		String resourceProductUrl1 = "http://localhost:8001/admin/get-member-by-id?id=1";
//		String resourceProductUrl1 = "http://localhost:8001/admin/get-member-by-id" + "/" + id;
		ResponseEntity<Object> productsResponse1 = restTemplate.getForEntity(resourceProductUrl1, Object.class);
		model.addAttribute("member", productsResponse1.getBody());
		String resourceProductUrl = "http://localhost:8001/member/get-member-address-by-member-id/1";
//		String resourceProductUrl = "http://localhost:8001/member/get-member-address-by-member-id" + "/" + id;
		ResponseEntity<Object> memberAddresses = restTemplate.getForEntity(resourceProductUrl, Object.class);
		model.addAttribute("profileMember", memberAddresses.getBody());

		return "fragments/profile";
	}

}
