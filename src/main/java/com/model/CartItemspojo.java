package com.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity(name="newcartitems")
@Table
@Component	
public class CartItemspojo {


	

		@Id
	    @GeneratedValue
	    private int cartItemId;
		
		
		private String username;

	    @ManyToOne
	    @JoinColumn(name = "Id")
	    private ProductModel productmodel;

	    private int quantity;
	    private double totalPrice;
		public int getCartItemId() {
			return cartItemId;
		}
		public void setCartItemId(int cartItemId) {
			this.cartItemId = cartItemId;
		}
		
		public ProductModel getProductmodel() {
			return productmodel;
		}
		public void setProductmodel(ProductModel productmodel) {
			this.productmodel = productmodel;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}
		public List<CartItemspojo> getCartItems() {
			// TODO Auto-generated method stub
			return null;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
	}


