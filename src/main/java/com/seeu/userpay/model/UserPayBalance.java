package com.seeu.userpay.model;

import java.math.BigDecimal;

public class UserPayBalance {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userpay_balance.UID
     *
     * @mbggenerated Wed Jan 18 03:42:33 CST 2017
     */
    private Integer UID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userpay_balance.balance
     *
     * @mbggenerated Wed Jan 18 03:42:33 CST 2017
     */
    private BigDecimal balance;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userpay_balance.UID
     *
     * @return the value of userpay_balance.UID
     *
     * @mbggenerated Wed Jan 18 03:42:33 CST 2017
     */
    public Integer getUID() {
        return UID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userpay_balance.UID
     *
     * @param UID the value for userpay_balance.UID
     *
     * @mbggenerated Wed Jan 18 03:42:33 CST 2017
     */
    public void setUID(Integer UID) {
        this.UID = UID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userpay_balance.balance
     *
     * @return the value of userpay_balance.balance
     *
     * @mbggenerated Wed Jan 18 03:42:33 CST 2017
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userpay_balance.balance
     *
     * @param balance the value for userpay_balance.balance
     *
     * @mbggenerated Wed Jan 18 03:42:33 CST 2017
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}