package mainPackage.dropbox;

import com.dropbox.core.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Created by lukasz on 12.12.15.
 */
public class DropboxAuth {
    //FilesManagerApp


    final String APP_KEY="pyb79rz40l9l87q";
    final String APP_SECRET="87vwl7xzlyfc3y0";

    //zjoGNKOb5vsAAAAAAAAHoOFJIxjTHkaxGcNNa1rSqJQ


    DbxAppInfo appInfo;
    DbxRequestConfig config;
    DbxWebAuthNoRedirect webAuth;
    public DbxClient client;


    public DropboxAuth()

    {
         appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

         config = new DbxRequestConfig(
                "FilesManagerApp", Locale.getDefault().toString());

         webAuth = new DbxWebAuthNoRedirect(config, appInfo);

        client = new DbxClient(config, "zjoGNKOb5vsAAAAAAAAHon3HtG4aWZ92bS2F4UyMHFZSkJTp1tSQDdau-N1d2jk7");
    }

    public void authorize() throws IOException, DbxException {
        String authorizeURL = webAuth.start();
        System.out.println("1. Go to: " + authorizeURL);
        System.out.println("2. Click \"Allow\" (you might have to log in first)");
        System.out.println("3. Copy the authorization code.");
        String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();

        DbxAuthFinish authFinish = webAuth.finish(code);
        String accessToken = authFinish.accessToken;

        System.out.println("AccessToken: "+accessToken);
        // ACC TOKEN: zjoGNKOb5vsAAAAAAAAHon3HtG4aWZ92bS2F4UyMHFZSkJTp1tSQDdau-N1d2jk7
    }
}