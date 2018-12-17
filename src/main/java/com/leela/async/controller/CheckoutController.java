package com.leela.async.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leela.async.business.CheckoutBR;
import com.leela.async.model.OrderInfo;
import com.leela.async.repo.CheckoutRepository;

@RestController
public class CheckoutController {
	
	 @Autowired
	  private CheckoutBR checkoutBR;
	 
	 @Autowired
	  private ShippingService shippingService;
	  
	  @GetMapping("/checkout/order/{orderNumber}")
	  @ResponseBody
	  public OrderInfo getOrderInfo
	    (@PathVariable Long orderNumber){
	    
	    OrderInfo order = 
	        checkoutBR.getOrderDetails(orderNumber);
	    
	    Double shippingCharges = shippingService.calculateShippingCharges(order.getShipping());
	    
	    order.setOrderTotal(order.getOrderTotal()+ shippingCharges);
	    
	    return order;
	  }
}
