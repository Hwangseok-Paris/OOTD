package com.ootd.ootdApp.myPage.senondHand.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ootd.ootdApp.member.model.vo.Member;
import com.ootd.ootdApp.myPage.senondHand.model.service.SecondHandService;
import com.ootd.ootdApp.myPage.brand.model.vo.O_Order;
import com.ootd.ootdApp.myPage.senondHand.model.vo.Product;
import com.ootd.ootdApp.myPage.senondHand.model.vo.Review_ProductInfo;
import com.ootd.ootdApp.myPage.senondHand.model.vo.myPageOrderList;
import com.ootd.ootdApp.product.model.vo.Review;

@SessionAttributes({"member"})
@Controller
public class SecondHandConrtoller {
	
	//Order_Detail 모달 (주문번호클릭시)
	//Info 회원정보
	//Product 상품목록 (중고상품 올린 페이지)
	//Purchased 주문상품(구매완료)
	//Sale 판매한 상품
	//Review Sale페이지에서 구매한 상품 리뷰 작성하기
	
	//O_ORDER , O_ORDER_LIST 는 무조건 결제가 된 상품들
	
	@Autowired
	SecondHandService secondHandService;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping("/myPage/myPage_Info.mp")
	public String myPage_Info() {
		return "myPage/myPage_Info";
	}
	
	//비밀번호 변경
	@RequestMapping("/myPage/update_Password.do")
	public String update_Password(@RequestParam(value="password") String password,
							@RequestParam(value="new_password") String new_password,
							@RequestParam(value="confirm_password") String confirm_password,
							Member member,
							Model model) {
		
		System.out.println("로그인 된 회원 / 비밀번호 : " + member.getMember_id() + " / " + member.getMember_pw());
		
		if (!new_password.equals(confirm_password))	{
			System.out.println("new password not equals");
			return "redirect:myPage_Info.mp";
		}
		if (!bcryptPasswordEncoder.matches(password, member.getMember_pw())) {
			System.out.println("not equals current password");
			return "redirect:myPage_Info.mp";
		}
		
		member.setMember_pw(bcryptPasswordEncoder.encode(new_password));
		
		int result = secondHandService.updatePassword(member);
		
		if (result > 0) {
			model.addAttribute("member", member);
			System.out.println("비밀번호 변경 완료 -> " + member.getMember_pw());
		}
		
		return "redirect:myPage_Info.mp";
	}
	
	//이메일 변경
	@RequestMapping("/myPage/update_Email.do")
	public String update_Email(@RequestParam(value="update_email") String update_email, Member member, Model model) {
		
		System.out.println("current email -> " + member.getEmail());

		if (update_email == null) {
			System.out.println("Email Null");
			return "redirect:myPage_Info.mp";
		}
		
		if (member.getEmail().equals(update_email)) {
			System.out.println("same email");
			return "redirect:myPage_Info.mp";
		}
		
		member.setEmail(update_email);
		
		int result = secondHandService.updateEamil(member);
		
		if (result > 0) {
			model.addAttribute("member", member);
			System.out.println("change email -> " + member.getEmail());
		}
		
		return "redirect:myPage_Info.mp";
	}
	
	//전화번호 변경
	@RequestMapping("/myPage/update_Phone.do")
	public String update_Phone(@RequestParam(value="update_phone") String update_phone, Member member, Model model) {
		
		System.out.println("변경할 핸드폰 번호 :: " + member.getPhone());

		if (update_phone == null) { 
			System.out.println("Phone number Null");
			return "redirect:myPage_Info.mp";
		}
		
		if (member.getPhone().equals(update_phone)) {
			System.out.println("same Phone number");
			return "redirect:myPage_Info.mp";
		}
		
		
		member.setPhone(update_phone);
		
		int result = secondHandService.updatePhone(member);
		
		if (result > 0) {
			model.addAttribute(member);
			System.out.println("change Phone number -> " + member.getPhone());
		}
		
		return "redirect:myPage_Info.mp";
	}
	
	//주소변경
	@RequestMapping("/myPage/updateAddress.do")
	public String updateAddress(@RequestParam(value="update_address") String address, @RequestParam(value="update_detail_address") String detailAddress, Member member, Model model) {
		
		System.out.println(address + " / " + detailAddress);
		
		String[] newAddress = {address + " " + detailAddress};
		
		member.setAddress(newAddress);
		
		int result = secondHandService.updateAddress(member);
		
		if(result > 0) {
			model.addAttribute(member);
			
			for( int i = 0; i < newAddress.length; i++) {
				
				System.out.println(newAddress[i]);
				
			}
		}
		
		return "redirect:myPage_Info.mp";
	}
	
	//계좌번호 변경
	@RequestMapping("/myPage/updateBank.do")
	public String updateBank(@RequestParam(value="account") String accountNumber,@RequestParam(value="bank_name") String bank_code, Member member, Model model) {
		
		System.out.println(bank_code); // 변경할 은행 코드
		System.out.println(accountNumber); // 변경할 계좌번호
		
		member.setAccount_number(accountNumber);
		member.setBank_code(bank_code);
		
		int result = secondHandService.updateBank(member);
		
		if(result > 0) {
			model.addAttribute(member);
			System.out.println("change Bank_code / Bank_accout -> " + member.getBank_code() + " / " + member.getAccount_number() );
		}
		
		return "redirect:myPage_Info.mp";
	}
	
	//주문 상품 가져오기
	@RequestMapping("/myPage/myPage_Purchased.mp")
	public List<myPageOrderList> selectOrderList(Member member, Model model) {
		
		String member_name = member.getMember_name();
		
		System.out.println(member_name);
		
		List<myPageOrderList> list = secondHandService.selectOrderList(member_name);
		
		model.addAttribute("list", list);
		
		System.out.println("주문상품 리스트 -> " + list);
		
		return list;
	}
	
	//판매상품 리스트 가져오기
	@RequestMapping("/myPage/myPage_Product.mp")
	public List<Product> myPageProduct(Member member, Model model) {
		
		int member_no = member.getMember_no();
		
		System.out.println(member_no);
		
		List<Product> list = secondHandService.selectProductList(member_no);
		
		model.addAttribute("list", list);
		
		System.out.println("판매상품 리스트 -> " + list);
		
		return list;
	}
 	
	//판매상품 삭제
	@RequestMapping("/myPage/myPage_Product_Delete")
	public String myPageProductDelete(@RequestParam int productNo, Model model) {
		
		System.out.println(productNo);
		
		int result = secondHandService.deleteProduct(productNo);
		
		return "myPage/myPage_Product";
	}

	//판매내역 가져오기
	@RequestMapping("/myPage/myPage_Sale.mp")
	public String myPageSaleProductList(Member member, Model model) {
		
		String member_name = member.getMember_name();
		
		System.out.println("판매자 이름 -> " + member_name);
		
		List<myPageOrderList> list = secondHandService.selectSaleProductList(member_name);
		
		System.out.println("판매내역 리스트 -> " + list + "\n");
		
		model.addAttribute("list", list);
		
		return "myPage/myPage_Sale";
	}
	
	@RequestMapping("/myPage/orderStatusChange.do")
	@ResponseBody
	public int OrderStatuschange(@RequestParam int orderNo) {
		
		System.out.println("주문 상태 바꿀 주문번호 -> " + orderNo);
		
		int result = secondHandService.updateOrderSaleStatus(orderNo);
		
		int order_status = 0;
		
		if(result > 0) {
			order_status = 2;
		}
		
		return order_status;
	}
	
	@RequestMapping("/myPage/purchaseStatusChange.do")
	@ResponseBody
	public int purchaseStatusChange(@RequestParam int orderNo) {
		
		int result = secondHandService.updatePurchaseStatus(orderNo);
		
		System.out.println("현재 배송상태 -> " + orderNo);
		
		int order_status = 0;
		
		if(result > 0) {
			order_status = 3;
		}
		
		return order_status;
	}
	

	@RequestMapping("/myPage/myPage_Review.mp")
	public String myPageReview(@RequestParam int pno, @RequestParam int mno, Model model) {
		
		System.out.println("Review Controller access");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("product_no", pno);
		map.put("member_no", mno);
		
		System.out.println("service에 전달할 map : " + map);
		
		Review_ProductInfo info = secondHandService.selectReviewInfo(map);
		
		model.addAttribute("info", info);
		
		return "myPage/myPage_Review";
	}
	
	@RequestMapping("/myPage/reviewEnroll.mp")
	public String reviewEnroll(
				Review review,
				Model model
			) {
		
		System.out.println("review 등록 controller 접근 : " + review);
		
		String msg = "";
		
		int result = secondHandService.insertReview(review);
		
		if ( result > 0 ) {
			msg = "리뷰가 성공적으로 등록되었습니다.";
		} else {
			msg = "리뷰 등록에 실패하였습니다.";
		}
		
		return "common/msg";
	}

}
