package com.ootd.ootdApp.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ootd.ootdApp.product.model.service.ProductService;
import com.ootd.ootdApp.product.model.vo.Product;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	//=========Product List (SelectList)조회=========	 
	@RequestMapping("/product/productList.do")
	public String selectBrandList(@RequestParam int pType) {
		// pType = 1 ? 브랜드 : 상품  
		
		
		if( pType == 1 ) {
			
			return "product/brandList"; 
		} else {
			
			return "product/secondHandList"; 
		}
		
		
		
	}
	
	
	//=========Product Input jsp로 경로설정  ( insert )=========	
	@RequestMapping("product/productInputForm.do")
	public String insertProductInputForm(@RequestParam int pType) {
		// pType = 1 ? 브랜드 : 상품  		
		
		
		if( pType == 1 ) {
			
			return "product/brandInput";			// 상품 등록 jsp로 이동 
		} else {
			
			return "product/secondHandInput";		// 상품 등록 jsp로 이동 
		}

	}
	
	//=========Product Input Form 으로 이동  ( insert )=========	
		@RequestMapping("product/productInput.do")
		public String insertProductInput(Product p) {
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
	public String selectProductDetail(/*상품번호, 상품type 받아오기*/) {
		// pType = 1 ? 브랜드 : 상품  	
	
		if( pType == 1 ) {
			
			return "product/brandDetail";
		} else {
			
			return "product/secondHandDetail";
		}
		
		
		
	}
	
	
	

	
	// 브랜드 상품 수정화면  (상품 select 후 updateForm 으로 보내주기 ) 
	@RequestMapping("/product/brandUpdateView.do")
	public String updateBrandUpdateView() {
		
		return "product/brandUpdateView";
	}
	
	// 브랜드 상품 수정 
	@RequestMapping("/product/brandUpdate.do")
	public String updateBrandUpdate() {
		
		return "product/brandList";
	}
	
	
	// 중고 상품 수정화면  (상품 select 후 updateForm 으로 보내주기 ) 
	@RequestMapping("/product/secondHandUpdateView.do")
	public String updateSecondHandUpdateView() {
		
		return "product/secondHandUpdateView";
	}
	
	// 중고 상품 수정 
	@RequestMapping("/product/secondHandUpdate.do")
	public String updateSecondHandUpdate() {
		
		return "product/secondHandList";
	}
	
	
	
	
	
	
	
	
	
	
	
}
