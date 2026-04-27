package com.ra34.projecte2.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra34.projecte2.dto.OrderRequestDTO;
import com.ra34.projecte2.dto.OrderResponseDTO;
import com.ra34.projecte2.mapper.OrderItemMapper;
import com.ra34.projecte2.mapper.OrderMapper;
import com.ra34.projecte2.model.Customer;
import com.ra34.projecte2.model.Order;
import com.ra34.projecte2.model.OrderItem;
import com.ra34.projecte2.model.Producte;
import com.ra34.projecte2.repository.CustomerRepository;
import com.ra34.projecte2.repository.OrderItemRepository;
import com.ra34.projecte2.repository.OrderRepository;
import com.ra34.projecte2.repository.ProducteRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProducteRepository producteRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Transactional
    public OrderResponseDTO createOrder(Long customerId, OrderRequestDTO request) {
        Optional<Customer> foundCustomer = customerRepository.findById(customerId);
        if (foundCustomer.isEmpty()) {
            return null;
        }
        Customer customer = foundCustomer.get();

        Order order = orderMapper.toEntity(request, customer);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        order.setDataCreated(now);
        order.setDataUpdated(now);
        Order savedOrder = orderRepository.save(order);

        double total = 0;
        List<Long> producteIds = request.getProducteIds();

        if (producteIds != null) {
            for (Long producteId : producteIds) {
                Optional<Producte> foundProducte = producteRepository.findById(producteId);
                if (foundProducte.isEmpty()) {
                    continue;
                }
                Producte producte = foundProducte.get();

                OrderItem item = orderItemMapper.toEntity(producte, savedOrder);
                orderItemRepository.save(item);

                savedOrder.getOrderItems().add(item);

                total += item.getQuantity() * item.getUntilPrice();
            }
        }

        savedOrder.setTotalAmount(total);
        savedOrder.setDataUpdated(new Timestamp(System.currentTimeMillis()));
        orderRepository.save(savedOrder);

        return orderMapper.toDto(savedOrder);
    }

    @Transactional
    public OrderResponseDTO processOrder(Long orderId) {
        Optional<Order> found = orderRepository.findById(orderId);
        if (found.isEmpty()) {
            return null;
        }

        Order order = found.get();

        if (!"PENDENT".equalsIgnoreCase(order.getOrderStatus())) {
            return null;
        }

        order.setOrderStatus("PROCESSAT");
        order.setDataUpdated(new Timestamp(System.currentTimeMillis()));
        orderRepository.save(order);

        return orderMapper.toDto(order);
    }
}
