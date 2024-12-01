package com.skg.order.mapper;
import com.skg.order.dtos.OrderDto;
import com.skg.order.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface mapperOrderMapper {

    mapperOrderMapper INSTANCE= Mappers.getMapper(mapperOrderMapper.class);

    OrderDto getOrderDtoFromOrder(Order order);

    Order getOrderFromOrderDto(OrderDto orderDto);



}
