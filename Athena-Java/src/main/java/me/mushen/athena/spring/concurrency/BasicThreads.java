package me.mushen.athena.spring.concurrency;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-13
 */
public class BasicThreads {
    public static void main(String[] args){
        Thread thread = new Thread(new LiftOff(5));
        thread.start();
        System.out.println("Waiting for LiftOff");
    }
}
