package com.k.missu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kjh on 2017. 11. 23..
 */

public class MainScreen extends AppCompatActivity {

    RecyclerView rec_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        rec_v = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        rec_v.setHasFixedSize(true);
        rec_v.setLayoutManager(layoutManager);

        List<Recycle_items> items=new ArrayList<>();
        Recycle_items[] item=new Recycle_items[5];
        for(int i = 0 ; i< 5 ;i ++){
            items.add(item[i]);
        }
        rec_v.setAdapter(new RecyclerAdapter(getApplicationContext(),items,R.layout.activity_main_screen));
    }


}
