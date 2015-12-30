package mainPackage.singletons;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lukasz on 19.12.15.
 */
public class FileManager {
    private static FileManager ourInstance = new FileManager();

    public Stack<String> fileToUpload;


    public static FileManager getInstance() {
        return ourInstance;
    }

    private FileManager() {
        fileToUpload = new Stack<>();
        System.out.println("Init singletons");
    }
}
