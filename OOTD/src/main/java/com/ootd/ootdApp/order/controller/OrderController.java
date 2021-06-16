package com.ootd.ootdApp.order.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ootd.ootdApp.member.model.vo.Member;
import com.ootd.ootdApp.order.model.service.OrderService;
import com.ootd.ootdApp.order.model.vo.Cart;


@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	 
	
	// =========== 카트 영역 =============== //
	
	// 장바구니 리스트 불러오기
	@RequestMapping("/order/cart.or")
	public String cartList(Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("member");
		
		int member_no = member.getMember_no();
		
		List<Cart> cart = orderService.selectCartList(member_no);

//		System.out.println(cart);
		
		model.addAttribute("cart", cart);
				
		return "/order/cart";
	}
	
	@RequestMapping("/order/deleteCartProduct.or")
	public String deleteCartProduct(@RequestParam int cart_no) {

		int result = orderService.deleteCartProduct(cart_no);
	
		if(result>0) {
			System.out.println("상품 삭제 성공");

		} else {
			System.out.println("상품 삭제 실패");
		}
		

		// cartList(model, req);
		
		return "redirect:/order/cart.or";
	}
	
	// 선택 항목 삭제
	@RequestMapping("/order/deleteCartProductList.or")
	public String deleteCartProductList(@RequestParam(value="selchk") List<Integer> selchk) {
		
		// jsp 에서 배열 넘어오는거 확인
		// System.out.println(selchk);
		
		int cart_no = 0;
		
		// 반복문으로 selchk 배열에 담긴 상품번호를 반복문을 통해 하나씩 삭제
		for(int no : selchk) {
			cart_no = no;
			int result = orderService.deleteCartProduct(cart_no);
			
			if(result>0) {
				System.out.println("카트번호 " + no +"번 상품 삭제 성공");
			} else {
				System.out.println("카트번호 " + no +"번 상품 삭제 성공");
			}
		}		
		
		return "redirect:/order/cart.or";
	}
	
	// 전체 항목 삭제
	@RequestMapping("/order/deleteCartProductAll.or")
	public String deleteCartProductAll(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("member");
		
		int member_no = member.getMember_no();
		
		int result = orderService.deleteCartproductAll(member_no);
		
		return "redirect:/order/cart.or";
	}
	
//  ajax 통신 시도
//	@RequestMapping("/order/deleteCartProduct.or")
//	public void deleteCartProduct(
//			@RequestParam int cart_no, Model model, HttpServletRequest req) {
//
//		System.out.println(cart_no + "번 장바구니 데이터 삭제");
//		
//		int result = orderService.deleteCartProduct(cart_no);
//
//		if(result>0) {
//			System.out.println("삭제 성공");
//			cartList(model, req);
//		} else {
//			System.out.println("삭제 실패");
//		}
//
//
//	}
	
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
