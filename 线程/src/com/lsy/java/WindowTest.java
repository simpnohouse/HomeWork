package com.lsy.java;

import java.security.PublicKey;

/**
 *
 * 例子： 创建三个窗口卖票(继承thread)
 * @author lsy
 * @Data 2021/10/2111:19
 * @Vervion
 */
class WindowThread extends Thread{
    private static int ticket=100;//票是三个线程共用资源，要静态定义。（还是会有线程不安全的问题
    @Override
    public void run() {

        while (true){
            synchronized (WindowThread.class){//锁不一定是对象，也可以是类。 或者可以这样说，类也是对象。
                if(ticket<1){
                    break;
                }
                System.out.println(getName()+" 票号为:"+ticket);
                ticket--;
            }
        }
    }
}

public class WindowTest {

    public static void main(String[] args) {

        Thread t1 = new WindowThread();
        t1.setName("线程一");
        Thread t2 = new WindowThread();
        t2.setName("线程二");
        Thread t3 = new WindowThread();
        t3.setName("线程三");
        t1.start();
        t2.start();
        t3.start();


    }
}
