package com.seeu.userpay.service;

import com.TP;
import com.TurnBackUtil;
import com.alibaba.fastjson.JSONObject;
import com.seeu.userpay.dao.UserPayBalanceMapper;
import com.seeu.userpay.model.UserPayBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by neo on 18/01/2017.
 */
@Service
public class PayBalanceService {

    @Autowired
    UserPayBalanceMapper payBalanceMapper;

    @Autowired
    TurnBackUtil turnBackUtil;

    public String queryBalance(Integer UID) {
        UserPayBalance userPayBalance = payBalanceMapper.selectByPrimaryKey(UID);
        if (userPayBalance != null) {
            BigDecimal balance = userPayBalance.getBalance();
            double bal = balance.doubleValue();
            JSONObject jo = new JSONObject();
            jo.put("balance", bal);
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "获取余额信息成功", jo);
        }
        return turnBackUtil.formIt(TP.RESCODE_FAILURE, "获取余额信息失败", null);
    }
}
