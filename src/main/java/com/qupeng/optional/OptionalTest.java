package com.qupeng.optional;

import java.util.Objects;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) throws Throwable {

        String defaultStr = "动力节点";
        String str = "动力节点Java架构师";

        //Optional对象构建
        Optional optional1 = Optional.of(str); //要求str不能是空null
        Optional optional2 = Optional.ofNullable(str); //str可以是空null

        //判断容器是否存在值，存在返回true，不存在返回false
        boolean flag = optional1.isPresent();
        System.out.println("flag=" + flag);

        //判断容器是否存在值，存在值，采用一个消费者去消费
        optional1.ifPresent((Object s) -> {
            System.out.println("消费者：" + s);
        });

        //Optional容器数据获取
        Object object1 = optional1.get();
        System.out.println(object1);

        Object ss = optional1.filter((Objects::nonNull)).orElseGet(() -> "ddd");
        System.out.println("ss==>" + ss);

        System.out.println("map: " + optional1.map((Object obj) -> {
            return obj + "sss";
        }).get());

        String sss = null;
        Optional optionalX = Optional.ofNullable(sss);

        System.out.println("flatMap=" + optionalX.flatMap((Object obj) -> {
            return Optional.ofNullable(obj);
        }).orElse("没有值"));

        System.out.println("异常：" + optionalX.filter((Object o) -> true).orElseThrow(() -> {
            return new RuntimeException("没有值");
        }));

        Object object2 = optional2.orElse(defaultStr);
        System.out.println(object2);

        Object object3 = optional2.orElseGet(() -> {
            return defaultStr;
        });
        System.out.println(object3);

        try {
            Object object4 = optional2.orElseThrow(() -> {
                return new RuntimeException("xxxx");
            });
            System.out.println(object4);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        boolean isPresent = optional1.isPresent();
        if (isPresent) {
            System.out.println(isPresent);
        }

        //隐式地判断了null
        optional1.ifPresent((String) -> {
            System.out.println(str);
        });

        Optional optional3 = optional1.map((Object x) -> {
            return x;
        });
        System.out.println(optional3.get());

        Optional optional4 = optional1.flatMap((Object x) -> {
            return Optional.of(x);
        });
        System.out.println(optional4.get());
    }
}