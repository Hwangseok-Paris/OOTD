package com.ootd.ootdApp.order.model.dao;

import java.util.List;
import java.util.Map;

import com.ootd.ootdApp.order.model.vo.Cart;

public interface OrderDAO {
	
	List<Cart> selectCartList(int member_no);

	int deleteCartProduct(int cart_no);
	
	int deleteCartProductAll(int member_no);

	int updateQuantity(Map<String, String> map);

	List<Cart> selectedCartList(int cart_no);
	
}
