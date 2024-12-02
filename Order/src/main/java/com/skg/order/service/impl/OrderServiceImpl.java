package com.skg.order.service.impl;

import com.skg.order.dtos.OrderDto;
import com.skg.order.dtos.OrderDtoFromFrontEnd;
import com.skg.order.dtos.User;
import com.skg.order.entities.Order;
import com.skg.order.mapper.mapperOrderMapper;
import com.skg.order.repo.OrderRepo;
import com.skg.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private WebClient webClient;


    private final SequenceGenerator sequenceGenerator;

    OrderServiceImpl(SequenceGenerator sequenceGenerator)
    {
        this.sequenceGenerator=sequenceGenerator;
    }

    @Override
    public OrderDto saveOrderInDb(OrderDtoFromFrontEnd dtoFromFrontEnd) {
        User user = fetchUserDetailsFromUserId(dtoFromFrontEnd.getUserId());
        Order order = new Order(sequenceGenerator.generateNextOrderId(), dtoFromFrontEnd.getFoodItemsList(), dtoFromFrontEnd.getRestaurent(), user);
        return mapperOrderMapper.INSTANCE.getOrderDtoFromOrder(orderRepo.save(order));
    }

    private User fetchUserDetailsFromUserId(Integer userId) {
        return webClient.get()
                .uri("http://localhost:5002/user/fetchUserById/{userId}",userId)
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        //clientResponse -> Mono.empty()
                         clientResponse -> Mono.error(new RuntimeException("User not found !!")))
                .bodyToMono(User.class)
                .doOnError(error -> log.error("Error Fetching User Details !! ", error.getMessage()))
                .block();
    }
}
