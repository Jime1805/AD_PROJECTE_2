package com.ra34.projecte2.mapper;

import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.InvoiceDTO;
import com.ra34.projecte2.dto.OrderDTO;
import com.ra34.projecte2.model.Invoice;

@Component
public class InvoiceMapper {
    public InvoiceDTO toDto(Invoice invoice){
        if (invoice == null) {
            return null;
        }

        InvoiceDTO dto = new InvoiceDTO(
            invoice.getId(),
            null,
            invoice.getInvoiceNumber(),
            invoice.getIssueDate(),
            invoice.getTextAmount(),
            invoice.getTotalWithTax()
        );

        if (invoice.getOrder() != null) {
            OrderDTO oDto = new OrderDTO(
                invoice.getOrder().getId(),
                null, // añadir mapper
                null,
                invoice.getOrder().getOrderDate(),
                invoice.getOrder().getTotalAmount(),
                invoice.getOrder().getOrderStatus()
            );
            dto.setOrder(oDto);
        }
        return dto;
    }
}
