package com.lsy.java;

/**
 * 创建多线程的方式二，继承runnable接口
 *
 * @author lsy
 * @Data 2021/10/2113:48
 * @Vervion
 */
//1.创建一个实现了runnable接口的类
class MThread implements Runnable{

    @Override
    //2.实现类区实现runnable接口中的run（）
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadTest1 {

    public static void main(String[] args) {
        //3.创建实现类的对象
        MThread mThread=new MThread();
        //4.把这个对象作为参数传递到thread类的构造器中。
        Thread t1 = new Thread(mThread);
        Thread t2=  new Thread(mThread);
        //启动
        t1.start();
        t2.start();
    }

}
