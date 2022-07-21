package vn.com.groupfive.tgdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/")
	public String category(Model model) {
		String resourceProductUrl = "http://localhost:8001/customer/get-all-products";
		ResponseEntity<Object> productsResponse = restTemplate.getForEntity(resourceProductUrl, Object.class);
		model.addAttribute("products", productsResponse.getBody());
		return "fragments/all-products";
	}

	@ModelAttribute("categoriesLevel0")
	public Object response0() {
		String resourceUrl0 = "http://localhost:8001/customer/get-all-category-by-level/0";
		ResponseEntity<Object> response0 = restTemplate.getForEntity(resourceUrl0, Object.class);
		return response0.getBody();
	}

	@ModelAttribute("categoriesLevel1")
	public Object response1() {
		String resourceUrl1 = "http://localhost:8001/customer/get-all-category-by-level/1";
		ResponseEntity<Object> response1 = restTemplate.getForEntity(resourceUrl1, Object.class);
		return response1.getBody();
	}

	@ModelAttribute("categoriesLevel2")
	public Object response2() {
		String resourceUrl2 = "http://localhost:8001/customer/get-all-category-by-level/2";
		ResponseEntity<Object> response2 = restTemplate.getForEntity(resourceUrl2, Object.class);
		return response2.getBody();
	}

	@RequestMapping("/cart")
	public String cart() {
		return "fragments/cart";
	}

	@RequestMapping("/cart-empty")
	public String cartEmpty() {
		return "fragments/cart-empty";
	}

	@RequestMapping("/detail")
	public String detail() {
		return "fragments/product-detail";
	}

	@RequestMapping("/lich-su-don-hang/dang-nhap")
	public String login() {
		return "fragments/login-history";
	}

	@RequestMapping("/lich-su-don-hang")
	public String historyProduct() {
		return "fragments/history-products";
	}

	@RequestMapping("/lich-su-don-hang/thong-tin-ca-nhan")
	public String profile() {
		return "fragments/profile";
	}

}
