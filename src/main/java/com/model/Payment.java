package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity(name="ORDERTABLE")
@Table
@Component
public class Payment {
	
	@Id
	@GeneratedValue
	private int payid;
	
	
	@ManyToOne
	private Cartpojo cart;
	
	
	@JoinColumn(name="userName")
	private String userBean;
	
	
	private String orderdate;


	public int getPayid() {
		return payid;
	}


	public void setPayid(int payid) {
		this.payid = payid;
	}


	public Cartpojo getCart() {
		return cart;
	}


	public void setCart(Cartpojo cart) {
		this.cart = cart;
	}





	public String getUserBean() {
		return userBean;
	}


	public void setUserBean(String userBean) {
		this.userBean = userBean;
	}


	public String getOrderdate() {
		return orderdate;
	}


	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
}
