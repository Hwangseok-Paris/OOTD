package com.ootd.ootdApp.myPage.senondHand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ootd.ootdApp.member.model.vo.Member;

@SessionAttributes({"member"})
@Controller
public class secondHandConrtoller {
	
	//Order_Detail 모달 (주문번호클릭시)
	//Info 회원정보
	//Product 상품목록 (중고상품 올린 페이지)
	//Purchased 주문상품(구매완료)
	//Sale 판매한 상품
	//Review Sale페이지에서 구매한 상품 리뷰 작성하기
	
	//@Autowired
	//com.ootd.ootdApp.myPage.senondHand.model.service.secondHandService secondHandService;
	
//	@Autowired
//	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping("/myPage/myPage_Info.mp")
	public String myPageOrder() {
		return "myPage/myPage_Info";
	}
	
	@RequestMapping("/myPage/myPage_Purchased.mp")
	public String myPagePurchased() {
		return "myPage/myPage_Purchased";
	}
	
	@RequestMapping("/myPage/myPage_Product.mp")
	public String myPageProduct() {
		return "myPage/myPage_Product";
	}
	
	@RequestMapping("/myPage/myPage_Sale.mp")
	public String myPageSale() {
		return "myPage/myPage_Sale";
	}
	
	@RequestMapping("/myPage/update_Eamil.do")
	public String search_User() {
		return "";
	}
	
	@RequestMapping("/myPage/update_Password.do")
	public String update_Password(@RequestParam(value="password") String password,
							@RequestParam(value="new_password") String new_password,
							@RequestParam(value="confirm_p	assword") String confirm_password,
							Member member,
							Model model) {
		
		String name = "홍사장";
		
		System.out.println("기존 비밀번호 : " + password + ", 변경할 비밀번호 : " + new_password + "," + confirm_password);
		
		//Member search_Member = secondHandService.selectOneMember(name);
		
		String member_pw = member.getMember_pw();
		
//		if(search_Member != null) {
//			if(bcryptPasswordEncoder.matches(member_pw, password) && new_password == confirm_password) {
//				model.addAttribute("member", search_Member);
//			}
//		} else {
//			System.out.println("로그인부터 하세요");
//		}
		
		return "";
	}
	
	
}
