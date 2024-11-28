package com.skg.order.controllers;

import com.skg.order.dtos.OrderDto;
import com.skg.order.dtos.OrderDtoFromFrontEnd;
import com.skg.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class orderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFromFrontEnd dtoFromFrontEnd) {
        OrderDto orderInDb = this.orderService.saveOrderInDb(dtoFromFrontEnd);
        return ResponseEntity.status(HttpStatus.OK).body(orderInDb);
    }

}
