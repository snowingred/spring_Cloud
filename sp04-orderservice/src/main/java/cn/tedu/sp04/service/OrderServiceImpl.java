package cn.tedu.sp04.service;

import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;
import sp01.pojo.Order;
import sp01.service.OrderService;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order getOrder(String orderId) {
        //TODO: 调用user-service获取用户信息
        //TODO: 调用item-service获取商品信息
        Order order = new Order();
        order.setId(orderId);
        return order;
    }

    @Override
    public void addOrder(Order order) {
        //TODO: 调用item-service减少商品库存
        //TODO: 调用user-service增加用户积分
        log.info("保存订单：" + order);
    }

}
