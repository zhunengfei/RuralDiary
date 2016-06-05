package com.tianyuan.ruraldiary.ui;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.tianyuan.ruraldiary.R;

public class ShowResultActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);
        button=(Button)findViewById(R.id.bt_show);
        Intent intent = getIntent ();
        if  ( Intent . ACTION_SEARCH . equals ( intent . getAction ()))  {
            String query = intent . getStringExtra ( SearchManager. QUERY );
            button.setText(query);
        }
    }
}
