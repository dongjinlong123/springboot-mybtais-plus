package com.djl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DispatcherController {
	@RequestMapping("/testPage")
	public String getPage() {
		return "/500";
	}
}
