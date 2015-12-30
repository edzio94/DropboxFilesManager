package mainPackage.data;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lukasz on 12.12.15.
 */
public class Folder {

    private File folder ;
    private List<File> listOfFiles;
    private int fileCounter;

    public Folder(String path)
    {
        folder = new File(path);
    }


    public int getFileCounter() {
        return fileCounter;
    }

    public void setFileCounter(int fileCounter) {
        this.fileCounter = fileCounter;
    }

    public List<File> getListOfFiles() {
        return listOfFiles;
    }

    public void setListOfFiles(List<File> listOfFiles) {
        this.listOfFiles = listOfFiles;
    }

    public File getFolder() {
        return folder;
    }
}
