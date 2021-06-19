package com.ootd.ootdApp.product.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ootd.ootdApp.common.Utils;
import com.ootd.ootdApp.common.Utils2;
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
			@RequestParam int pType,	// 브랜드 or 중고 구분 
			@RequestParam( required = false, defaultValue = "0") int categoryNo,	// 선택한 카테고리 값
			@RequestParam( value = "bName", required = false, defaultValue = "All") String bName, // 선택한 브랜드 이름 
			@RequestParam( required = false, defaultValue = "") String sortVal, // 선택한 필터 정렬 값 
			@RequestParam( value = "cPage", required = false, defaultValue = "1") int cPage,
			Model model
			) {
		// pType = 1 ? 브랜드 : 상품  
//		System.out.println(sortVal);
		// product_category 와 brand_name 을 갖는 product VO 생성
		Product product = new Product(categoryNo, bName, sortVal);
//		System.out.println("controller에서 product.getProduct_category() :: " + product.getProduct_category());
//		System.out.println("controller에서 product.getBrand_Name() :: " + product.getBrand_name());
//		System.out.println("controller에서 product.getSortVal() :: " + product.getSortVal());
		
		
		// 한 페이지당 상품 갯수 
		int numPerPage = 12;
		
		// 현재 페이지의 상품 갯수
		List<Map<String, String>> list
			 = productService.productSelectList(cPage, numPerPage, pType ,product);
		
		// 전체 상품 갯수 
		int totalContents = productService.productSelectTotalContents(pType);
		
		// 페이지 처리 HTML 생성하기
		String pageBar = Utils.getPageBar(totalContents, cPage, numPerPage, "productList.do");
		
		System.out.println("list : " + list);
		
		// brand_name List 불러오기 
		List<String> brandName = productService.brandNameSelectList();
		
//		System.out.println("brandName : " + brandName);
		
		
		model.addAttribute("product", product); // category & brandName 별 검색 시 사용할 값
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

	// 상품 등록 화면으로 이동하는 것은 현재 중고 리스트 화면에만 존재함.
	// myPage_brand_??    마이페이지 쪽에서   상품등록으로 넘길버튼에 pType 담아서 보내야 함 - 기원 -  
	@RequestMapping("product/productInputForm.do")
	public String productInputForm(@RequestParam int pType, Product p) {
		// pType = 1 ? 브랜드 : 상품  		
		
		System.out.println("productDetail controller 접근");
		// List<Review> review = productService.
		
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
	public String productInput(Product p, HttpServletRequest req, Model model,
			@RequestParam(value = "secondHandProductImg", required = false) MultipartFile[] upFiles) {
		// pType = 1 ? 브랜드 : 상품
		int pType = p.getProduct_type();

			System.out.println("product_no : " + p.getProduct_no());
			System.out.println("product_type : " + p.getProduct_type());
			System.out.println("product_member_no : " + p.getMember_no());
			System.out.println("product_name : " + p.getProduct_name());
			System.out.println("product_price : " + p.getProduct_price());
			System.out.println("product_detail : " + p.getProduct_detail());
			System.out.println("product_sizeinfo : " + p.getProduct_sizeinfo());
			System.out.println("product_size : " + p.getProduct_size());
			System.out.println("product_status : " + p.getProduct_status());

		// 1. 파일 저장 경로 및 파일 정보를 담을 객체 생성
		List<Attachment> attachList = new ArrayList<>();
		int att_level = 0; // 몇번째 사진인지에 대한 변수

		String savePath = req.getServletContext().getRealPath("/resources/images/productImgUpload");
		
		// 2. 파일 업로드
		for (MultipartFile f : upFiles) {
			System.out.println("파일 업로드 for문 진입");
			// 만약 파일을 등록한 경우
			if (f.isEmpty() == false) {
				// 3. 파일 이름 변경
				String originName = f.getOriginalFilename(); // 파일의 원래 이름
				String changeName = fileNameChanger(originName); // 파일 이름 변경

				try {
						
					f.transferTo(new File(savePath + "/" + changeName));

				} catch (IllegalStateException | IOException e) {

					e.printStackTrace();
				}

				// 4. attachList에 담기
				System.out.println("attachList 담기 진입");
				Attachment a = new Attachment();
				a.setAtt_name(changeName);

				att_level++;
				a.setAtt_level(att_level); // 사진 순서 번호 세팅.
				a.setProduct_no(p.getProduct_no()); // 현재 등록하는 상품의 번호를 셋팅

				attachList.add(a);
				System.out.println("att_no : " + a.getAtt_no());
				System.out.println("att_name : " + a.getAtt_name());
				System.out.println("att_date : " + a.getAtt_date());
				System.out.println("att_level : " + a.getAtt_level());
				System.out.println("att_status : " + a.getAtt_status());
				System.out.println("att_product_no : " + a.getProduct_no());

			}

		}


		// 5. 상품을 DB에 저장. 결과
		int result = productService.productInsert(p, pType, attachList);

		String msg = "";
		String loc = "/";
		
		if ( result > 0 ) {
			msg = "상품등록 완료!";
		} else {
			msg = "상품등록 실패";
		}
		
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";

	}
	
	
	// 단순 파일 이름 변경용 메소드 
	public String fileNameChanger(String oldFileName) {

		String ext = oldFileName.substring(oldFileName.lastIndexOf(".") + 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
		int rnd = (int)(Math.random() * 1000);

		return sdf.format(new Date(System.currentTimeMillis())) + "_" + rnd + "." + ext;
			
	}
	
	
	
	//=========Product Detail( selectOne )=========	
	@RequestMapping("/product/productDetail.do")
	public String productDetail(
				@RequestParam( value="cPage", required=false, defaultValue="1" ) int cPage,
				@RequestParam int pType, 
				@RequestParam int product_no, 
				Model model
			) {
		// pType = 1 ? 브랜드 : 상품  	
		
		Product p = productService.productSelectOne(pType, product_no);
		List<Attachment> att = p.getAttachment();
	
		model.addAttribute("product", p);
		model.addAttribute("attachment", att);
	
		if ( pType == 1 ) {		// 브랜드 
			
			int numPerPage = 5;
			
			// 현재 페이지의 게시글 수
			List<Map<String, String>> review 
				= productService.selectReviewList(cPage, numPerPage, product_no);
			
			// 전체 게시글 수 
			int totalContents = productService.selectReviewTotalContents(product_no);
			
			// 페이지 처리 HTML 생성하기
			// product_no=1&pType=1
			String pageBar = Utils2.getPageBar(totalContents, cPage, numPerPage, 
												"productDetail.do?product_no="+product_no+"&pType=1");
			
			System.out.println("review : " + review);
			
			model.addAttribute("review", review);
			model.addAttribute("totalContents", totalContents);
			model.addAttribute("numPerPage", numPerPage);
			model.addAttribute("pageBar", pageBar);
			
			return "product/brandDetail";
			
		} else {	// 중고
				
			return "product/secondHandDetail";
		}

	}
	
	
	

	
	//=========Product Update( 브랜드 상품 수정화면으로 보내주는 경로 )======== ( selectOne 사용 )
	@RequestMapping("/product/productUpdateView.do")
	// @RequestParam int product_no, @RequestParam int pType 제거
	public String productUpdateView(Product p) {
		// pType = 1 ? 브랜드 : 상품  	
		int pType = p.getProduct_type();
		
		if( pType == 1 ) {
			
			System.out.println("productUpdateView 진입");
			return "product/brandUpdateForm";			// 상품 select 후 updateForm jsp로 이동 
			
		} else {
			
			System.out.println("productUpdateView 진입");
			
			//Product product = productService.updateView(productNo);
			//List<Attachment> attachmentList = productService.selectAttachmentList(boardNo);
			
			//model.addAttribute("product", product);
			//model.addAttribute("attachmentList", attachmentList);
			
			return "product/secondHandUpdateForm";		// 상품 select 후 updateForm jsp로 이동 
			
		}
		
		
		
	}
	
	
	//=========Product Update( Update )======== 
	@RequestMapping("/product/productUpdate.do")
	public String productUpdate(Product p, HttpServletRequest req, Model model,
			@RequestParam(value = "secondHandProductImg", required = false) MultipartFile[] upFiles) {
		// pType = 1 ? 브랜드 : 상품  	
		int pType = p.getProduct_type();
		
		if( pType == 1 ) {
			System.out.println("productUpdate 진입");
			return "product/brandDetail";			// 상품 수정완료 후 Detail로 이동 
		} else {
			System.out.println("productUpdate 진입");
			
			// 1. 원본 게시글 가져와 수정하기
			
			
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
	
	
	
	// 210619 다인
	@RequestMapping("/product/selectProductImages.do")
	@ResponseBody
	public List<Attachment> selectProductImages() {
		
		List<Attachment> list = productService.selectProductImages();
		System.out.println("images :: 여기 왔나요");
		System.out.println("selectProductImages [list] : " + list);
		
		return list;
	}

	
	
	
	
	
	
	
	
	
	
}