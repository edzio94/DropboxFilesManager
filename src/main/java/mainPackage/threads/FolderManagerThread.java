package mainPackage.threads;

import mainPackage.data.Folder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lukasz on 12.12.15.
 */
@Component
@Scope("prototype")
public class FolderManagerThread implements Runnable{
    final String ID = "FileCounter Thread";

    Folder folder = new Folder("/home/lukasz/stronka/");


    private int localCounter;

    public FolderManagerThread(){
        localCounter = 0;
    }

    @Override
    public void run() {

        for (;;) {
            getNumberOfFiles();
            if (localCounter < folder.getFileCounter())
            {
                System.out.println("Zmiana liczby plików w folderze");
                localCounter = folder.getFileCounter();
                //TODO function that do stuff for it
            }
        }
    }

    private void getNumberOfFiles(){
        folder.setListOfFiles(Arrays.asList(folder.getFolder().listFiles()));
        folder.setFileCounter(folder.getListOfFiles().size());


    }

}
