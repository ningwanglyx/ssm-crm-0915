package com.test.lesson14.locks;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: YangxingLiu
 * @Description:
 * @Date: Created in 2019/11/17 0:29
 * @Modified By:
 */
public class Bank {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    public double getTotalBalance(){
        //加锁
        bankLock.lock();
        try {
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }
            return sum;
        } finally {
            //释放锁
            bankLock.unlock();
        }
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while(accounts[from] < amount){
                //该线程放到条件的等待集中
                sufficientFunds.await();
            }
            System.out.println(Thread. currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            accounts[to] +=amount;
            System.out.printf("total balance: %10.2f%n", getTotalBalance());
            //接触该条件的等待集中所有线程的阻塞状态
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    public int size(){
        return accounts.length;
    }

}
