package com.ootd.ootdApp.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ootd.ootdApp.product.model.dao.ProductDAO;
import com.ootd.ootdApp.product.model.vo.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;
	
	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> selectProductList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product selectProduct(int product_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int product_no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
