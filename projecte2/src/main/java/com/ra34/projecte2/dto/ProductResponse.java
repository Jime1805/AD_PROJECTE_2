package com.ra34.projecte2.dto;

import com.ra34.projecte2.model.Condition;


public class ProductResponse {
    private Long id;
    
    private OrderItemDTO orderItem;
    
    private String nombre;
    private String descripcion;
    private int stock;
    private float price;
    private float rating;
    private Condition condition;
    
    public ProductResponse() {
    }

    public ProductResponse(Long id, OrderItemDTO orderItem, String nombre, String descripcion, int stock, float price,
            float rating, Condition condition) {
        this.id = id;
        this.orderItem = orderItem;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.price = price;
        this.rating = rating;
        this.condition = condition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public OrderItemDTO getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItemDTO orderItem) {
        this.orderItem = orderItem;
    }

    
}
