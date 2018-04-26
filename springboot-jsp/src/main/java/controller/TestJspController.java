package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestJspController {
	@RequestMapping("/index.do")
	public String jspIndex(){
		return "index";
	}
}
