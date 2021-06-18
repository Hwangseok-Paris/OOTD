package com.ootd.ootdApp.product.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ootd.ootdApp.product.model.dao.ProductDAO;
import com.ootd.ootdApp.product.model.vo.Attachment;
import com.ootd.ootdApp.product.model.vo.Product;
import com.ootd.ootdApp.product.model.vo.Review;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;

	// =========Product List (select) 조회=========
	
	@Override
	public List<Map<String, String>> productSelectList(int cPage, int numPerPage, int pType, Product product) {
		
		if (pType == 1) {

			return productDAO.brandSelectList(cPage, numPerPage, product);
		} else {
			
			return productDAO.secondHandSelectList(cPage, numPerPage, product);
		}
	}

	@Override
	public int productSelectTotalContents(int pType) {
		
		if (pType == 1) {

			return productDAO.brandSelectTotalContents();
		} else {
			
			return productDAO.secondHandSelectTotalContents();
		}
	}
	
	@Override
	public List<String> brandNameSelectList() {
		
		return productDAO.brandNameSelectList();
	}

	// =========Product Input (insert)=========
	
	@Override
	public int productInsert(Product product, int pType, List<Attachment> attachList) {
		
		if (pType == 1) {
			System.out.println("브랜드 상품 등록 serviceImpl 수행");
			
			int result1 = productDAO.brandInsert(product, attachList);
			
			System.out.println("result1 : " + result1);
			return 0;
		} else {
			System.out.println("중고 상품 등록 serviceImpl 수행");
			
			int result1 = productDAO.secondHandInsert(product, attachList);
			System.out.println("result1 : " + result1);
			
			// 현재 추가된 boardNo를 가져오는 방법 2가지
			// 1. DB에서 가장 최근에 추가된 게시글 번호를 DAO를 통해 직접 가져오는 방법
			// 2. mapper에서 selectKey 태그를 사용하는 방법
			
			// 첨부파일이 있다면
			if(attachList.size() > 0) {
				for(Attachment a : attachList) {
					int result2 = productDAO.attachmentInsert(a);
					
				}
			}
			
			return result1;
		}
	}

	@Override
	public Product productSelectOne(int pType, int product_no) {


//		// brand 
//		if( pType == 1) {
//			Product p = productDAO.brandSelectOne(product_no);
//			
//		// second
//		} else {
//			
//			
//		}
		
		Product p = productDAO.productSelectOne(pType, product_no); 
		
		
		return p;
	}

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public int productUpdate(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int productDelete(int product_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Review> selectProductReview(int product_no) {
		System.out.println("service 접근 확인");
		return productDAO.selectProductReview(product_no);
	}

	

	@Override
	public List<Map<String, String>> selectReviewList(int cPage, int numPerPage, int product_no) {
		
		return productDAO.selectReviewList(cPage, numPerPage, product_no);
	}

	@Override
	public int selectReviewTotalContents() {
		
		return productDAO.selectReviewTotalContents();
	}

	

	

	
	

}
