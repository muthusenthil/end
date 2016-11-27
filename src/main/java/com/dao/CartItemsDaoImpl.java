package com.dao;
 
import java.util.List;

	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.CartItemspojo;
import com.model.Cartpojo;
import com.model.Payment;
import com.model.ProductModel;
	import com.model.UserBean;

	@Repository
	@Transactional
	public class CartItemsDaoImpl implements CartItemsDao {
		@Autowired
		private SessionFactory sessionFactory;

		@Override
		public void add(CartItemspojo cartItems) {
			sessionFactory.getCurrentSession().save(cartItems);
		}
/*@Override
		public List<CartItemspojo> getAllProduct() {
			System.out.println("getting all product in CartItems");
			return sessionFactory.getCurrentSession().createQuery("from CartItems ").list();

		}*/
@Override
		public void update(CartItemspojo cartItems) {
			sessionFactory.getCurrentSession().update(cartItems);
		}
@Override
		public CartItemspojo getProductById(int id) {
			System.out.println((CartItemspojo)sessionFactory.getCurrentSession().get(CartItemspojo.class, id));
			return (CartItemspojo)sessionFactory.getCurrentSession().get(CartItemspojo.class, id);
		}
@Override
		public void delete(int id) {
			System.out.println("CartItemsDaoImpl Delete");
			sessionFactory.getCurrentSession().delete(getProductById(id));
			
		}
@Override
public void save(Cartpojo cart) {
	System.out.println("ADDED TO SAVE");
	sessionFactory.getCurrentSession().save(cart);
	// TODO Auto-generated method stub
	
}
@Override
public List getAllProductModel(String username) {
	return sessionFactory.getCurrentSession().createQuery("from newcartitems where USERNAME='"+username+"'").list();
	// TODO Auto-generated method stub
	
}
@SuppressWarnings("unchecked")
@Override
public List<Cartpojo> getallcartitems(int sid) {
	// TODO Auto-generated method stub
	return sessionFactory.getCurrentSession().createQuery("from NEWCART where SHIPPINGID='"+sid+"'").list();
}
@Override
public void saveorder(Payment pay) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().save(pay);
}

		


	}



