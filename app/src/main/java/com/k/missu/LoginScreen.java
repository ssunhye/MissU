package com.k.missu;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;


public class LoginScreen extends AppCompatActivity  implements View.OnClickListener {

    TextView id, pw;
    Button enter,reg;
    HttpConn conn = new HttpConn();
    String id_text,pw_text;
    String result = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        id = (TextView) findViewById(R.id.id);
        pw = (TextView) findViewById(R.id.pw);
        enter = (Button) findViewById(R.id.enter);
        reg = (Button) findViewById(R.id.register);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.enter:
                id_text = id.getText().toString();
                pw_text = pw.getText().toString();
                NetworkTask networkTask = new NetworkTask(null);
                networkTask.execute();

                break;
            case R.id.register:
                Log.d("register","go to register screen");
                Intent r = new Intent(this.getApplicationContext(),Register_Screen.class);
                startActivity(r);
                finish();

                }
        }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private ContentValues values;

        public NetworkTask(ContentValues values) {

            this.values = values;
        }

        @Override
        protected String doInBackground(Void... params) {

            HttpConn conn = new HttpConn();
            JSONObject response;
            try {
                response = conn.HttpGET("http://18.216.36.241/missu/user_authorization.php?id=" + id_text + "&pw=" + pw_text);
                result = response.getString("success");
                System.out.println("doinbackgr = "+result);
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;//fail
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            System.out.println("main result = "+result);

            if(result.equals("0")){
                System.out.println("Login Failed");
                Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                result = null;
            }else if (result.equals("1")){
                Intent i = new Intent(getApplicationContext(),MainScreen.class);
                startActivity(i);
                finish();
            }
        }
    }

    }