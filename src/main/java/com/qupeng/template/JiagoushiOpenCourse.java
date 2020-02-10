package com.qupeng.template;

public class JiagoushiOpenCourse extends OpenCourse {

    @Override
    public void recordVideo() {
        System.out.println("架构师公开课录制视频.............");
    }

    @Override
    public void writeNode() {
        System.out.println("架构师公开课写笔记.............");
    }

    @Override
    public void writeCode() {
        System.out.println("架构师公开课写代码.............");
    }
}
