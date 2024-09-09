package demo.example.service;

import demo.example.model.*;

public interface ShoppingcartService {
	
	Shoppingcart createShoppingcart(Shoppingcart shoppingcart);
		
	void deleteShoppingcart(ShoppingcartPK id);
}