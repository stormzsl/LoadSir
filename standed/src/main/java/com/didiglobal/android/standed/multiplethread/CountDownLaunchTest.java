package com.didiglobal.android.standed.multiplethread;

import java.util.concurrent.CountDownLatch;

/**
 * 作者:created by storm
 */

public class CountDownLaunchTest {

    private static CountDownLatch countDownLatch=new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                System.out.println("begin");
            }
        }).start();
        countDownLatch.await();
        System.out.println("over");

    }
}
