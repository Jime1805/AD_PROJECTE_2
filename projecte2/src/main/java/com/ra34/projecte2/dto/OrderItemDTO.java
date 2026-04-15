package com.ra34.projecte2.dto;

import java.sql.Timestamp;

public class OrderItemDTO {
    private Long id;
    private OrderDTO order;
    private String invoiceNumber;
    private Timestamp issueDate;
    private double textAmount;
    private double totalWithTax;
    
    public OrderItemDTO() {
    
    }

    public OrderItemDTO(Long id, OrderDTO order, String invoiceNumber, Timestamp issueDate, double textAmount,
            double totalWithTax) {
        this.id = id;
        this.order = order;
        this.invoiceNumber = invoiceNumber;
        this.issueDate = issueDate;
        this.textAmount = textAmount;
        this.totalWithTax = totalWithTax;
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
}
