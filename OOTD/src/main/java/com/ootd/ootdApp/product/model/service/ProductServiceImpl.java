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
		
		// Product Insert
		
		int resultP = 0;	// Product Insert 실행 결과
		int resultA = 0;	// Attachment Insert 실행 결과
		
		if (pType == 1) { // brand insert 
			System.out.println("브랜드 상품 등록 serviceImpl 수행");
			
			resultP = productDAO.brandInsert(product, attachList);
			
			System.out.println("resultP : " + resultP);
		} else {		// second insert
			System.out.println("중고 상품 등록 serviceImpl 수행");
			
			resultP = productDAO.secondHandInsert(product, attachList);
			System.out.println("resultP : " + resultP);
		}
		
		// Attachment Insert 
		
		if( resultP > 0 ) {	// Product Insert 성공 했다면 첨부파일 Insert 실행

			System.out.println("Attachment Insert 실행 확인");
			System.out.println("attachList : " + attachList);
			if(attachList.size() > 0) { // 첨부파일이 있다면
				System.out.println("attachList.size() : " + attachList.size());
				for(Attachment a : attachList) {
					resultA = productDAO.attachmentInsert(a);
					System.out.println("resultA :: " + resultA);
				}
				System.out.println("resultA :: " + resultA);
			}

		} /*
			 * else { // Product Insert 실패 했다면 Product Exception 실행 }
			 */
		System.out.println("DAO 리턴 resultA :: " + resultA);

		return resultA;
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

	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public int productUpdate(Product product) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

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
	public int selectReviewTotalContents(int product_no) {
		
		return productDAO.selectReviewTotalContents(product_no);
	}

	// 다인
	@Override
	public List<Attachment> selectProductImages() {
		
		return productDAO.selectProductImages();
	}

	@Override
	public int productUpdate(int product_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

	

	
	

}