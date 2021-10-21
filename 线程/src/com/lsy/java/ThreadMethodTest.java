package com.lsy.java;

import sun.font.FontRunIterator;

import java.security.cert.X509Certificate;

/**
 * @author lsy
 * @Data 2021/10/2110:07
 * @Vervion
 *
 * 1.start() 启动线程，调用run（）
 * 2. run() 创建线程需要重写 在里面写要执行的操作
 * 3. getcurrentThread（）：静态方法，返回执行当前代码的线程
 * 4.getName（）：获取线程名字
 * 5.setName（）
 * 6.yield() 释放当前cpu的执行权
 * 7.join()优先执行调用join的线程，当前执行的线程会先进入阻塞状态。
 * 8.stop（）强制结束线程生命周期。（不推荐使用，deprecated）
 * 9.sleep()让当前线程休眠一会
 *
 *
 * 线程优先级(线程优先级越高的线程，抢占cpu资源的概率更高)
 * 三个常量
 * 1.max_priority 10
 * 2.MIN_PRIORITY 1
 * 3.NORM_PRIORITY 0
 *
 * 设置线程优先级
 * setpriority（）
 */

class ThreadDemo1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(getName()+ ":"+getPriority()+ ":"+i);
            }

            if(i%20==0){
                yield();
            }
        }
    }
     ThreadDemo1(String name){
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo1 threadDemo1 = new ThreadDemo1("test1");
       // threadDemo1.setName("线程一");
        threadDemo1.setPriority(Thread.MAX_PRIORITY);
        threadDemo1.start();

        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+ ":"+Thread.currentThread().getPriority()+ ":"+i);
            if(i==20){
                threadDemo1.join();
            }
        }

    }
}
