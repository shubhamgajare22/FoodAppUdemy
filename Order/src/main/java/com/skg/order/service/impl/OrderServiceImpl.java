package com.skg.order.service.impl;

import com.skg.order.dtos.OrderDto;
import com.skg.order.dtos.OrderDtoFromFrontEnd;
import com.skg.order.repo.OrderRepo;
import com.skg.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public OrderDto saveOrderInDb(OrderDtoFromFrontEnd dtoFromFrontEnd) {

        return null;
    }
}
