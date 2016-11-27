/*package com.service;


import java.util.List;

import com.model.Cart;
import com.model.CartItems;
public interface CartItemsService {

		public void add(CartItems cart);
		public List<CartItems> getAllProduct();
		public CartItems getProductById(int id);
		public void update(CartItems cart);
		public void delete(int id);
		public void save(Cart cart);
		
	}
*/

package com.service;

import java.util.List;

import com.model.Cartpojo;
import com.model.Payment;
import com.model.CartItemspojo;

public interface CartItemsService {

	public void add(CartItemspojo cart);
	public List getAllProductModel(String username) ;
		// TODO Auto-generated method stub
	
	public CartItemspojo getProductById(int id);
	public void save(Cartpojo cart);
	public void update(CartItemspojo cart);
	public void delete(int id);
	public List<Cartpojo> getallcartitems(int sid);
	public void saveorder(Payment pay);
	
}


