package com.qupeng.component;

import com.qupeng.service.PayService;
import com.qupeng.type.PayType;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 支付通道的选择
 *
 */
@Component
public class PayChooser implements ApplicationContextAware {

    /**
     * 拿到了spring容器对象
     */
    private ApplicationContext applicationContext;

    /**
     * 把枚举类型的支付方式 和 具体的策略实现 关联起来
     */
    private Map<PayType, PayService> chooseMap = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 选择哪种策略去支付
     *
     * @param payType
     * @return
     */
    public PayService choose(PayType payType) {
        return chooseMap.get(payType);
    }

    /**
     * 注册支付类型
     *
     */
    @PostConstruct
    public void registerPayType() {
        //PayService有几个实现类
        Map<String, PayService> payMap = applicationContext.getBeansOfType(PayService.class);
        for (PayService payService : payMap.values()) {
            //把枚举类型的支付方式 和 具体的策略实现 关联起来
            chooseMap.put(payService.payType(), payService);
        }
    }
}