package com.model;

import java.util.Date;
import java.util.List;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.controller.CartController;
import com.dao.ProductDaoImpl;
import com.service.CartItemsService;

//import com.service.PayOrderService;
import com.service.ProductService;
import com.service.ShippingService;


@Component
public class ShipHandler {
	
	/*@Autowired
 PayOrderService payorderservice;*/
	@Autowired
	ProductService ps;
	@Autowired
	private CartItemsService ci;
	@Autowired
	CartController cc;
	
	@Autowired
	HttpServletRequest hsr;
	
	public Shipping initFlow(){
		//shipping obj created
		return new Shipping();
	}
	
	@Autowired
	ShippingService shipser;
	
	public void saveaddress(Shipping shipping)
	{
		/*String username;
		Authentication authn=SecurityContextHolder.getContext().getAuthentication();
		String name=authn.getName();
		HttpSession hs= hsr.getSession();
		hs.setAttribute("name",name);
		username=(String)hs.getAttribute("name");
		UserBean userBean=new UserBean();
		userBean.setUserName(username);
		shipping.setUserBean(userBean);
		int id=shipping.getShippingid();
//		int id=shipping.getShippingid();
		shipser.save(shipping);*/
		shipser.saveorupdate(shipping);
		
		
	}
	
	public void savecart(Shipping shipping)
	{
		/*Cartpojo cart=new Cartpojo();
		List<CartItemspojo> cartitems=ci.getAllProduct();
		System.out.println("cart save");
		double total=0;
		for(int i=0;i<cartitems.size();i++)
		{
			System.out.println("cart save for loop");
			total+=cartitems.get(i).getTotalPrice();
		}
		cart.setGrandTotal(total);
		int sid=shipping.getShippingid();
		
		cart.setUserBean((shipping.getUserBean()));
		cart.setShipping(shipser.getbyid(sid));
		
		for(int j=0;j<cartitems.size();j++)
		{
			int id=cartitems.get(j).getCartItemId();
			CartItems cartitemobj=ci.getProductById(id);
			cart.setCartitems(cartitemobj);
			ci.save(cart);
		}*/
		
		Cartpojo cart=new Cartpojo();
		cart.setShipping(shipping);
		String username=cc.getusername();
		List<CartItemspojo> cartitems=ci.getAllProductModel(username);
		double tot=0;
		for(int i=0;i<cartitems.size();i++){
			System.out.println("cart save for loop");
			tot+=cartitems.get(i).getTotalPrice();
			}
		cart.setGrandTotal(tot);
		for(int j=0;j<cartitems.size();j++){
			System.out.println("cart second loop");
			CartItemspojo singlecartitem=cartitems.get(j);
			int pid=singlecartitem.getProductmodel().getId();
			int Quantity=singlecartitem.getQuantity();
			cart.setQuantity(Quantity);
			cart.setTotalprize(singlecartitem.getTotalPrice());
			System.out.println("cart saved");
			ci.save(cart);
			System.out.println("cart saved 2");
		}
	}
	
	/*
	public void savecart(Shipping shipping)
	{
		Cart cart=new Cart();
		List<CartItems> cartitems=ci.getAllProduct();
		double total=0;
		for(int i=0;i<cartitems.size();i++)
		{
			total+=cartitems.get(i).getTotalPrice();
			
		}
		
		cart.setGrandTotal(total);
		int shippingid=shipping.getShippingid();
		cart.setUserBean((shipping.getUserBean()));
		cart.setShipping(shipping);
		for(int j=0;j<cartitems.size();j++){
			int id=cartitems.get(j).getProductmodel().getId();
			ProductModel product=ps.getProductModel(id);
			cart.setProduct(product);
			int quantity=cartitems.get(j).getQuantity();
			double totalprice=cartitems.get(j).getTotalPrice();
			cart.setQuantity(quantity);
			cart.setTotalprice(totalprice);
			shipser.savecart(cart);
			
		}*/
	
	public void saveorder(Shipping shipping){
		Payment pay=new Payment();
		int sid=shipping.getShippingid();
		Date today=Calendar.getInstance().getTime();
		pay.setOrderdate(today.toString());
		pay.setUserBean(cc.getusername());
		System.out.println("username");
		List<Cartpojo> cp=ci.getallcartitems(sid);
		for(int i=0;i<cp.size();i++){
			pay.setCart(cp.get(i));
			ci.saveorder(pay);
		}
	}
}
		
	
	
	
	
	
	


