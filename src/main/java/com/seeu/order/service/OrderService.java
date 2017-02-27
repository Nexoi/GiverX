package com.seeu.order.service;

import com.TP;
import com.TurnBackUtil;
import com.seeu.order.dao.OrderInfoMapper;
import com.seeu.order.model.OrderInfo;
import com.seeu.userpay.service.SeeUAccountPay;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Created by neo on 28/02/2017.
 */
@Service
public class OrderService {

    @Autowired
    TurnBackUtil turnBackUtil;
    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Autowired
    SeeUAccountPay pay;

    public String orderIt(Integer UID, Integer TID, BigDecimal money, String note) {
        try {
            OrderInfo info = new OrderInfo();
            info.setMoney(money);
            info.setNote(note);
            info.setUID(UID);
            info.setTID(TID);
            orderInfoMapper.insert(info);
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "订单创建成功", null);
        } catch (Exception e) {
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "订单创建失败，服务器异常", null);
        }
    }

    private static int STATUS_FINISH = 2;

    public String finishOrder(Integer id) {
        if (id == null || id <= 0) return turnBackUtil.formIt(TP.RESCODE_FAILURE, "请传入正确参数", null);
        try {
            OrderInfo info = orderInfoMapper.selectByPrimaryKey(id);
            if (info == null) return turnBackUtil.formIt(TP.ORDER_NOSUCH, "无此订单信息", null);
            else {
                BigDecimal money = info.getMoney();
                if (money.floatValue() == 0.00) {
                    changeStatus(info,STATUS_FINISH);
                    return turnBackUtil.formIt(TP.ORDER_FINISH_WITHOUT_PURCHASE, "订单关闭成功", null);
                }
                // 转移资金进入xxx账户
                boolean isPurchaseSuccess = pay.purchase(info.getToUID(), money);
                if (isPurchaseSuccess) {
                    changeStatus(info,STATUS_FINISH);
                    return turnBackUtil.formIt(TP.ORDER_FINISH_WITH_PURCHASE, "订单关闭成功，支付成功", null);
                } else
                    return turnBackUtil.formIt(TP.ORDER_UNFINISH, "订单关闭失败，支付失败", null);
            }
        } catch (Exception e) {
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "订单状态修改失败，服务器异常", null);
        }
    }

    private boolean changeStatus(OrderInfo info, Integer status) {
        info.setStatus(status);
        return 0 != orderInfoMapper.updateByPrimaryKeySelective(info);
    }
}
