package me.mushen.athena.java.java7;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-24
 */
public class TryWithResource {
    // 在try-catch语句的try子句中可以定义需要关闭的资源
    // 可以声明多个需要关闭的资源, 以分号(;)进行分割
    // try子句中声明的资源必须实现了java.lang.Closeable接口
    public static void main(String[] args){
        try (InputStream is = TryWithResource.class.getResourceAsStream("/albums4r.json")) {
            byte[] bytes = new byte[2048];
            int index = 0;
            int i;
            while ((i = is.read()) > 0) {
                if(index == bytes.length){
                    bytes = expandByteArray(bytes);
                }
                bytes[index++] = (byte) i;
            }
            String str = new String(bytes, 0, index);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    private static byte[] expandByteArray(byte[] oldBytes){
        byte[] newBytes = new byte[oldBytes.length * 2 + 1];
        System.arraycopy(oldBytes, 0, newBytes, 0, oldBytes.length);
        return newBytes;
    }
}
