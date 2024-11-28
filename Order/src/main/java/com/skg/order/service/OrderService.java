package com.skg.order.service;

import com.skg.order.dtos.OrderDto;
import com.skg.order.dtos.OrderDtoFromFrontEnd;

public interface OrderService {

    OrderDto saveOrderInDb(OrderDtoFromFrontEnd dtoFromFrontEnd);
}
