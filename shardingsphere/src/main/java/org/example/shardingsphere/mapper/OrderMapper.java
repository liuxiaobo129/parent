package org.example.shardingsphere.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.shardingsphere.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO t_order (order_id, user_id, status) VALUES (#{orderId}, #{userId}, #{status})")
    void insertOrder(Order order);

    List<Order> selectOrderById(@Param("id") Long order_id);
}
