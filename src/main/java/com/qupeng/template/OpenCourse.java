package com.qupeng.template;

public abstract class OpenCourse {

    /**
     * 公开课直播 (模板方法)
     */
    public final void live() {

        //录视频
        recordVideo();

        //写笔记
        writeNode();

        //写代码
        writeCode();
    }

    public abstract void recordVideo();

    public abstract void writeNode();

    public abstract void writeCode();
}
