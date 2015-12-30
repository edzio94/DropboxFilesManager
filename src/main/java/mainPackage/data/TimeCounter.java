package mainPackage.data;

/**
 * Created by lukasz on 30.12.15.
 */
public class TimeCounter {
    private final long start;
    private long end;
    public long passedTime;

    public TimeCounter(){
        start = System.currentTimeMillis();
    }

    public long getPassedTime(){
        passedTime = (long) ((System.currentTimeMillis() - start)/(1000F));
        return passedTime;
    }
}

