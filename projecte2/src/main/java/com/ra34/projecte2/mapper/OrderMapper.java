package com.ra34.projecte2.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.InvoiceDTO;
import com.ra34.projecte2.dto.OrderDTO;
import com.ra34.projecte2.dto.OrderItemDTO;
import com.ra34.projecte2.model.Order;
import com.ra34.projecte2.model.OrderItem;

@Component
public class OrderMapper {

    public OrderDTO toDto(Order order) {
        if (order == null) {
            return null;
        }

        OrderDTO dto = new OrderDTO(
            order.getId(),
            null, // l'invoice s'afegeix a continuació
            null, // els orderItems s'afegeixen a continuació
            order.getOrderDate(),
            order.getTotalAmount(),
            order.getOrderStatus()
        );

        // Mapeja l'invoice si existeix
        if (order.getInvoice() != null) {
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

        if (order.getOrderItems() != null) {
            List<OrderItemDTO> itemDtos = new ArrayList<>();

            for (OrderItem item : order.getOrderItems()) {
                OrderItemDTO oiDto = new OrderItemDTO(
                    item.getId(),
                    null,
                    null,
                    item.getQuantity(),
                    item.getUntilPrice()
                );
                itemDtos.add(oiDto);
            }

            dto.setOrderItems(itemDtos);
        }

        return dto;
    }
}