package com.qupeng.service;

@FunctionalInterface //函数式接口
public interface BaseServiceHandler<T> {

    public T loadData();
}
