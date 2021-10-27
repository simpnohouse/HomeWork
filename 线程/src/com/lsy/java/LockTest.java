package com.lsy.java;

import com.sun.scenario.effect.impl.prism.ps.PPSBlend_MULTIPLYPeer;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 解决线程安全问题的方式三：Lock锁  --- JDK5.0新增
 *
 * 1. 面试题：synchronized 与 Lock的异同？
 *   相同：二者都可以解决线程安全问题
 *   不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *        Lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）
 *
 * 2.优先使用顺序：
 * Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体之外）
 *
 * @author lsy
 * @Data 2021/10/2713:18
 * @Vervion
 */
class window implements  Runnable{
    private int ticket=100;
    private ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        while(true){
            lock.lock();
            if(ticket>0){
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+ticket);
                ticket--;
            }else{
                break;
            }
            lock.unlock();
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        window window = new window();
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        thread1.start();
        thread2.start();

    }
}
