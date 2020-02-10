package com.qupeng;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class HashedWheelTimerTest {

    static class MyTimerTask implements TimerTask {
        boolean flag;

        public MyTimerTask(boolean flag) {
            this.flag = flag;
        }

        public void run(Timeout timeout) throws Exception {
            System.out.println("要去数据库删除订单了。。。。");
            this.flag = false;
        }
    }

    public static void main(String[] argv) {

        Optional optional;

        MyTimerTask timerTask = new MyTimerTask(true);

        Timer timer = new HashedWheelTimer();
        timer.newTimeout(timerTask, 5, TimeUnit.SECONDS);
        int i = 1;
        while (timerTask.flag) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + "秒过去了");
            i++;
        }
    }
}