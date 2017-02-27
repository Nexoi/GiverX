package com.seeu.order.controller;

import com.seeu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by neo on 23/02/2017.
 * <p>
 * 如果用户获取了该任务（take），则产生该订单信息
 * <p>
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("produce")
    public String produceOrder(@RequestAttribute("UID") Integer UID, @RequestAttribute("TID") Integer TID, @RequestParam("money") BigDecimal money, @RequestParam("note") String note) {
        return orderService.orderIt(UID, TID, money, note);
    }

    @RequestMapping("finish")
    public String finishOrder(@RequestAttribute("order_id") Integer id) {
        return orderService.finishOrder(id);
    }
}
