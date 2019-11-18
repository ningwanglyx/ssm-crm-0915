package com.test.prolesson2;

import org.junit.Test;

import java.io.*;

/**
 * @Author: YangxingLiu
 * @Description:
 * @Date: Created in 2019/11/18 0:17
 * @Modified By:
 */
public class FileInputStreamDemo1 {
    @Test
    public void test1(){
        System.out.println(System.getProperty("user.dir"));
        try {
            FileWriter fw = new FileWriter("copy.txt");
            fw.write("23");
            fw.append("\r\n");
            fw.append("33");
            fw.append("\r\n");
            fw.append("35");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        try {
            FileInputStream fis = new FileInputStream("copy.txt");
            int len;
            while((len = fis.read()) != -1){
                System.out.println(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("copy.txt"));
            int x = dis.readInt();
            System.out.println(x);
            System.out.println(dis.readInt());
            //System.out.println(dis.readInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4(){
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream("copy3.txt"), true);
            String name = "Harry Hacker";
            double salary = 75000;
            out.print(name);
            out.print(' ');
            out.println(salary);
        } catch (FileNotFoundException e) {
        }
    }
}
