package com.ootd.ootdApp.product.model.service;

import java.util.List;

import com.ootd.ootdApp.product.model.vo.Product;

public interface ProductService {

	
	//=========Product List 조회========= 
	
	/**
	 * brandList 조회를 위한 메소드 
	 * @return List<Product>
	 */
	List<Product> selectBrandList();
	
	
	/**
	 * secondHandList 조회를 위한 메소드 
	 * @return List<Product>
	 */
	List<Product> selectSecondHandList();
	
	
	//=========Product List 조회=========	
	
	
	/**
	 * 상품 등록을 위한 메소드 
	 * @param product
	 * @return int 
	 */
	int insertProduct(Product product);
	
	
	/**
	 * 상품 번호로 상품 한 개 조회를 위한 메소드 
	 * @param product_no
	 * @return Product
	 */
	Product selectProduct(int product_no);
	
	/**
	 * 상품 수정하는 메소드 
	 * @param Product
	 * @return int
	 */
	int updateProduct(Product product);
	
	/**
	 * 상품번호로 상품 삭제하는 메소드 
	 * @param product_no
	 * @return int
	 */
	int deleteProduct(int product_no);
	
	
	
}
