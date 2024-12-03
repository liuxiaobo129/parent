package org.example.shardingsphere;


import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_order")
public class Order {

    // 主键，使用雪花算法生成
    private Long orderId;

    // 用户ID，分片键
    private Long userId;

    // 订单状态
    private String status;

    // 无参构造函数
    public Order() {
    }

    // 带参构造函数
    public Order(Long orderId, Long userId, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.status = status;
    }

    // Getter 和 Setter 方法

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString 方法，便于调试和打印对象
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                '}';
    }
}