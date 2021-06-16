package com.ootd.ootdApp.product.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ootd.ootdApp.product.model.vo.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	// =========Product List (select) 조회=========
	RowBounds rows;

	@Override
	public List<Map<String, String>> brandSelectList(int cPage, int numPerPage) {
		// DB SQL 에서 특정 개수의 행만 뽑아오는 객체
		rows = new RowBounds((cPage - 1) * numPerPage, numPerPage);

		return sqlSession.selectList("product-mapper.brandSelectList", null, rows);
	}

	@Override
	public List<Map<String, String>> secondHandSelectList(int cPage, int numPerPage) {
		// DB SQL 에서 특정 개수의 행만 뽑아오는 객체
		rows = new RowBounds((cPage - 1) * numPerPage, numPerPage);

		return sqlSession.selectList("product-mapper.secondHandSelectList", null, rows);
	}

	@Override
	public int brandSelectTotalContents() {
		
		return sqlSession.selectOne("product-mapper.brandSelectTotalContents");
	}

	@Override
	public int secondHandSelectTotalContents() {
		
		return sqlSession.selectOne("product-mapper.secondHandSelectTotalContents");
	}

	
	
	// =========Product Input (insert)=========
	
	@Override
	public int brandInsert(Product product) {
		
		return sqlSession.insert("product-mapper.insertProduct", product);
	}

	@Override
	public int secondHandInsert(Product product) {
		
		return sqlSession.insert("product-mapper.insertProduct", product);
	}

	@Override
	public Product brandSelectOne(int product_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product secondHandSelectOne(int product_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int brandUpdate(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int secondHandUpdate(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int brandDelete(int product_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int secondHandDelete(int product_no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
