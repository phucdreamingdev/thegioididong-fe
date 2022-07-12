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
  public String index(Model model) {
    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "http://localhost:8001/customer/get-all-category";
    ResponseEntity<Object> response = restTemplate.getForEntity(fooResourceUrl, Object.class);
    model.addAttribute("categories", response.getBody());
    return "index";
  }

}
