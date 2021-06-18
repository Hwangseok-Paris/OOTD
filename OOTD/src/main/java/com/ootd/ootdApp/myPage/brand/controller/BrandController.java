package com.ootd.ootdApp.myPage.brand.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ootd.ootdApp.member.model.service.MemberService;
import com.ootd.ootdApp.member.model.vo.Member;
import com.ootd.ootdApp.myPage.brand.model.service.BrandService;
import com.ootd.ootdApp.myPage.brand.model.vo.MypageOrderList;
import com.ootd.ootdApp.product.model.vo.Product;

@SessionAttributes({ "member" })
@Controller
public class BrandController {

	@Autowired
	BrandService brandService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder bcrypt;

	// 마이페이지 - 회원(업체) 정보 수정
	@RequestMapping("myPage/myPage_Brand_Info.mp")
	public void myPage_Brand_Info() {

	}

	// 마이페이지 - 회원(업체) 정보 수정
	// 1. 비밀번호 변경
	@RequestMapping("myPage/myPage_Brand_Info_pwUpdate.mp")
	public String myPage_Brand_Info_Update(@RequestParam String password, // 현재 비밀번호 입력
										   @RequestParam String new_password, // 새롭게 입력한 비밀번호				   
										   Member member, Model model) {

		/*
		 * String a = member.getMember_id(); System.out.println(a); // ekdls123
		 * 
		 * int b = member.getMember_no(); System.out.println(b); // 16
		 * System.out.println(password); // 123 System.out.println(new_password); // 123
		 * System.out.println(new_password_confirm); // 123
		 */
		  
		  // 우선 
		  Member result1 = memberService.selectOneMember(member.getMember_id());

		  // 현재 입력한 비밀번호와 db에서 꺼내온 비밀번호가 일치한다면
		  if(bcrypt.matches(password, result1.getMember_pw())) { 
		  
			  String encryptPassword = bcrypt.encode(new_password);
		
			  int member_no = member.getMember_no(); 
		  
			  Member tempMember = new Member();
		  
			  tempMember.setMember_no(member_no);
			  tempMember.setMember_pw(encryptPassword);
		  
			  int result2 = brandService.updateBrandInfo(tempMember);
		  
				  if( result2 > 0) {
					  System.out.println("비밀번호 수정 완료!"); 
					  model.addAttribute("member", member);
					  return "myPage/myPage_Brand_Info";
					  
				  } else {
				  
				  System.out.println("비밀번호 수정 실패!"); 
				  return "myPage/myPage_Brand_Info"; 
				  }
		  
		}
		  else {
		  System.out.println("현재 비밀번호가 일치하지 않습니다. / db의 비밀번호와 입력한 비밀번호가 불일치");
		  return "myPage/myPage_Brand_Info"; 
		  }
		  
	}

		  
		 
		

	// 2. 이메일 변경
	@RequestMapping("myPage/myPage_Brand_Info_emUpdate.mp")
	public String myPage_Brand_Info_emUpdate(@RequestParam String email, Member member, Model model) {
		
		int member_no = member.getMember_no();
		
		Member tempMember = new Member();
		
		tempMember.setMember_no(member_no);
		tempMember.setEmail(email);
		
		int result = brandService.emUpdateBrandInfo(tempMember);
		
		if( result > 0) {
			  System.out.println("이메일 변경 완료!"); 
			  model.addAttribute("member", member);
			  return "myPage/myPage_Brand_Info";
			  
		  } else {
		  
		  System.out.println("이메일 변경 실패!"); 
		  return "myPage/myPage_Brand_Info"; 
		  }
		
		
	}
	
	// 3. 전화번호 변경
	@RequestMapping("myPage/myPage_Brand_Info_phUpdate")
	public String myPage_Brand_Info_phUpdate(@RequestParam String phone, Member member, Model model) {
		
		int member_no = member.getMember_no();
		
		Member tempMember = new Member();
		
		tempMember.setMember_no(member_no);
		tempMember.setPhone(phone);
		
		System.out.println(phone);
		
		int result = brandService.phUpdateBrandInfo(tempMember);
		
		if( result > 0) {
			  System.out.println("전화번호 변경 완료!"); 
			  model.addAttribute("member", member);
			  return "myPage/myPage_Brand_Info";
			  
		  } else {
		  
		  System.out.println("전화번호 변경 실패!"); 
		  return "myPage/myPage_Brand_Info"; 
		  }
	}
	
	// 4. 계좌 변경
	@RequestMapping("myPage/myPage_Brand_Info_accountUpdate.mp")
	public String myPage_Brand_Info_accountUpdate(@RequestParam String account_number, Member member, Model model) {
		
		int member_no = member.getMember_no();
		String bank_code = member.getBank_code();
		System.out.println(bank_code);
		
		Member tempMember = new Member();
		
		tempMember.setMember_no(member_no);
		tempMember.setAccount_number(account_number);
		
		System.out.println(account_number);
		
		int result = brandService.acUpdateBrandInfo(tempMember);
		
		if( result > 0) {
			  System.out.println("계좌 변경 완료!"); 
			  model.addAttribute("member", member);
			  return "myPage/myPage_Brand_Info";
			  
		  } else {
		  
		  System.out.println("계좌 변경 실패!"); 
		  return "myPage/myPage_Brand_Info"; 
		  }
	}
	
	// 등록 상품 - 업체가 등록한 상품 리스트
	@RequestMapping("myPage/myPage_Brand_Product.mp")
	public String myPage_Brand_Product(Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("member");
		int member_no = member.getMember_no();
		System.out.println(member_no);	

		List<Product> list = brandService.selectBrandProductList(member_no);
		System.out.println("product :: 여기 왔나요");
		System.out.println("selectBrandProductList [list] : " + list);

		model.addAttribute("list", list);

		return "myPage/myPage_Brand_Product";
	}

	// 등록 상품 - 업체가 등록한 상품 리스트 - 삭제
	@RequestMapping("myPage/myPage_Brand_Prdouct_Delete.mp")
	public String myPage_Brand_Prdouct_Delete(@RequestParam int productNo, Model model) {

		int result = brandService.deleteBrandProductList(productNo);
		System.out.println("result :: " + result);
		System.out.println("product_delete :: 여기 왔나요"); // 여기 안옴
		String loc = "/myPage/myPage_Brand_Product.mp";
		String msg = "";

		if (result > 0) {
			msg = "삭제 완료!";

		} else {
			msg = "삭제 실패!";
		}

		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);

		return "common/msg";
	}

	// 상품 순위
	// 등록 상품 - 업체가 등록한 상품 리스트 - 수정
	@RequestMapping("myPage/myPage_Brand_Rank.mp")
	public String myPage_Brand_Rank(Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("member");
		int member_no = member.getMember_no();
		System.out.println(member_no); // 16(nike 브랜드)

		List<Product> list = brandService.selectBrandProductRankList(member_no);
		System.out.println("product Rank :: 여기 왔나요");
		System.out.println("selectBrandProductRankList [list] : " + list);

		model.addAttribute("list", list);

		return "myPage/myPage_Brand_Rank";
	}

	// 주문 내역 - 소비자가 주문한 주문 내역(업체가 판매한 판매 내역)
	@RequestMapping("myPage/myPage_Brand_Order.mp")
	public String selectBrandOrderList(Model model, HttpServletRequest req) {

		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("member");
		String brand_name = member.getBrand_name();
		System.out.println(brand_name);

		List<MypageOrderList> list = brandService.selectBrandOrderList(brand_name);
		System.out.println("order :: 여기 왔나요");
		System.out.println("selectBrandOrderList [list] : " + list);

		model.addAttribute("list", list);

		return "myPage/myPage_Brand_Order";
	}
	
	// 컨트롤러 하나 더 만들어야하나?
	
	

	// 주문 내역 - 소비자가 주문한 주문 내역 - 자세히 보기
	@RequestMapping("myPage/myPage_Order_Detail.mp")
	@ResponseBody
	public List<MypageOrderList> selectBrandOrderDetail(@RequestParam int orderNo) {

		List<MypageOrderList> list = brandService.selectBrandOrderDetail(orderNo);
		System.out.println("order_detail :: 여기 왔나요");
		System.out.println("selectBrandOrderDetail [list] : " + list);

		return list;
	}
	
	// 주문 내역 - 발송 완료 버튼 눌렀을 때
	@RequestMapping("myPage/myPage_Brand_Send.mp")
	@ResponseBody
	public int myPage_Brand_Send(@RequestParam int orderNo, Model model) {
		
		int a = brandService.updateBrandStatus(orderNo);
		
		// 업체가 발송 완료 버튼을 눌렀을때 order_status, purchases_status를 '2'로 바꿔줘야 함
		// sql update를 통해 정상적으로 변경이 되었다면 result라는 새로운 변수에 '2' 값을 넣어줌(update에 실패한다면 result는 0)
		// ajax로 화면에 result를 return
		int result = 0;
		
		if(a>0) {
			result = 2;
		} else {
			result = 0;
		}
		System.out.println("결과 : " + result);
			
		return result;
		
		
	}
	

		
	
	
	
	
	

}