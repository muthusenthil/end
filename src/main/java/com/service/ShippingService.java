package com.service;

import com.model.Cartpojo;
import com.model.Shipping;

public interface ShippingService {
	
	public void saveorupdate(Shipping shipping);
	
	public Shipping getbyid(int id);
	}

	/*public void savecart(Cart cart);*/      ////change


