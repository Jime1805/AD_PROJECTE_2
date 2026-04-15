package com.ra34.projecte2.mapper;

import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.InvoiceDTO;
import com.ra34.projecte2.dto.OrderDTO;
import com.ra34.projecte2.model.Order;

@Component
public class OrderMapper {
    public OrderDTO toDto(Order order){
        if (order == null) {
            return null;
        }
        
        OrderDTO dto = new OrderDTO(
            order.getId(),
            null, // añadir mapper
            order.getOrderDate(),
            order.getTotalAmount(),
            order.getOrderStatus(),
            order.getStatus(),
            order.getDataCreated(),
            order.getDataUpdated()
        ); 

        if(order.getInvoice() != null){
            InvoiceDTO iDto = new InvoiceDTO(
                order.getInvoice().getId(),
                null,
                order.getInvoice().getInvoiceNumber(),
                order.getInvoice().getIssueDate(),
                order.getInvoice().getTextAmount(),
                order.getInvoice().getTotalWithTax()
            );
            
            dto.setInvoice(iDto);
        }

        return dto;
    }
}
