package com.leela.async.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leela.async.model.OrderInfo;
import com.leela.async.repo.CheckoutRepository;

@Component
public class CheckoutBR {
	
	
	@Autowired
	  private CheckoutRepository repository;
	
	
	   public OrderInfo getOrderDetails(Long orderId) {
		   
		   OrderInfo order = 
			        repository.findByid(orderId);  
		   
	
		   order.setOrderTotal(order.getSubtotal()+ order.getTax());
		   
		   return order;
	   }
	   
	   

}
