package com.k.missu;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

import static android.widget.Toast.LENGTH_LONG;

public class LoginScreen extends AppCompatActivity  implements View.OnClickListener {

    TextView id, pw;
    Button enter;
    HttpConn conn = new HttpConn();
    Parser psr;
    String id_text,pw_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        id = (TextView) findViewById(R.id.id);
        pw = (TextView) findViewById(R.id.pw);
        enter = (Button) findViewById(R.id.enter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.enter:
                id_text = id.getText().toString();
                pw_text = pw.getText().toString();
                String response = null;
                NetworkTask networkTask = new NetworkTask(null);
                networkTask.execute();

                    break;
                }
        }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private ContentValues values;

        public NetworkTask(ContentValues values) {

            this.values = values;
        }

        @Override
        protected String doInBackground(Void... params) {

            String result; // 요청 결과를 저장할 변수.
            HttpConn conn = new HttpConn();
            String response = null; // 해당 URL로 부터 결과물을 얻어온다.
            try {
                response = conn.request("http://18.216.36.241/missu/user_authorization.php", id_text, pw_text);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    }

