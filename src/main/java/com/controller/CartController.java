/*
package com.controller;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.ui.ModelMap;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import com.model.CartItems;
	import com.model.ProductModel;
	import com.service.CartItemsService;
	import com.service.ProductService;

	@Controller
	public class CartController {
		
		@Autowired
		private CartItemsService cartService;                         //object creation
		@Autowired
		private ProductService productService;
		
	    @RequestMapping("/addtocart/{id}")                           //mapping id to get flow of addtocart
	   public String addtocart(@PathVariable("id")int id)
		{
			System.out.println("Entered cart adding controller");
			
			CartItems cart=new CartItems();
			ProductModel productModel=productService.getProductModel(id);
			List<CartItems> mycart =cartService.getAllProduct();
			for(int i=0;i<mycart.size();i++)
			{
				
				int tmid=mycart.get(i).getProductmodel().getId();
				if(tmid==id)
				{	System.out.println("inside if loop");
					int quantity=mycart.get(i).getQuantity()+1;
					mycart.get(i).setQuantity(quantity);
					double price=productModel.getPrice()*quantity;
					mycart.get(i).setTotalPrice(price);
				    cartService.update(mycart.get(i));
				 return "cate";
					
				}
			}
			
			cart.setQuantity(1);
			System.out.println("hyy");
			cart.setTotalPrice(productModel.getPrice());
			cart.setProductmodel(productModel);
		    cartService.add(cart);
		    return "cate";
		}
		
		@RequestMapping("delete/cart/{id}")
		public String delcart(@PathVariable("id")int id,ModelMap model)
		{	
			cartService.delete(id);
			return"redirect:/cart";
		}
		
		@RequestMapping("/cart")
		public String getcart(Model map )
		{
			CartItems cart=new CartItems();
			List<CartItems>mycart=cartService.getAllProduct();
			System.out.println("inside cart views");
			map.addAttribute("cart", cart);
			System.out.println("hoiii");
			map.addAttribute("cartList", cartService.getAllProduct());
			return "cartview";
		}
		
	}*/



package com.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.CartItemspojo;
import com.model.ProductModel;
import com.service.CartItemsService;
import com.service.ProductService;

@Controller
public class CartController {

	@Autowired(required=true)
	ProductService productservice;
	@Autowired(required=true)
	CartItemsService cartitemservice;
	
	
	public String username;
	 @ModelAttribute
	 
	public void getuserdata(HttpServletRequest hsreq)
	{
		Authentication authn = SecurityContextHolder.getContext().getAuthentication();
	      String name = authn.getName(); 
	      HttpSession session=hsreq.getSession();
	      session.setAttribute("name", name);
	      username=(String)session.getAttribute("name");
	      System.out.println((String)session.getAttribute("name"));
	     
	}
	
	Logger logger = Logger.getLogger(CartController.class.getName());
	@RequestMapping("addtocart/{id}")
	public String addtocart(@PathVariable("id")int id)
	{
		System.out.println("Entered to add");
		
		CartItemspojo cart=new CartItemspojo();
		cart.setUsername(username);
		ProductModel product=productservice.getProductModel(id);
		List<CartItemspojo> cartitems=cartitemservice.getAllProductModel(username);
		System.out.println(cartitems);
		for(int i=0;i<cartitems.size();i++)
		{
			System.out.println("entered for loop");
			int incid=cartitems.get(i).getProductmodel().getId();
			System.out.println(incid);
			System.out.println(id);
			if(incid==(id))
			{	
				System.out.println("entered if loop");
			    logger.info("if loop");
				int quantity=cartitems.get(i).getQuantity()+1;
				cartitems.get(i).setQuantity(quantity);
				double price=product.getPrice()*quantity;
				cartitems.get(i).setTotalPrice(price);
				System.out.println("Quantity increased");
				cartitemservice.update(cartitems.get(i));
				return "cate";
			}
		}
		
		cart.setQuantity(1);
		cart.setTotalPrice(product.getPrice());
		cart.setProductmodel(product);
		System.out.println("A");
		cartitemservice.add(cart);
		return "cate";
	}
	public String getusername()
	{
		System.out.println("CARTUSERNAME"+username);
		return username;
	}
	
	@RequestMapping("delete/cart/{id}")
	public String delcart(@PathVariable("id")int id,ModelMap model)
	{	System.out.println("cart delete worked");
		cartitemservice.delete(id);
		return"redirect:/cart";
	}
	
	@RequestMapping("/cart")
	public String getcart(Model map )
	{
		CartItemspojo cart=new CartItemspojo();
		List<CartItemspojo> cartitem=cartitemservice.getAllProductModel(username);
		map.addAttribute("cart", cart);
		map.addAttribute("cartList", cartitemservice.getAllProductModel(username));
		return "cartview";
	}
}
