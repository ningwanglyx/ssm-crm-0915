package com.test.lesson14.locks;

import com.test.lesson14.locks.Bank;

/**
 * @Author: YangxingLiu
 * @Description:
 * @Date: Created in 2019/11/17 11:10
 * @Modified By:
 */
public class BankTest {
    public static final int naccounts = 100;
    public static final double initial_balance = 1000;
    public static final double max_amount = 1000;
    public static final int delay = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(naccounts, initial_balance);
        for( int i = 0; i < naccounts; i++){
            int fromAccount = i;
            Runnable r = () -> {
                while(true){
                    try {
                        int toAccount = (int) ( bank.size()*Math.random());
                        double amount = max_amount * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((long) (delay*Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread t = new Thread(r);
            t.start();
        }
    }
}
