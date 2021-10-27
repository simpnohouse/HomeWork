package com.lsy.java;

import com.sun.tracing.dtrace.StabilityLevel;

import javax.sound.midi.Soundbank;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *线程通信的例子：使用两个线程打印 1-100。线程1, 线程2 交替打印
 * 涉及到的三个方法：
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * 说明：
 * 1.wait()，notify()，notifyAll()三个方法必须使用在同步代码块或同步方法中。
 * 2.wait()，notify()，notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 *    否则，会出现IllegalMonitorStateException异常
 * 3.wait()，notify()，notifyAll()三个方法是定义在java.lang.Object类中。
 *
 * 面试题：sleep() 和 wait()的异同？
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态。
 * 2.不同点：1）两个方法声明的位置不同：Thread类中声明sleep() , Object类中声明wait()
 *          2）调用的要求不同：sleep()可以在任何需要的场景下调用。 wait()必须使用在同步代码块或同步方法中
 *          3）关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁。
 *
 * @author lsy
 * @Data 2021/10/2713:47
 * @Vervion
 */
class Print implements Runnable{
    private int  times;
    private Object object=new Object();
    public Print(int times){
        this.times=times;
    }
    @Override
    public void run() {
        while (true) {

            synchronized (object) {
                if (times > 0) {
                    object.notify();
                    System.out.println(Thread.currentThread().getName() + ":打印成功");
                    times--;
                    try {
                        object.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        Print print = new Print(10);
        Thread thread1 = new Thread(print);
        Thread thread2 = new Thread(print);
        thread1.start();
        thread2.start();
    }
}
