package com.ootd.ootdApp.order.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ootd.ootdApp.order.model.dao.OrderDAO;
import com.ootd.ootdApp.order.model.vo.Cart;
import com.ootd.ootdApp.order.model.vo.Order;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDAO orderDAO;

	@Override
	public List<Cart> selectCartList(int member_no) {
		
		return orderDAO.selectCartList(member_no);
	}

	@Override
	public int deleteCartProduct(int cart_no) {
		
		return orderDAO.deleteCartProduct(cart_no);
	}

	@Override
	public int deleteCartproductAll(int member_no) {
		
		return orderDAO.deleteCartProductAll(member_no);
	}
	

	@Override
	public int updateQuantity(Map<String, String> map) {
		
		return orderDAO.updateQuantity(map);
	}

	@Override
	public List<Cart> selectedCartList(int cart_no) {
		
		return orderDAO.selectedCartList(cart_no);
	}

	@Override
	public int insertOrder(Order order) {
		
		return orderDAO.insertOrder(order);
	}


}
