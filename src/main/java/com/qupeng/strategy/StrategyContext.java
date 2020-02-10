package com.qupeng.strategy;

/**
 * 上下文策略角色
 */
public class StrategyContext {

    /**
     * 持有策略接口的引用
     */
    private Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextMethod() {
        System.out.println("策略上下文的方法执行..........");

        //调用策略方法
        strategy.strategyMethod();
    }
}
