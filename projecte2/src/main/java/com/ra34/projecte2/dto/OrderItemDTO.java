package com.ra34.projecte2.dto;

public class OrderItemDTO {
    private Long id;
    private OrderDTO order;
    private ProductResponse producte;
    private int quantity;
    private double untilPrice;
    
    public OrderItemDTO() {
    
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public ProductResponse getProducte() {
        return producte;
    }

    public void setProducte(ProductResponse producte) {
        this.producte = producte;
    }

    public double getUntilPrice() {
        return untilPrice;
    }

    public void setUntilPrice(double untilPrice) {
        this.untilPrice = untilPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderItemDTO(Long id, OrderDTO order, ProductResponse producte, int quantity, double untilPrice) {
        this.id = id;
        this.order = order;
        this.producte = producte;
        this.quantity = quantity;
        this.untilPrice = untilPrice;
    }    
}
