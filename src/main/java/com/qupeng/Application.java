package com.qupeng;

import com.qupeng.component.PayChooser;
import com.qupeng.sample2.User;
import com.qupeng.service.PayService;
import com.qupeng.service.UserService;
import com.qupeng.type.PayType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        //支付方式的选择器
        PayChooser payChooser = context.getBean(PayChooser.class);

        //微信支付
        PayService payService2 = payChooser.choose(PayType.WECHAT);
        String s2 = payService2.pay(79.9);

        //支付宝支付
        PayService payService1 = payChooser.choose(PayType.ALIPAY);
        String s1 = payService1.pay(99.9);

        //模板方法模式实现 双重检测锁，避免缓存击穿
        UserService userService = context.getBean(UserService.class);
        User user = userService.getUserByIdTemplate(1);
        System.out.println(user);
    }
}