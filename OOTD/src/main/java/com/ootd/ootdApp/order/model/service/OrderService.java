package com.ootd.ootdApp.order.model.service;

import java.util.List;

import com.ootd.ootdApp.order.model.vo.Cart;

public interface OrderService {
	
	List<Cart> selectCartList(int member_no);
	
	int deleteCartProduct(int cart_no);
	
	int updateQuantity(int cart_no, int cart_quantity);

	int deleteCartproductAll(int member_no);

}
