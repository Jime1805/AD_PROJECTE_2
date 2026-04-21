package com.ra34.projecte2.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private Long id;
    private InvoiceDTO invoice;
    
    //private Customer customers;

    //añadir OrderItem
    private List<OrderItemDTO> orderItems = new ArrayList<>();

    private Timestamp orderDate;
    private double totalAmount;
    private String orderStatus;
    //private Boolean status;
    
    public OrderDTO(Long id, InvoiceDTO invoice, List<OrderItemDTO> orderItems, Timestamp orderDate, double totalAmount,
            String orderStatus) {
        this.id = id;
        this.invoice = invoice;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InvoiceDTO getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDTO invoice) {
        this.invoice = invoice;
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

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    } 
}
