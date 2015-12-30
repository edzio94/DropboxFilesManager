package mainPackage.singletons;

import mainPackage.data.TimeCounter;

import java.util.Timer;

/**
 * Created by lukasz on 30.12.15.
 */
public class Statistics {
    private static Statistics ourInstance = new Statistics();

    public static Statistics getInstance() {
        return ourInstance;
    }

    public int filesSent;
    public long timeSpent;
    private float filesPerSeconds;
    private TimeCounter timeCounter;


    private Statistics() {
        filesSent=0;
        timeCounter = new TimeCounter();
    }


    public float getFilesPerSeconds() {
        return filesPerSeconds;
    }

    public void setFilesPerSeconds() {
        timeSpent = timeCounter.getPassedTime();

        filesPerSeconds = (float)filesSent/(float)timeCounter.getPassedTime();
    }
}
