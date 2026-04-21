package com.ra34.projecte2.mapper;

import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.InvoiceResponseDTO;
import com.ra34.projecte2.dto.OrderRequestDTO;
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
}
