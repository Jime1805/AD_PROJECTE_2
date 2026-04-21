package com.ra34.projecte2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "producteId")
    private Producte producte;

    private int quantity;
    private double untilPrice;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Producte getProducte() {
        return producte;
    }
    public void setProducte(Producte producte) {
        this.producte = producte;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getUntilPrice() {
        return untilPrice;
    }
    public void setUntilPrice(double untilPrice) {
        this.untilPrice = untilPrice;
    }
    
    public OrderItem(Long id, Order order, Producte producte, int quantity, double untilPrice) {
        this.id = id;
        this.order = order;
        this.producte = producte;
        this.quantity = quantity;
        this.untilPrice = untilPrice;
    }

    public OrderItem() {
    }

    
}