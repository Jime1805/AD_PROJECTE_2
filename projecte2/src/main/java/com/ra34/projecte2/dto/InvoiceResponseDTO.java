package com.ra34.projecte2.dto;

import java.sql.Timestamp;

public class InvoiceResponseDTO {
    private Long id;
    private Long orderId;
    private String invoiceNumber;
    private Timestamp issueDate;
    private double taxAmount;
    private double totalWithTax;

    public InvoiceResponseDTO() {
    
    }
    
    public InvoiceResponseDTO(Long id, Long orderId, String invoiceNumber, Timestamp issueDate, double taxAmount,
            double totalWithTax) {
        this.id = id;
        this.orderId = orderId;
        this.invoiceNumber = invoiceNumber;
        this.issueDate = issueDate;
        this.taxAmount = taxAmount;
        this.totalWithTax = totalWithTax;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
    public double getTaxAmount() {
        return taxAmount;
    }
    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }
    public double getTotalWithTax() {
        return totalWithTax;
    }
    public void setTotalWithTax(double totalWithTax) {
        this.totalWithTax = totalWithTax;
    }

    
    
}