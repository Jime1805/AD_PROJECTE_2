package com.ra34.projecte2.dto;

public class OrderItemResponseDTO {
    private Long id;
    private int quantity;
    private double unitPrice;
    private ProducteResponseDTO producte;

    public OrderItemResponseDTO(Long id, int quantity, double unitPrice, ProducteResponseDTO producte) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.producte = producte;
    }

    public OrderItemResponseDTO() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public ProducteResponseDTO getProducte() {
        return producte;
    }

    public void setProducte(ProducteResponseDTO producte) {
        this.producte = producte;
    }

    
}