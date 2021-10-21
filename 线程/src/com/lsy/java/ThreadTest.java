package com.lsy.java;

/**
 * 多线程的创建，继承Thead类的方式。
 * 方式一：继承Thread类的子类。
 * 1.继承thread
 * 2.重写thread的run方法
 * 3.创建thread类的子类对象。
 * 4.通过此对象调用start（）
 * <p>
 * <p>
 * 例子： 便利100以内所有偶數
 *
 * @author lsy
 * @Data 2021/10/2016:05
 * @Vervion
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + Thread.currentThread().getName());
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();

        //start()两个作用：1.启动当前线程 2.启动run()方法。
        t1.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + Thread.currentThread().getName());
            }
        }

    }
}