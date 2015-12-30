package mainPackage.threads;

import mainPackage.data.Folder;
import mainPackage.singletons.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;


/**
 * Created by lukasz on 19.12.15.
 */
public class FolderListenerThread implements Runnable{

  //  @Autowired
    //        public ThreadPoolTaskExecutor threadPoolTaskExecutor;


    WatchService watcher;
    Folder folder = new Folder("/home/lukasz/FilesCreating");

    Path path = Paths.get("/home/lukasz/FilesCreating/");

    FileSystem fs = path.getFileSystem();


    public FolderListenerThread()  {

       System.out.println("TEEest00");
        try {
            watcher = fs.newWatchService();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            path.register(watcher,ENTRY_CREATE,
                    ENTRY_DELETE, ENTRY_MODIFY);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    @Override
    public void run() {

          for(;;) {

        WatchKey key = null;

        try {
            key = watcher.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (WatchEvent<?> event : key.pollEvents()) {
            WatchEvent.Kind<?> king = event.kind();

            if (king == OVERFLOW) {
                System.out.println("OVERFLOW");
                continue;
            }

            WatchEvent<Path> ev = (WatchEvent<Path>) event;
            Path filename = ev.context();
            // FileManager.getInstance().fileToUpload.add(filename.getFileName().toString());
            Path child = path.resolve(filename);
            FileManager.getInstance().fileToUpload.push(child.toString());//.add(child.toString());
            System.out.println("File size: " + FileManager.getInstance().fileToUpload.size());
            System.out.println("path?: " + child);

        }
        key.reset();
    }


    }
}
