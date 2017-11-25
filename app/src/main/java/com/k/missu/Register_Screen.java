package com.k.missu;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;



/**
 * Created by kjh on 2017. 11. 25..
 */

public class Register_Screen extends AppCompatActivity implements View.OnClickListener{
    Button reg,check,back;
    TextView reg_id,reg_pw;
    HttpConn conn;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        reg = (Button) findViewById(R.id.register);
        check = (Button) findViewById(R.id.check);
        reg_id = (TextView) findViewById(R.id.reg_id);
        reg_pw = (TextView) findViewById(R.id.reg_pw);


    }
    @Override
    public void onClick(View v){

        switch (v.getId()) {
            case R.id.register_btn:
                Register_Screen.NetworkTask networkTask = new Register_Screen.NetworkTask(null);
                networkTask.execute();
                break;
            case R.id.back:
                Intent b = new Intent(getApplicationContext(),LoginScreen.class);
                startActivity(b);
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
                response = conn.HttpGET("http://18.216.36.241/missu/user_registeration.php?id=" + reg_id.toString() + "&pw=" + reg_pw.toString());
                result = response.getString("success");
                System.out.println("doinbackgr_reg = "+result);
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
                System.out.println("Registeration Failed");
                Toast.makeText(getApplicationContext(), "Registeration Failed", Toast.LENGTH_SHORT).show();
                result = null;
            }else if (result.equals("1")){
                Intent i = new Intent(getApplicationContext(),LoginScreen.class);
                Toast.makeText(getApplicationContext(),"Registeration Successed",Toast.LENGTH_LONG).show();
                startActivity(i);
                finish();
            }
        }
    }
}
