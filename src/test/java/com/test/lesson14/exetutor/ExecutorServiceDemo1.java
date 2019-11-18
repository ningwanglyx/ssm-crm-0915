package com.test.lesson14.exetutor;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: YangxingLiu
 * @Description:
 * @Date: Created in 2019/11/17 16:10
 * @Modified By:
 */
public class ExecutorServiceDemo1 {
    @Test
    public void test1(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            int finalI = i;
            Runnable r = () -> {
                System.out.println(Thread.currentThread().getName() + "---" + finalI);
               /* try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            };
            executorService.execute(r);
        }
    }

    @Test
    public void test2() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        for(int i = 0; i < 10; i++){
            int numI = i;
            Runnable r = () -> {
                System.out.println(Thread.currentThread().getName() + "---" + numI);
            };
            threadPoolExecutor.execute(r);
            Thread.sleep(1000);
        }
    }
}

