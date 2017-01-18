package com.seeu.userpay.controller;

import com.seeu.userpay.service.PayBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by neo on 18/01/2017.
 *
 * Only provide for query balance controller, cannot change balance.
 */
@RestController
@RequestMapping("pay")
public class PayBalanceController {
    @Autowired
    PayBalanceService payBalanceService;

    @RequestMapping("querybalance")
    public String query(@RequestAttribute("UID")Integer UID){
        return payBalanceService.queryBalance(UID);
    }
}
