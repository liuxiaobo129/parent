package org.example.shardingsphere;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO t_order (order_id, user_id, status) VALUES (#{orderId}, #{userId}, #{status})")
    void insertOrder(Order order);
}
