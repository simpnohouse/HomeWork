package com.lsy.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lsy
 * @Data 2021/10/2810:19
 * @Vervion
 */
//1.创建一个实现了callable的实现类
class NumThread implements Callable{
//2.重写callable方法
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return  sum;
    }
}

public class ThreadTest3 {
    public static void main(String[] args) {
        //3.创建callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.传递到futuretask类构造器中
        FutureTask futureTask = new FutureTask(numThread);
        //5.创建thread对象，并且调用start
        new Thread(futureTask).start();

        try {
        //6.调用futureTask中get方法。可以得到return的值
            Object sum= futureTask.get();
            System.out.println(sum);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
