/*package com.service;
	
	
	

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

	import com.dao.CartItemsDao;
import com.model.Cart;
import com.model.CartItems;
	@Service
	
	public class CartItemsServiceImpl implements CartItemsService {

		@Autowired
		private CartItemsDao cartDao;
		
		@Transactional
		public void add(CartItems cart) {
			System.out.println("adding in cart service");
			cartDao.add(cart);
			
		}

		@Transactional
		public List<CartItems> getAllProduct() {/////change
			return cartDao.getAllProduct();
		}

		@Transactional
		public void update(CartItems cart) {
			cartDao.update(cart);
		}

		@Transactional
		public CartItems getProductById(int id) {
			
			return cartDao.getProductById(id);
		}

		@Transactional
		public void delete(int id) {
			 cartDao.delete(id);
		}

		@Override
		public void save(Cart cart) {
			cartDao.save(cart);
			// TODO Auto-generated method stub
			
		}

		@Override
		public List getAllProductModel(String username) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	

*/




package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CartItemsDao;
import com.model.Cartpojo;
import com.model.Payment;
import com.model.CartItemspojo;

@Service
@Transactional
public class CartItemsServiceImpl implements CartItemsService {

	@Autowired
	private CartItemsDao cartDao;
	
	@Transactional
	public void add(CartItemspojo cart) {
		System.out.println("adding in cart service");
		cartDao.add(cart);
		
	}

	@Transactional
	public List getAllProductModel(String username) {
		return cartDao.getAllProductModel(username);
	}

	@Transactional
	public void update(CartItemspojo cart) {
		cartDao.update(cart);
	}

	@Transactional
	public CartItemspojo getProductById(int id) {
		return cartDao.getProductById(id);
	}

	@Transactional
	public void delete(int id) {
		 cartDao.delete(id);
	}

	@Override
	public void save(Cartpojo cart) {
		cartDao.save(cart);
	}

	@Override
	public List<Cartpojo> getallcartitems(int sid) {
		// TODO Auto-generated method stub
		return cartDao.getallcartitems(sid);
	}

	@Override
	public void saveorder(Payment pay) {
		// TODO Auto-generated method stub
		cartDao.saveorder(pay);
	}

	
	


}
