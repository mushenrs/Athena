package me.mushen.athena.java.concurrency;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-13
 */
public class MainThread {
    public static void main(String[] args){
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
