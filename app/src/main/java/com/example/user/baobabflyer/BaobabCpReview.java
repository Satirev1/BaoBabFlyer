package com.example.user.baobabflyer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class BaobabCpReview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_baobab_cp_review );
        final Context thisAc = BaobabCpReview.this;

        Button logo_btn = (Button)findViewById( R.id.btn_baobablogo );
        logo_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logo_int = new Intent( BaobabCpReview.this, BaobabMain.class );
                startActivity( logo_int );
                finish();
            }
        } );

        Button review = (Button)findViewById( R.id.btn_review );
        review.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabReview.class) {
                    Intent review = new Intent( BaobabCpReview.this, BaobabReview.class );
                    startActivity( review );
                    finish();
                }
            }
        } );

        Button favorites = (Button)findViewById( R.id.btn_favorites );
        favorites.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabCall.class) {
                    Intent favorites = new Intent( BaobabCpReview.this, BaobabCall.class );
                    startActivity( favorites );
                    finish();
                }
            }
        } );

        Button callhis = (Button)findViewById( R.id.btn_callhis );
        callhis.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabCallHistory.class) {
                    Intent callhis = new Intent( BaobabCpReview.this, BaobabCallHistory.class );
                    startActivity( callhis );
                    finish();
                }
            }
        } );
    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
        //액티비티 애니메이션 x

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                Intent intent = new Intent( BaobabCpReview.this, BaobabMenu.class );
                startActivity( intent );
                finish();
        }
        return false;
    }
}
