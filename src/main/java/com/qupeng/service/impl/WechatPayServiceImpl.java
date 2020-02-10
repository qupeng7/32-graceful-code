package com.qupeng.service.impl;

import com.qupeng.service.PayService;
import com.qupeng.type.PayType;
import org.springframework.stereotype.Service;

@Service
public class WechatPayServiceImpl implements PayService {

    /**
     * 得到支付类型，也就是采用哪一种支付
     *
     * @return
     */
    public PayType payType() {
        return PayType.WECHAT;
    }


    public String pay(Double money) {
        System.out.println("微信支付.........." + money);
        return "wechat";
    }
}
