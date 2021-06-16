package com.ootd.ootdApp.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ootd.ootdApp.common.Utils;
import com.ootd.ootdApp.product.model.service.ProductService;
import com.ootd.ootdApp.product.model.vo.Product;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	// =========Product List (SelectList)조회=========
	@RequestMapping("/product/productList.do")
	public String productList(
			@RequestParam int pType,
			@RequestParam( value = "cPage", required = false, defaultValue = "1") int cPage,
			Model model
			) {
		// pType = 1 ? 브랜드 : 상품  
		
		// 한 페이지당 상품 갯수 
		int numPerPage = 12;
		
		// 현재 페이지의 상품 갯수
		List<Map<String, String>> list
			 = productService.productSelectList(cPage, numPerPage, pType);
		
		// 전체 상품 갯수 
		int totalContents = productService.productSelectTotalContents(pType);
		
		// 페이지 처리 HTML 생성하기
		String pageBar = Utils.getPageBar(totalContents, cPage, numPerPage, "productList.do");
		
		System.out.println("list : " + list);
		
		// brand_name List 불러오기 
		List<String> brandName = productService.brandNameSelectList();
		
		System.out.println("brandName : " + brandName);
		
		
		model.addAttribute("list", list);
		model.addAttribute("brandName", brandName);
		model.addAttribute("totalContents", totalContents);
		model.addAttribute("numPerPage", numPerPage);
		model.addAttribute("pageBar", pageBar);

		if (pType == 1) {

			return "product/brandList";
		} else {

			return "product/secondHandList";
		}

	}
	
	
	//=========Product Input jsp로 경로설정  ( insert )=========	
	@RequestMapping("product/productInputForm.do")
	public String productInputForm(@RequestParam int pType) {
		// pType = 1 ? 브랜드 : 상품  		
		
		
		if( pType == 1 ) {
			
			return "product/brandInput";			// 상품 등록 jsp로 이동 
		} else {
			
			return "product/secondHandInput";		// 상품 등록 jsp로 이동 
		}

	}
	
	//=========Product Input Form 으로 이동  ( insert )=========	
		@RequestMapping("product/productInput.do")
		public String productInput(Product p) {
			// pType = 1 ? 브랜드 : 상품  		
			int pType = p.getProduct_type();
			
			if( pType == 1 ) {
				
				return "product/brandList"; 		// 상품 등록 완료 후 List 로 이동 
			} else {
				
				return "product/secondHandList";	// 상품 등록 완료 후 List 로 이동 
			}

		}
	
	
	
	
	//=========Product Detail( selectOne )=========	
	@RequestMapping("/product/productDetail.do")
	public String productDetail(@RequestParam int pType, @RequestParam int product_no) {
		// pType = 1 ? 브랜드 : 상품  	
	
		if( pType == 1 ) {
			
			return "product/brandDetail";
		} else {
			
			return "product/secondHandDetail";
		}
		
		
		
	}
	
	
	

	
	//=========Product Update( 브랜드 상품 수정화면으로 보내주는 경로 )======== ( selectOne 사용 )
	@RequestMapping("/product/productUpdateView.do")
	public String productUpdateView(@RequestParam int pType, @RequestParam int product_no) {
		// pType = 1 ? 브랜드 : 상품  	
		
		
		if( pType == 1 ) {
			
			return "product/brandUpdateForm";			// 상품 select 후 updateForm jsp로 이동 
		} else {
			
			return "product/secondHandUpdateForm";		// 상품 select 후 updateForm jsp로 이동 
		}
		
		
		
	}
	
	
	//=========Product Update( Update )======== 
	@RequestMapping("/product/productUpdate.do")
	public String productUpdate(Product p) {
		// pType = 1 ? 브랜드 : 상품  	
		int pType = p.getProduct_type();
		
		if( pType == 1 ) {
			
			return "product/brandDetail";			// 상품 수정완료 후 Detail로 이동 
		} else {
			
			return "product/secondHandDetail";		// 상품 수정완료 후 Detail로 이동 
		}
		
		
	}
	
	
	//=========Product Delete( Delete )======== 
	@RequestMapping("/product/productDelete.do")
	public String productDelete(@RequestParam int pType, @RequestParam int product_no) {
		// pType = 1 ? 브랜드 : 상품  	
		
		if( pType == 1 ) {
			
			return "product/brandList";			// 상품 삭제완료 후 List로 이동 
		} else {
			
			return "product/secondHandList";		// 상품 삭제완료 후 List로 이동 
		}
		
	}
	
	
	
	
	
}
