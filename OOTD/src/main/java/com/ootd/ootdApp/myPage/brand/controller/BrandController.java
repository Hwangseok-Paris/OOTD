package com.ootd.ootdApp.myPage.brand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ootd.ootdApp.myPage.brand.model.service.BrandService;
import com.ootd.ootdApp.myPage.brand.model.vo.MypageOrderList;

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

	@RequestMapping("myPage/myPage_Brand_Product.mp")
	public String myPage_Brand_Product(Model model) {
		
		List<MypageOrderList> list = brandService.selectBrandOrderList();
		System.out.println("여기 왔나요");
		System.out.println("selectBrandOrderList [list] : " + list);

		model.addAttribute("list", list);

		return "myPage/myPage_Brand_Product";
	}

	@RequestMapping("myPage/myPage_Brand_Rank.mp")
	public void myPage_Brand_Rank() {

	}

	@RequestMapping("myPage/myPage_Brand_Order.mp")
	public String selectBrandOrderList(Model model) {

		// session으로 회원 정보 받기
		// 
		// 파라미터로 회원 번호 넘겨주기? 
		List<MypageOrderList> list = brandService.selectBrandOrderList();
		System.out.println("여기 왔나요");
		System.out.println("selectBrandOrderList [list] : " + list);

		model.addAttribute("list", list);

		return "myPage/myPage_Brand_Order";
	}








}