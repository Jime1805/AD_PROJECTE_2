package com.ra34.projecte2.mapper;

import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.InvoiceRequestDTO;
import com.ra34.projecte2.dto.InvoiceResponseDTO;
import com.ra34.projecte2.model.Invoice;

@Component
public class InvoiceMapper {
    public InvoiceResponseDTO toDto(Invoice invoice){
        if (invoice == null) {
            return null;
        }

        InvoiceResponseDTO dto = new InvoiceResponseDTO(
            invoice.getId(),
            null,
            invoice.getInvoiceNumber(),
            invoice.getIssueDate(),
            invoice.getTextAmount(),
            invoice.getTotalWithTax()
        );

        if (invoice.getOrder() != null) {
            dto.setOrderId(invoice.getOrder().getId());
        }
        return dto;
    }

    public Invoice toEntity(InvoiceRequestDTO request){
        if (request == null) {
            return null;
        }

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(request.getInvoiceNumber());
        invoice.setIssueDate(request.getIssueDate());
        invoice.setTextAmount(request.getTaxAmount());
        invoice.setTotalWithTax(request.getTotalWithTax());

        return invoice;
    }
}
