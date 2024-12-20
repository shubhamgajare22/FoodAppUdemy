package com.skg.order.service.impl;

import com.skg.order.dtos.*;
import com.skg.order.entities.Order;
import com.skg.order.repo.OrderRepo;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepo orderRepo;

    @Mock
    private SequenceGenerator sequenceGenerator;

    @InjectMocks
    OrderServiceImpl orderService;

    private MockWebServer mockWebServer;

    @BeforeEach
    void setUp() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        String baseUrl = mockWebServer.url("/").toString();
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();

        orderService = new OrderServiceImpl(sequenceGenerator, webClient, orderRepo);
    }

    @Test
    void saveOrderInDbTest() {
        OrderDtoFromFrontEnd dtoFromFrontEnd = new OrderDtoFromFrontEnd();
        FoodItems foodItems1 = new FoodItems();
        foodItems1.setId(1);
        foodItems1.setItemName("dal");
        foodItems1.setItemDescription("this food is very good");
        foodItems1.setQuantity(20);

        List<FoodItems> foodItemsList = Arrays.asList(foodItems1);
        dtoFromFrontEnd.setFoodItemsList(foodItemsList);

        Restaurent restaurent = new Restaurent();
        dtoFromFrontEnd.setRestaurent(restaurent);
        dtoFromFrontEnd.setUserId(1);

        User user = new User();
        user.setUserId(1);
        user.setUserName("Test User");

        Order order = new Order(1, foodItemsList, restaurent, user);

        when(sequenceGenerator.generateNextOrderId()).thenReturn(1);
        when(orderRepo.save(any(Order.class))).thenReturn(order);

        String jsonResponse = "{\"userId\":1,\"userName\":\"Test User\",\"userPassword\":\"password\",\"address\":\"address\",\"city\":\"city\"}";
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody(jsonResponse)
        );

        OrderDto result = orderService.saveOrderInDb(dtoFromFrontEnd);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getOrderId());
    }
}