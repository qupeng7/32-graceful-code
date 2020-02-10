package com.qupeng.strategy;

public class Test {

    public static void main(String[] args) {
        //A策略
        StrategyContext contextA = new StrategyContext(new ConcreteStrategyA());
        contextA.contextMethod();

        //B策略
        StrategyContext contextB = new StrategyContext(new ConcreteStrategyB());
        contextB.contextMethod();

        //C策略
        StrategyContext contextC = new StrategyContext(new ConcreteStrategyC());
        contextC.contextMethod();
    }
}
