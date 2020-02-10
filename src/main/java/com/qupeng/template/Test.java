package com.qupeng.template;

public class Test {

    public static void main(String[] args) {

        //架构师公开课
        OpenCourse openCourse = new JiagoushiOpenCourse();
        openCourse.live();

        System.out.println("----------------------------");

        OpenCourse openCourse1 = new OtherOpenCourse();
        openCourse1.live();
    }
}
