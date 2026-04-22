package com.ra34.projecte2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ra34.projecte2.model.Order;
import com.ra34.projecte2.model.OrderItem;
import com.ra34.projecte2.model.Producte;
import com.ra34.projecte2.repository.OrderItemRepository;
import com.ra34.projecte2.repository.OrderRepository;
import com.ra34.projecte2.repository.ProducteRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProducteRepository producteRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Transactional
    public Order saveProductesToOrder(Long orderId, List<Long> productesIds){ // 4. Gestió d'orders c (Integrant 2)
        Optional<Order> existingOrder = orderRepository.findById(orderId);

        if (!existingOrder.isPresent()) {
            return null;
        }

        Order order = existingOrder.get();
        
        for(Long producteId: productesIds){
            Optional<Producte> existingProducte = producteRepository.findById(producteId);

            if (!existingProducte.isPresent()) continue;

            Producte producte = existingProducte.get();

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProducte(producte);
            orderItem.setQuantity(1);
            orderItem.setUntilPrice(producte.getPrice());
        
            orderItemRepository.save(orderItem);

            order.setTotalAmount(order.getTotalAmount() + producte.getPrice());
            
        }

        return orderRepository.save(order);
    }

    @Transactional
    public Order cancelOrder(Long orderId){ // 4. Gestió d'orders d (Integrant 2)
        Optional<Order> existing = orderRepository.findById(orderId);

        if (!existing.isPresent()) {
            return null;
        }

        Order order = existing.get();

        if (!order.getOrderStatus().equals("PENDENT")) {
            return null;
        }

        order.setOrderStatus("CANCELAT");
        return orderRepository.save(order);
    }

}
