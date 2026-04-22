package com.ra34.projecte2.dto;

import java.sql.Timestamp;
import java.util.List;

public class OrderRequestDTO {
    private Timestamp orderDate;
    private List<Long> producteIds;
    
    public Timestamp getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
    public List<Long> getProducteIds() {
        return producteIds;
    }
    public void setProducteIds(List<Long> producteIds) {
        this.producteIds = producteIds;
    }
    public OrderRequestDTO() {
    }
    public OrderRequestDTO(Timestamp orderDate, List<Long> producteIds) {
        this.orderDate = orderDate;
        this.producteIds = producteIds;
    }

    
}