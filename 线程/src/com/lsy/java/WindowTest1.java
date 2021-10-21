package com.lsy.java;

/**
 * 创建三个窗口卖票(实现runnable接口的方式)
 *
 * @author lsy
 * @Data 2021/10/2114:11
 * @Vervion 解决线程安全问题
 * 1.同步代码块
 * 2.同步方法
 */
class Window1 implements Runnable {
    int ticket = 100;
    //同步代码块的🔒(要求多个线程必须共用同一把锁)
    Object object = new Object();

    @Override
    public void run() {
        //同步代码块
        synchronized (object) {
            while (true) {

                if (ticket < 1) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " 票号为:" + ticket);
                ticket--;
                try {
                    Thread.currentThread().sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }


}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();
        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3 = new Thread(window1);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
