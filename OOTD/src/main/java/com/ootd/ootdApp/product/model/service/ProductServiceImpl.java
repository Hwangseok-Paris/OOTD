package com.ootd.ootdApp.product.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ootd.ootdApp.product.model.dao.ProductDAO;
import com.ootd.ootdApp.product.model.vo.Product;

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
	public int productInsert(Product product) {
		
		int result1 = productDAO.secondHandInsert(product);
		System.out.println("result1 : " + result1);
		
		return result1;
	}

	@Override
	public Product productSelectOne(int product_no) {
		// TODO Auto-generated method stub
		return null;
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

	

	
	

}
