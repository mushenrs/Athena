package me.mushen.athena.java.datetime;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-09-01
 */
public class Timer {
    // 开始Unix时间戳(毫秒)
    private long startTime;
    // 结束Unix时间戳(毫秒)
    private long endTime;

    public void start(){
        this.startTime = System.currentTimeMillis();
    }

    public void end(){
        this.endTime = System.currentTimeMillis();
    }

    public long totalTime(){
        return endTime - startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
}
