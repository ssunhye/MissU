package com.k.missu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kjh on 2017. 11. 23..
 */

public class Parser {
    JSONObject[] jsobj;
    public Parser(String str) throws JSONException {

        JSONArray tmp_arr = new JSONArray(str);

        for(int i = 0 ; i < tmp_arr.length();i++){

            jsobj[i] = tmp_arr.getJSONObject(i);
            System.out.println(jsobj[i].toString());
        }

    }

}

