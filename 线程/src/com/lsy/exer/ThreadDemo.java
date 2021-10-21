package com.lsy.exer;

import com.sun.xml.internal.bind.v2.model.runtime.RuntimeEnumLeafInfo;

/**
 * @author lsy
 * @Data 2021/10/219:45
 * @Vervion 创建两个线程，一个遍历100以内偶数，一个基数
 */

class ThreadTest extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class ThreadTest2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
//        ThreadTest threadTest = new ThreadTest();
//        threadTest.start();
//        ThreadTest2 threadTest2 = new ThreadTest2();

//线程只调用一次的话，用匿名子类更方便
        new Thread(){
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i%2==0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();


        new Thread(){
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i%2!=0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
    }
}
