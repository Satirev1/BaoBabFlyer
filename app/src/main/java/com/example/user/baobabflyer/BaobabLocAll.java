package com.example.user.baobabflyer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BaobabLocAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_baobab_loc_all );

        Button btn_back = (Button)findViewById( R.id.btn_back );
        btn_back.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_back = new Intent( BaobabLocAll.this, BaobabLocSearch.class);
                startActivity( btn_back );
                finish();
            }
        } );
    }
}
