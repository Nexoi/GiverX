package com.seeu.userpay.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by neo on 28/02/2017.
 */
@Service
public class SeeUAccountPay {

    /**
     * 提供基础的支付功能
     */
    public boolean purchase(Integer toUID, BigDecimal money) {
        // TODO
        return true;
    }
}
