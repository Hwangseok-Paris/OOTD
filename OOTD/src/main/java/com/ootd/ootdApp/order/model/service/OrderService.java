package com.ootd.ootdApp.order.model.service;

import java.util.List;
import java.util.Map;

import com.ootd.ootdApp.order.model.vo.Cart;
import com.ootd.ootdApp.order.model.vo.Order;

public interface OrderService {
	
	List<Cart> selectCartList(int member_no);
	
	int deleteCartProduct(int cart_no);


	int deleteCartproductAll(int member_no);

	int updateQuantity(Map<String, String> map);

	List<Cart> selectedCartList(int cart_no);

	int insertOrder(Order order);



}
