package com.ra34.projecte2.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", unique = true)
    private Order order;

    private String invoiceNumber;
    private Timestamp issueDate;
    private double textAmount;
    private double totalWithTax;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Order getOrderId() {
        return order;
    }
    public void setOrderId(Order order) {
        this.order = order;
    }
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    public Timestamp getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }
    public double getTextAmount() {
        return textAmount;
    }
    public void setTextAmount(double textAmount) {
        this.textAmount = textAmount;
    }
    public double getTotalWithTax() {
        return totalWithTax;
    }
    public void setTotalWithTax(double totalWithTax) {
        this.totalWithTax = totalWithTax;
    }
    public Invoice(Long id, Order order, String invoiceNumber, Timestamp issueDate, double textAmount,
            double totalWithTax) {
        this.id = id;
        this.order = order;
        this.invoiceNumber = invoiceNumber;
        this.issueDate = issueDate;
        this.textAmount = textAmount;
        this.totalWithTax = totalWithTax;
    }

    

}
