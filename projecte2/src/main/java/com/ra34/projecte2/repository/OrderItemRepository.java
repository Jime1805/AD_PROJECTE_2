package com.ra34.projecte2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ra34.projecte2.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
}
