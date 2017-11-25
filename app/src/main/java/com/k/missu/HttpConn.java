package com.k.missu;

import android.content.ContentValues;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kjh on 2017. 6. 10..
 */

public class HttpConn {


    public JSONObject HttpGET(String _url) throws IOException, JSONException {

        HttpURLConnection urlConn = null;

        URL url = new URL(_url);
        urlConn = (HttpURLConnection) url.openConnection();
        urlConn.setRequestMethod("GET");

            InputStream is = urlConn.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] byteBuff = new byte[1024];
            byte[] byteData = null;
            int nLength = 0;
            while((nLength = is.read(byteBuff,0,byteBuff.length)) != -1){
                baos.write(byteBuff,0,nLength);
            }
            byteData = baos.toByteArray();

            String response = new String(byteData);

            JSONObject responseJSON = new JSONObject(response);
            System.out.println(responseJSON.toString());
            urlConn.disconnect();
            byteBuff = new byte[1024];
            byteData = null;

            return responseJSON;
    }
/*    public JSONObject HttpPOST(String _url, String data_buff){
        HttpURLConnection urlConn = null;

        URL url = new URL(_url);
        urlConn = (HttpURLConnection) url.openConnection();
        urlConn.setRequestMethod("GET");
        return responseJSON;

    }
*/
}