package com.test.prolesson2;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * @Author: YangxingLiu
 * @Description:
 * @Date: Created in 2019/11/18 0:36
 * @Modified By:
 */
public class FileWriterDemo1 {
    @Test
    public void test1(){
        Reader in = new InputStreamReader(System.in);
        System.out.println("输入： ");
        char[] chars = new char[1024];
        int len;
        try {
            len = in.read(chars);
            for (char aChar : chars) {
                System.out.println(aChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        String s = sc.next();
        System.out.println(s);
    }
}
