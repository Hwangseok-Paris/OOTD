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
import com.ootd.ootdApp.product.model.vo.Attachment;
import com.ootd.ootdApp.product.model.vo.Product;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	// =========Product List (SelectList)조회 =========
	// 메인 화면에서 brand 또는 second hand 클릭 시 수행되는 로직.
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

		// brand를 클릭 시, pType 값 1을 가져오게 되고, 해당 값을 가져올 경우
		// 브랜드 상품 리스트로 이동
		if (pType == 1) {

			return "product/brandList";
		} else {
			// 아닐 경우, 중고 상품 리스트로 이동
			return "product/secondHandList";
		}

	}
	
	
	//========= 중고 or 브랜드 상품 리스트 화면 =========	
	// 상품 등록 화면으로 이동하는 버튼은 현재 중고 리스트 화면에만 존재함.
	@RequestMapping("product/productInputForm.do")
	public String productInputForm(@RequestParam int pType, Product p) {
		// pType = 1 ? 브랜드 : 상품  		
		
		
		if( pType == 1 ) {
			// 아직 브랜드 상품 리스트 화면에서 product/productInputForm.do를 수행하는 기능이 없음.
			return "product/brandInput";			// 브랜드 상품 등록 jsp로 이동 (아직 기능 없음)
		} else {
			// 중고 상품 리스트 화면에서 상품 등록 버튼 클릭 시, 이동.
			return "product/secondHandInput";		// 중고 상품 등록 jsp로 이동 
		}

	}
	
	//=========Product Input Form에서 상품 등록 후, 각 상품의 리스트 화면으로 이동  ( insert )=========	
		@RequestMapping("product/productInput.do")
		public String productInput(Product p, Attachment a) {
			// pType = 1 ? 브랜드 : 상품  		
			int pType = p.getProduct_type();
			
			if( pType == 1 ) {
			
				
				return "product/brandList"; 		// 상품 등록 완료 후 브랜드 상품 List 로 이동 
			} else {
//				System.out.println("product_type : " + p.getProduct_type());
//				System.out.println("product_member_no : " + p.getMember_no());
//				System.out.println("product_name : " + p.getProduct_name());
//				System.out.println("product_price : " + p.getProduct_price());
//				System.out.println("product_detail : " + p.getProduct_detail());
//				System.out.println("product_sizeinfo : " + p.getProduct_sizeinfo());
//				System.out.println("product_size : " + p.getProduct_size());
//				System.out.println("product_status : " + p.getProduct_status());
				
				
				
				
				int result = productService.productInsert(p, pType, a);
				
				return "product/secondHandList";	// 상품 등록 완료 후 중고 상품 List 로 이동 
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
