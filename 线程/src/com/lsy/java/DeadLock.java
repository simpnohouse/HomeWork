package com.lsy.java;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

import static java.lang.Thread.sleep;

/**
 * @author lsy
 * @Data 2021/10/2513:23
 * @Vervion
 */
//同步监视器
class StringLock{
public static StringBuffer s1=new StringBuffer();
public static StringBuffer s2=new StringBuffer();
}
//线程1
class AddStringThread extends Thread{
    @Override
    public void run() {
        synchronized (StringLock.s1){
            StringLock.s1.append('1');
            try {
                sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            StringLock.s2.append('2');
            System.out.println(getName()+":"+StringLock.s1);
            System.out.println(getName()+":"+StringLock.s2);
        }
    }
}
//线程2
class AddStringThread1 implements Runnable{

    @Override
    public void run() {
        synchronized (StringLock.s2){
            StringLock.s1.append('1');
            try {
                sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            StringLock.s2.append('2');
            System.out.println(Thread.currentThread().getName()+":"+StringLock.s1);
            System.out.println(Thread.currentThread().getName()+":"+StringLock.s2);
        }
    }
}

public class DeadLock {
    public static void main(String[] args) {
        //启动线程1
        AddStringThread addStringThread = new AddStringThread();
        addStringThread.start();
        AddStringThread1 addStringThread1 = new AddStringThread1();
        //启动线程2
        Thread thread = new Thread(addStringThread1);
        thread.start();
    }

}
