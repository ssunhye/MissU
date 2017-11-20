package com.k.missu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginScreen extends AppCompatActivity {

    TextView id, pw;
    Button enter;
    HttpConn conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);


        id = (TextView) findViewById(R.id.id);
        pw = (TextView) findViewById(R.id.pw);
        enter = (Button) findViewById(R.id.enter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_text = id.getText().toString();
                String pw_text = pw.getText().toString();
                String response = conn.request("http://18.216.36.241/missu/user_authorization.php",id_text,pw_text);

            }
        });
    }
}
