package com.ootd.ootdApp.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class orderController {
	
	@RequestMapping("/order/order.or")
	public String orderProduct() {
	
		return "order/order";
	}
	
	@RequestMapping("/order/paymentSuccess.or")
	public String paymentSuccess() {
	
		return "order/paymentSuccess";
	}
	
	
	
}
