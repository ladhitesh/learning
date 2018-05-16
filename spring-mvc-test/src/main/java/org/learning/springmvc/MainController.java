package org.learning.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

	@RequestMapping("/hello")
	public String sayHello(){
		return "Hello";
	}
	
	@RequestMapping("/message")
	@ResponseBody
	public Message sayMessage(){
		return new Message();
	}
	
	
}
