package mainPackage.threads;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWriteMode;
import mainPackage.dropbox.DropboxClient;
import mainPackage.singletons.FileManager;
import mainPackage.singletons.Statistics;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by lukasz on 19.12.15.
 */
@Async
public class DropboxUploaderThread implements Runnable {

    File inputFile;
    DbxClient client;

    public DropboxUploaderThread(File inputFile, DbxClient client)
    {
        this.inputFile = inputFile;
        this.client = client;
        System.out.println("JEdziemy z uploaded - klasa");

    }
    @Async
    @Override
    public void run() {
        System.out.println("RUN FOR DROPBOX");
        uploadFile();
    }


    public void uploadFile()
    {
        System.out.println("DROPBOX UPLOAD FILE FUNCTION");
        FileInputStream inputStream;

        Path path = inputFile.toPath();

        String fullPath = path.toString()+inputFile.getName();

        try {
            inputStream = new FileInputStream(inputFile);
            DbxEntry.File uploadedFile = client.uploadFile(fullPath, DbxWriteMode.add(),
                    inputFile.length(),inputStream);
            System.out.println("Uploaded: " +uploadedFile.toString());
            Statistics.getInstance().filesSent++;
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DbxException e) {
            e.printStackTrace();
        }


    }
}
