package com.seeu.order.controller;

import com.seeu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //创建订单
    @RequestMapping(value = "produce",method = RequestMethod.POST)
    public String produceOrder(@RequestAttribute("UID") Integer UID, @RequestAttribute("TID") Integer TID, @RequestParam("money") BigDecimal money, @RequestParam("note") String note) {
        return orderService.orderIt(UID, TID, money, note);
    }

    //支付该订单
    @RequestMapping(value = "purchase",method = RequestMethod.POST)
    public String purchaseOrder(@RequestAttribute("UID") Integer UID, @RequestAttribute("order_id") Integer id) {
        return orderService.purchaseOrder(UID, id);
    }

    //完成订单
    @RequestMapping(value = "finish",method = RequestMethod.POST)
    public String finishOrder(@RequestAttribute("order_id") Integer id) {
        return orderService.finishOrder(id);
    }
}
