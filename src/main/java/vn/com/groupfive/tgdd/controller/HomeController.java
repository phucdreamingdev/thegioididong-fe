package vn.com.groupfive.tgdd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({ "/", "/home", "/index" })
	public String home() {
		return "index";
	}

	@GetMapping("/dtdd")
	public String phonePage() {
		return "pages/category/dtdd";
	}

	@GetMapping("/laptop-ldp")
	public String laptopPage() {
		return "pages/category/laptop-ldp";
	}

	@GetMapping("/may-tinh-bang")
	public String tabletPage() {
		return "pages/category/tablet";
	}

	@GetMapping("/phu-kien")
	public String phukienPage() {
		return "pages/category/phu-kien";
	}

	@GetMapping("/dong-ho-thong-minh-ldp")
	public String smartWatchPage() {
		return "pages/category/dong-ho-thong-minh";
	}

	@GetMapping("/dong-ho")
	public String watchPage() {
		return "pages/category/dong-ho";
	}

	@GetMapping("/pc-may-in")
	public String pcmayinPage() {
		return "pages/category/pc-may-in";
	}

	@GetMapping("/may-doi-tra")
	public String maydoitraPage() {
		return "pages/may-doi-tra";
	}
}
