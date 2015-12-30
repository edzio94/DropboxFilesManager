package mainPackage.Main;

import mainPackage.data.TimeCounter;
import mainPackage.dropbox.DropboxAuth;
import mainPackage.dropbox.DropboxClient;
import mainPackage.singletons.FileManager;
import mainPackage.spring.AppConfig;
import mainPackage.threads.DropboxUploaderThread;
import mainPackage.threads.FolderListenerThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by lukasz on 19.12.15.
 */
public class Worker implements Runnable{

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    public TimeCounter timeCounter;

    DropboxClient client;

    public Worker(ThreadPoolTaskExecutor threadPoolTaskExecutor)
    {

        client = new DropboxClient();
        System.out.println("Worker class init");
        System.out.println("Before execute");
            this.threadPoolTaskExecutor  = threadPoolTaskExecutor;
        //this.timeCounter = new TimeCounter();

    }
    @Override
    public void run() {
        this.threadPoolTaskExecutor.execute(new FolderListenerThread());
        System.out.println("In Run");
                for(;;) {


                       while(FileManager.getInstance().fileToUpload.size() > 0)//FileManager.getInstance().fileToUpload)
                        {
                            System.out.println("In for loop");
                             System.out.println("FileFOrUpload: ");
                           // threadPoolTaskExecutor.
                            threadPoolTaskExecutor.execute(new DropboxUploaderThread(new File(FileManager.getInstance().fileToUpload.pop()), client.client));
                            System.out.println("WWWWWW");

                        }
                   // this.threadPoolTaskExecutor.shutdown();


                }
    }
}
