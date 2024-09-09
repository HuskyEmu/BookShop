package demo.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.example.model.*;

@Service
public class ShoppingcartServiceImpl implements ShoppingcartService {

	@Autowired
	private  ShoppingcartRepository sr;

	@Override
	public Shoppingcart createShoppingcart(Shoppingcart shoppingcart) {
		return sr.save(shoppingcart);
	}

	@Override
	public void deleteShoppingcart(ShoppingcartPK id) {
		// TODO Auto-generated method stub
		sr.deleteById((ShoppingcartPK) id);
	}


	

}
