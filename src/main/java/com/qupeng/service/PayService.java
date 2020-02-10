package com.qupeng.service;

import com.qupeng.type.PayType;

/**
 * 支付接口
 */
public interface PayService {

    /**
     * 得到支付类型，也就是采用哪一种支付
     *
     * @return
     */
    public PayType payType();

    /**
     * 支付接口
     *
     * @param money
     * @return
     */
    public String pay(Double money);
}
