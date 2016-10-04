package me.mushen.athena.java.io;

import java.io.*;
import java.util.Date;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-31
 */
public class ArraysIOExample {

    public static void main(String[] args){
        ArraysIOExample example = new ArraysIOExample();
        example.arrayInputStreamReader();

        System.out.println(new Date(1472629489652L));
        System.out.println(new Date(1472629483931L));

    }

    private void arrayInputStreamReader(){
        byte[] bytes = "Hello, 蕾米莉亚斯卡雷特".getBytes();
        // 字节数组输入流
        try(InputStream is = new ByteArrayInputStream(bytes)){
            int data;
            while((data  = is.read()) != -1){
                System.out.print((byte)data + ", ");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }

        char[] chars = "Hello, 蕾米莉亚斯卡雷特".toCharArray();
        // 字符数据输入流
        try(Reader r = new CharArrayReader(chars)){
            int data;
            while((data = r.read()) != -1){
                System.out.print((char)data + "|");
            }
        }catch(IOException e){
            e.printStackTrace(System.err);
        }
    }
}
