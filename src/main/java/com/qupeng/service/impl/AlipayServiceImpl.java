package com.qupeng.service.impl;

import com.qupeng.service.PayService;
import com.qupeng.type.PayType;
import org.springframework.stereotype.Service;

/**
 * 支付宝支付
 *
 */
@Service
public class AlipayServiceImpl implements PayService {

    /**
     * 得到支付类型，也就是采用哪一种支付
     *
     * @return
     */
    public PayType payType() {
        return PayType.ALIPAY;
    }

    public String pay(Double money) {
        System.out.println("支付宝支付.........." + money);
        return "alipay";
    }
}
