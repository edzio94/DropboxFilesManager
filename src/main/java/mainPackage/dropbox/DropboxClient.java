package mainPackage.dropbox;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxRequestConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;

/**
 * Created by lukasz on 12.12.15.
 */
public class DropboxClient {
    private DbxRequestConfig config;
    public DbxClient client;
    private final String ACC_TOKEN = "zjoGNKOb5vsAAAAAAAAHon3HtG4aWZ92bS2F4UyMHFZSkJTp1tSQDdau-N1d2jk7";

    public DropboxClient()
    {
        config = new DbxRequestConfig(
                "FilesManagerApp", Locale.getDefault().toString());

        client = new DbxClient(config,ACC_TOKEN);
    }

}
