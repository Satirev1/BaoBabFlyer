package com.example.user.baobabflyer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BaobabLocSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_baobab_loc_search );

        Button btn_search = (Button)findViewById( R.id.btn_search);
        btn_search.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_search = new Intent( BaobabLocSearch.this, BaobabLocAll.class);
                startActivity( btn_search );
            }
        } );

        Button btn_back = (Button)findViewById( R.id.btn_back );
        btn_back.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_back = new Intent( BaobabLocSearch.this, BaobabMain.class);
                startActivity( btn_back );
                finish();
            }
        } );

        Button btn_map = (Button)findViewById( R.id.btn_map );
        btn_map.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_map = new Intent( BaobabLocSearch.this, BaobabMap.class);
                startActivity( btn_map );
            }
        } );
    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
        //액티비티 애니메이션 x

    }

}
