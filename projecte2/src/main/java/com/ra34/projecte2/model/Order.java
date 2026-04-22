package com.ra34.projecte2.model;

import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer; 

    private Timestamp orderDate;
    private double totalAmount;
    private String orderStatus;
    private Boolean status;

    private Timestamp dataCreated;
    private Timestamp dataUpdated;
    
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
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Timestamp getDataCreated() {
        return dataCreated;
    }
    public void setDataCreated(Timestamp dataCreated) {
        this.dataCreated = dataCreated;
    }
    public Timestamp getDataUpdated() {
        return dataUpdated;
    }
    public void setDataUpdated(Timestamp dataUpdated) {
        this.dataUpdated = dataUpdated;
    }
    public Invoice getInvoice() {
        return invoice;
    }
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    public Customer getCustomers() {
        return customer;
    }
    public void setCustomers(Customer customer) {
        this.customer = customer;
    }
    public Order(Long id, Invoice invoice, Customer customer, Timestamp orderDate, double totalAmount,
            String orderStatus, Boolean status, Timestamp dataCreated, Timestamp dataUpdated) {
        this.id = id;
        this.invoice = invoice;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.status = status;
        this.dataCreated = dataCreated;
        this.dataUpdated = dataUpdated;
    }    
}
