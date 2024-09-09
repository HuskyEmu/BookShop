package demo.example.service;

import java.util.List;

import demo.example.model.*;

public interface ShoppingcartViewService {

	List<ShoppingcartView> getAllShoppingcartView();
	
	List<ShoppingcartView> getShoppingcartViewByMemberId(String memberId);
}
