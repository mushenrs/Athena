package me.mushen.athena.java.concurrency;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-13
 */
public class MoreBasicThreads {
    public static void main(String[] args){
        for(int i=0; i<5; i++){
            Thread thread = new Thread(new LiftOff());
            thread.start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
