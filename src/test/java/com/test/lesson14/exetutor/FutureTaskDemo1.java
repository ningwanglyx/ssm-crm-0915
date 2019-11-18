package com.test.lesson14.exetutor;

import org.junit.Test;
import sun.applet.Main;

import java.util.concurrent.*;

/**
 * @Author: YangxingLiu
 * @Description:
 * @Date: Created in 2019/11/17 17:05
 * @Modified By:
 */
public class FutureTaskDemo1 {
    @Test
    public void test1(){
        Callable<String> shanxian = () -> {
            for(int i = 0; i < 2; i++){
                System.out.println("闪现技能CD中");
                Thread.sleep(1000);
            }
            return "释放闪现技能";
        };

        Callable<String> yinran = () -> {
            for(int i = 0; i < 4; i++){
                System.out.println("引燃技能CD还差：" + (3-i) + "秒");
                Thread.sleep(1000);
            }
            return "释放引燃技能";
        };

        FutureTask<String> shanxianTask = new FutureTask<>(shanxian);
        FutureTask<String> yinranTask = new FutureTask<>(yinran);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(shanxianTask);
        executorService.submit(yinranTask);

        try {
            System.out.println(shanxianTask.get());
            System.out.println(yinranTask.get());
            System.out.println("double kill");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
