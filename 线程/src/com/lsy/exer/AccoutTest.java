package com.lsy.exer;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

/**
 *
 *  * 银行有一个账户。
 *  有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *
 *     分析：
 *  1.是否是多线程问题？ 是，两个储户线程
 *  2.是否有共享数据？ 有，账户（或账户余额）
 *  3.是否有线程安全问题？有
 *  4.需要考虑如何解决线程安全问题？同步机制：有三种方式。
 * @author lsy
 * @Data 2021/10/2514:22
 * @Vervion
 */
 class Accout {
    private double balance;

    public Accout() {
    }

    public synchronized void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
        } else {
            throw new ExceptionInInitializerError();
        }
        System.out.println(Thread.currentThread().getName() + "当前余额是：" + balance);
    }

}
class Custemer implements Runnable{
    private Accout accout;
    private double money;
    public Custemer(Accout accout, double money) {
        this.accout = accout;
        this.money = money;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            accout.deposit(money);
        }
    }
}
public class AccoutTest{
    public static void main(String[] args) {
        Accout accout = new Accout();
        Custemer custemer1 =new Custemer(accout,1000);
        Custemer custemer2=new Custemer(accout,1000);
        Thread thread1 = new Thread(custemer1);
        thread1.start();
        Thread thread2 = new Thread(custemer2);
        thread2.start();
    }
}

