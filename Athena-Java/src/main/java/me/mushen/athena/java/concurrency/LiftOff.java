package me.mushen.athena.java.concurrency;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-13
 */
public class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown + ")," : "Liftoff!)\n") ;
    }

    @Override
    public void run() {
        while(countDown-- > 0){
            System.out.print(status());
            Thread.yield();
        }
    }
}
