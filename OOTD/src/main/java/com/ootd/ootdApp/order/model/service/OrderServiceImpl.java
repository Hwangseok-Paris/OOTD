package com.ootd.ootdApp.order.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ootd.ootdApp.order.model.dao.OrderDAO;
import com.ootd.ootdApp.order.model.vo.Cart;


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
	public int updateQuantity(int cart_no, int cart_quantity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
