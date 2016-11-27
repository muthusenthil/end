/*package com.dao;



import java.util.List;

import com.model.Cart;
import com.model.CartItems;

public interface CartItemsDao {
	



		
		public void add(CartItems CartItems);
		public List<CartItems> getAllProduct(); 
		public void update(CartItems CartItems);
		public CartItems getProductById(int id);
		public void delete(int id);
		public void save(Cart cart);
			
		


	}*/



package com.dao;

import java.util.List;

import com.model.Cartpojo;
import com.model.Payment;
import com.model.CartItemspojo;

public interface CartItemsDao {

	public void add(CartItemspojo CartItem);
	public List getAllProductModel(String username); 
	public void update(CartItemspojo CartItem);
	public CartItemspojo getProductById(int id);
	public void delete(int id);
	public void save(Cartpojo cart);
	public List<Cartpojo> getallcartitems(int sid);
	public void saveorder(Payment pay);
}




