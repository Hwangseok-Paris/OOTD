package com.ootd.ootdApp.order.model.service;

import java.util.List;

import com.ootd.ootdApp.order.model.vo.Cart;

public interface OrderService {
	
	List<Cart> selectCartList(int member_no);

}
