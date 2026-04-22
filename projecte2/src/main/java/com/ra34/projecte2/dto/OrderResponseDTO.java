package com.ra34.projecte2.dto;

import java.sql.Timestamp;
import java.util.List;

// DTO per retornar la informació d'un order sense camps sensibles
// (sense status, dataCreated, dataUpdated)
public class OrderResponseDTO {
    private Long id;
    private Timestamp orderDate;
    private double totalAmount;
    private String orderStatus;
    private List<OrderItemResponseDTO> orderItems;
    private InvoiceResponseDTO invoice;

    public OrderResponseDTO(Long id, Timestamp orderDate, double totalAmount, String orderStatus,
            List<OrderItemResponseDTO> orderItems, InvoiceResponseDTO invoice) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.orderItems = orderItems;
        this.invoice = invoice;
    }

    public OrderResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItemResponseDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemResponseDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public InvoiceResponseDTO getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceResponseDTO invoice) {
        this.invoice = invoice;
    }

    
}