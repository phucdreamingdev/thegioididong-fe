package vn.com.groupfive.tgdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

  @Autowired
  RestTemplate restTemplate;

  @RequestMapping(value = { "/", "/home", "/index" })
  public String category(Model model) {
    RestTemplate restTemplate = new RestTemplate();

    String resourceUrl0 = "http://localhost:8001/customer/get-all-category-by-level/0";
    String resourceUrl1 = "http://localhost:8001/customer/get-all-category-by-level/1";
    String resourceUrl2 = "http://localhost:8001/customer/get-all-category-by-level/2";
    String resourceProductUrl = "http://localhost:8001/customer/get-all-products";

    ResponseEntity<Object> response0 = restTemplate.getForEntity(resourceUrl0, Object.class);
    ResponseEntity<Object> response1 = restTemplate.getForEntity(resourceUrl1, Object.class);
    ResponseEntity<Object> response2 = restTemplate.getForEntity(resourceUrl2, Object.class);
    ResponseEntity<Object> productsResponse = restTemplate.getForEntity(resourceProductUrl, Object.class);

    model.addAttribute("categoriesLevel0", response0.getBody());
    model.addAttribute("categoriesLevel1", response1.getBody());
    model.addAttribute("categoriesLevel2", response2.getBody());
    model.addAttribute("products", productsResponse.getBody());

    return "layout";
  }

  @RequestMapping("/category/{id}")
  public String productList(Model model) {
    RestTemplate restTemplate = new RestTemplate();
    String resourceUrl0 = "http://localhost:8001/customer/get-all-category-by-level/0";
    String resourceUrl1 = "http://localhost:8001/customer/get-all-category-by-level/1";
    String resourceUrl2 = "http://localhost:8001/customer/get-all-category-by-level/2";
    String resourceProductUrl = "http://localhost:8001/customer/get-all-products";

    ResponseEntity<Object> response0 = restTemplate.getForEntity(resourceUrl0, Object.class);
    ResponseEntity<Object> response1 = restTemplate.getForEntity(resourceUrl1, Object.class);
    ResponseEntity<Object> response2 = restTemplate.getForEntity(resourceUrl2, Object.class);
    ResponseEntity<Object> productsResponse = restTemplate.getForEntity(resourceProductUrl, Object.class);

    model.addAttribute("categoriesLevel0", response0.getBody());
    model.addAttribute("categoriesLevel1", response1.getBody());
    model.addAttribute("categoriesLevel2", response2.getBody());
    model.addAttribute("products", productsResponse.getBody());

    return "/pages/layout-products";
  }

}
