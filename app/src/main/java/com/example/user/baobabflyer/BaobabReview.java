package com.example.user.baobabflyer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BaobabReview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_baobab_review );
        final Context thisAc = BaobabReview.this;

        Button logo_btn = (Button)findViewById( R.id.btn_baobablogo );
        logo_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logo_int = new Intent( BaobabReview.this, BaobabMain.class);
                startActivity( logo_int );
                finish();
            }
        } );

        Button review = (Button)findViewById( R.id.btn_review );
        review.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabReview.class) {
                    Intent review = new Intent( BaobabReview.this, BaobabReview.class );
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
                    Intent favorites = new Intent( BaobabReview.this, BaobabCall.class );
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
                    Intent callhis = new Intent( BaobabReview.this, BaobabCallHistory.class );
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
}
