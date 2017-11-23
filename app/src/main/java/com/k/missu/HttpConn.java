package com.k.missu;

import android.content.ContentValues;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

/**
 * Created by kjh on 2017. 6. 10..
 */

public class HttpConn {

    public String request(String _url, String id, String pw) throws IOException {

        HttpURLConnection urlConn = null;

            URL url = new URL(_url+"?id="+id+"&pw="+pw);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

      /*  try {
            if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("Connectionfailed");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));

            String line;
            String page = "";

            while ((line = reader.readLine()) != null){
                System.out.println("page : "+page.toString());
                page += line;
            }
        if (urlConn != null) {
            urlConn.disconnect();
        }
            return page;

    }
}
