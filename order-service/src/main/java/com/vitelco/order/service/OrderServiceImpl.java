package com.vitelco.order.service;

import com.vitelco.order.model.Order;
import com.vitelco.order.model.OrderItem;
import com.vitelco.order.model.dto.OrderItemDto;
import com.vitelco.order.model.dto.request.OrderRequest;
import com.vitelco.order.model.dto.response.OrderResponse;
import com.vitelco.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    /**
     * PlaceOrder
     *
     * @param orderRequest
     */
    @Override
    public void placeOrder(OrderRequest orderRequest) {
        orderRepository.save(orderRequest.convert());
    }

    /**
     * Fetches all orders from the database.
     *
     * @return A list containing all the orders available in the database.
     */
    @Override
    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList()
                ;
    }

    private OrderResponse mapToResponse(Order order){
        return OrderResponse.builder()
                .id(order.getId())
                .orderItems(
                        order.getOrderItems().stream().map(this::mapToOrderItemDto).collect(Collectors.toList())
                )
                .customerName(order.getCustomerName())
                .createdDated(order.getCreatedDated())
                .build();
    }

    private OrderItemDto mapToOrderItemDto(OrderItem orderItem){
        return OrderItemDto.builder()
                .id(orderItem.getId())
                .sku(orderItem.getSku())
                .qty(orderItem.getQty())
                .name(orderItem.getName())
                .createdDated(orderItem.getCreatedDated())
                .price(orderItem.getPrice())
                .build();
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }


}
