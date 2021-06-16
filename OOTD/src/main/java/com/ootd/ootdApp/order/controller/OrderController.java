package com.ootd.ootdApp.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ootd.ootdApp.order.model.service.OrderService;
import com.ootd.ootdApp.order.model.vo.Cart;


@Controller
public class OrderController {
	
	
	@Autowired
	OrderService orderService;
	
	// =========== 카트 영역 =============== //
	
	// 장바구니 리스트 불러오기
	@RequestMapping("/order/cart.or")
	public String cartList(Model model
			) {
		
		int member_no = 1;
		
		List<Cart> cart = orderService.selectCartList(member_no);

		//System.out.println(cart);
		
		model.addAttribute("cart", cart);
				
		return "/order/cart";
	}
	
	@RequestMapping("/order/deleteProduct.or")
	public String deleteProduct(@RequestParam int cart_no) {
		

		
		return "/order/cart";
		
	}
	
	
	// =========== 카트 영역 =============== //
	
	
	
	
		
	// 주문 페이지 영역
	@RequestMapping("/order/order.or")
	public String orderProduct() {
	
		return "order/order";
	}
	
	
		
	// 결제 완료 페이지 영역
	@RequestMapping("/order/paymentSuccess.or")
	public String paymentSuccess() {
	
		return "order/paymentSuccess";
	}
	
}
