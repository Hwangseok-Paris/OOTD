package com.ootd.ootdApp.product.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ootd.ootdApp.product.model.vo.Attachment;
import com.ootd.ootdApp.product.model.vo.Product;
import com.ootd.ootdApp.product.model.vo.Review;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	// =========Product List (select) 조회=========
	RowBounds rows;

	@Override
	public List<Map<String, String>> brandSelectList(int cPage, int numPerPage, Product product) {
		// DB SQL 에서 특정 개수의 행만 뽑아오는 객체
		rows = new RowBounds((cPage - 1) * numPerPage, numPerPage);

		return sqlSession.selectList("product-mapper.brandSelectList", product, rows);
	}

	@Override
	public List<Map<String, String>> secondHandSelectList(int cPage, int numPerPage, Product product) {
		// DB SQL 에서 특정 개수의 행만 뽑아오는 객체
		rows = new RowBounds((cPage - 1) * numPerPage, numPerPage);

		return sqlSession.selectList("product-mapper.secondHandSelectList", product, rows);
	}

	@Override
	public int brandSelectTotalContents() {
		
		return sqlSession.selectOne("product-mapper.brandSelectTotalContents");
	}

	@Override
	public int secondHandSelectTotalContents() {
		
		return sqlSession.selectOne("product-mapper.secondHandSelectTotalContents");
	}

	@Override
	public List<String> brandNameSelectList() {
		
		return sqlSession.selectList("product-mapper.brandNameSelectList");
	}
	
	// =========Product Input (insert)=========
	
	@Override
	public int brandInsert(Product product, List<Attachment> a) {
		System.out.println("brandInsert DAO 접근");
		return sqlSession.insert("product-mapper.insertBrandProduct", product);
	}

	@Override
	public int secondHandInsert(Product product, List<Attachment> a) {
		System.out.println("secondHandInsert DAO 접근");
		return sqlSession.insert("product-mapper.insertSecondHandProduct", product);
	}
	
	@Override
	public int attachmentInsert(Attachment a) {
		System.out.println("attachmentInsert DAO 접근");
		return sqlSession.insert("product-mapper.insertAttachment", a);
	}

	// =========Product Detail (SelectOne)=========
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

	
	// service 통합형 
	@Override
	public Product productSelectOne(int pType, int product_no) {
		
		if( pType == 1) { // brand
			Product brandP = sqlSession.selectOne("product-mapper.brandSelectOne", product_no);
			List<Attachment> brandAtt = sqlSession.selectList("product-mapper.brandAttSelectList", product_no);
			
			brandP.setAttachment(brandAtt);
			
			System.out.println("DAO 에서 brandP :: " + brandP);
			
			return brandP;		// 한개 상품 정보와 해당 상품의 첨부파일 List 가 담긴  하나의 product VO 반환 
			
		} else { // second
			Product secondP = sqlSession.selectOne("product-mapper.secondSelectOne", product_no);
			List<Attachment> secondAtt = sqlSession.selectList("product-mapper.secondAttSelectList", product_no);
			
			secondP.setAttachment(secondAtt);
			
			System.out.println("DAO 에서 secondP :: " + secondP);
			
			return secondP;		// 한개 상품 정보와 해당 상품의 첨부파일 List 가 담긴  하나의 product VO 반환 
		}
		
		
		
		
	}
	
	
	// =========Product Update (update)=========
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

	@Override
	public List<Review> selectProductReview(int product_no) {
		System.out.println("DAO 접근 확인");
		return sqlSession.selectList("product-mapper.selectReviewList", product_no);
	}

	@Override
	public List<Map<String, String>> selectReviewList(int cPage, int numPerPage, int product_no) {
		// 데이터베이스 SQL에서 특정 개수의 행만 뽑아오는 객체
		RowBounds rows = new RowBounds((cPage-1)*numPerPage, numPerPage);
				                           // (시작값, 뽑아올 갯수)
				                              
		return sqlSession.selectList("product-mapper.selectReviewList", product_no, rows);
				                         // mapper, null(전달값 없음), rows (반드시 세번째에 넣기)
	}

	@Override
	public int selectReviewTotalContents() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product-mapper.selectReviewTotalContents");
	}

	// 다인
	@Override
	public List<Attachment> selectProductImages() {
		
		return sqlSession.selectList("product-mapper.selectProductImages");
	}

	

	

}
