package mainPackage.Controllers;

import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import mainPackage.Main.Worker;
import mainPackage.data.Folder;
import mainPackage.dropbox.DropboxAuth;
import mainPackage.singletons.FileManager;
import mainPackage.singletons.Statistics;
import mainPackage.threads.FolderListenerThread;
import mainPackage.threads.FolderManagerThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by lukasz on 12.12.15.
 */
@RestController
public class fileCounterController {

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    Worker worker;

    @RequestMapping(value = "/")
    public String index() {
        //threadPoolTaskExecutor.execute(counterThread);
        //counterThread.run();
        return "<b>index</b>";
    }

    @RequestMapping(value = "/getToken")
    public String token() throws IOException, DbxException {
        DropboxAuth auth = new DropboxAuth();
        auth.authorize();
        System.out.println("End !");
        return new String("End of token access");
    }

    @RequestMapping(value = "/testListener")
    public String test() {
      worker = new Worker(threadPoolTaskExecutor);
        //threadPoolTaskExecutor.execute(worker);
        worker.run();
        return "test";
    }
    @RequestMapping(value = "/getCounter")
    public String getCounter(){
        System.out.println("==============================");

    Statistics.getInstance().setFilesPerSeconds();
        System.out.println("Files sent: "+Statistics.getInstance().filesSent);
        System.out.println("Time:"+Statistics.getInstance().timeSpent);
        System.out.println("fpm: "+Statistics.getInstance().getFilesPerSeconds());
    return String.valueOf(Statistics.getInstance().getFilesPerSeconds());
    }

}