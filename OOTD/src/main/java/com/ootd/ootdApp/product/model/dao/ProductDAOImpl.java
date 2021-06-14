package com.ootd.ootdApp.product.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ootd.ootdApp.product.model.vo.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
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
