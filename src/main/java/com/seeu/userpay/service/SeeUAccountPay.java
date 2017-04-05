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
     * SEEU支付给用户
     */
    public boolean purchase2Account(Integer toUID, BigDecimal money) {
        // TODO
        return true;
    }

    /**
     * 提供基础的支付功能
     * SEEU支付给用户支付宝账户
     */
    public boolean purchase2AliPay(Integer toUID, BigDecimal money) {
        // TODO
        return true;
    }

    /**
     * 提供基础的支付功能
     * SEEU支付给用户微信账户
     */
    public boolean purchase2WeChat(Integer toUID, BigDecimal money) {
        // TODO
        return true;
    }

    /**
     * 用户支付给SEEU
     *
     * @param fromUID
     * @param money
     * @return
     */
    public boolean deposit(Integer fromUID, BigDecimal money) {
        // TODO
        return true;
    }
}
