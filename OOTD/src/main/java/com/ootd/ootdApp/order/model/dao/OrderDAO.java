package com.ootd.ootdApp.order.model.dao;

import java.util.List;

import com.ootd.ootdApp.order.model.vo.Cart;

public interface OrderDAO {
	
	List<Cart> selectCartList(int member_no);

	int deleteProduct(int cart_no);
	
	int updateQuantity(int cart_no, int cart_quantity);
	
}
