package com.ra34.projecte2.dto;

import java.sql.Timestamp;

public class InvoiceRequestDTO {
    private String invoiceNumber;
    private Timestamp issueDate;
    private double taxAmount;
    private double totalWithTax;
    
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

    public InvoiceRequestDTO() {
    }

    public InvoiceRequestDTO(String invoiceNumber, Timestamp issueDate, double taxAmount, double totalWithTax) {
        this.invoiceNumber = invoiceNumber;
        this.issueDate = issueDate;
        this.taxAmount = taxAmount;
        this.totalWithTax = totalWithTax;
    }

    
}