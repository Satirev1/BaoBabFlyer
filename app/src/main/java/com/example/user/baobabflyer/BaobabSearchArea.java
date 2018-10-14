package com.example.user.baobabflyer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaobabSearchArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_baobab_search_area );
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
        //액티비티 애니메이션 x
        finish();
    }
}
