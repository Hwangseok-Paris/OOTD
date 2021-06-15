package com.ootd.ootdApp.myPage.brand.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ootd.ootdApp.myPage.brand.model.service.BrandService;
import com.ootd.ootdApp.myPage.brand.model.vo.MypageOrderList;
import com.ootd.ootdApp.product.model.vo.Product;

@Controller
public class BrandController {

	  @Autowired 
	  BrandService brandService;

	/*
	 * // 회원이 주문한 상품(주문)내역 불러오기
	 * 
	 * @RequestMapping("/myPage_Brand_Order.mp") public String selectBrandList(Model
	 * model) {
	 * 
	 * List<Order_List> list = brandService.selectBrandOrderList();
	 * 
	 * System.out.println("selectBrandOrderList [list] : " + list);
	 * 
	 * model.addAttribute("list", list);
	 * 
	 * return "myPage/myPage_Brand_Order";
	 * 
	 * }
	 */
	/*
	 * @RequestMapping("myPage/myPage_Brand_Menu.mp") public void
	 * myPage_Brand_Menu() {
	 * 
	 * }
	 */

	@RequestMapping("myPage/myPage_Brand_Info.mp")
	public void myPage_Brand_Info() {

	}

	// 등록 상품 - 업체가 등록한 상품 리스트
	@RequestMapping("myPage/myPage_Brand_Product.mp")
	public String myPage_Brand_Product(Model model) {
		
		List<Product> list = brandService.selectBrandProductList();
		System.out.println("product :: 여기 왔나요");
		System.out.println("selectBrandProductList [list] : " + list);

		model.addAttribute("list", list);

		return "myPage/myPage_Brand_Product";
	}
	
	// 등록 상품 - 업체가 등록한 상품 리스트 - 삭제
	@RequestMapping("myPage/myPage_Brand_Prdouct_Delete.mp")
	public String myPage_Brand_Prdouct_Delete(@RequestParam int productNo, Model model) {
		
		int result = brandService.deleteBrandProductList(productNo);
		System.out.println("result :: " + result );
		System.out.println("product_delete :: 여기 왔나요"); // 여기 안옴
		String loc = "/myPage/myPage_Brand_Product.mp";
		String msg = "";
		
		if( result > 0) {
			msg = "삭제 완료!";
			
		} else {
			msg = "삭제 실패!";
		}
		
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	// 등록 상품 - 업체가 등록한 상품 리스트 - 수정
	
	
	
	
	

	@RequestMapping("myPage/myPage_Brand_Rank.mp")
	public void myPage_Brand_Rank() {

	}

	// 주문 내역 - 소비자가 주문한 주문 내역(업체가 판매한 판매 내역)
	@RequestMapping("myPage/myPage_Brand_Order.mp")
	public String selectBrandOrderList(Model model) {

		// session으로 회원 정보 받기5
		// 
		// 파라미터로 회원 번호 넘겨주기? 
		List<MypageOrderList> list = brandService.selectBrandOrderList();
		System.out.println("order :: 여기 왔나요");
		System.out.println("selectBrandOrderList [list] : " + list);

		model.addAttribute("list", list);

		return "myPage/myPage_Brand_Order";
	}
	
	// 주문 내역 - 소비자가 주문한 주문 내역 - 자세히 보기
	@RequestMapping("myPage/myPage_Order_Detail.mp")
	@ResponseBody
	public List<MypageOrderList> selectBrandOrderDetail(@RequestParam int orderNo) {
		
		List<MypageOrderList> list = brandService.selectBrandOrderDetail(orderNo);
		System.out.println("order_detail :: 여기 왔나요");
		System.out.println("selectBrandOrderDetail [list] : " + list);
		
		return list;
	}







}