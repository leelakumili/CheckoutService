package com.leela.async.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.leela.async.model.OrderInfo;

public interface CheckoutRepository extends 
JpaRepository<OrderInfo, Long>{
OrderInfo findByid(Long id) ;


}
