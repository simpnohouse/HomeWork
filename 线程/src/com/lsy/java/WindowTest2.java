package com.lsy.java;

import sun.plugin2.message.ShowDocumentMessage;

/**
 * @author lsy
 * @Data 2021/10/2117:49
 * @Vervion
 */


class  Window2 implements Runnable{
    private  int ticket=100;
    @Override
    public void run() {
        while (true){
            show();
        }
    }
    public synchronized  void show(){
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+"票号为:"+ticket);
            try {
                Thread.currentThread().sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket--;
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 window2 = new Window2();
        Thread t1 = new Thread(window2);
        Thread t2 = new Thread(window2);
        Thread t3 = new Thread(window2);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
