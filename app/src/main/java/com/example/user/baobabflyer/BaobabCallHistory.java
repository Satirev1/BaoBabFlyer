package com.example.user.baobabflyer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BaobabCallHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_baobab_call_history );


        final Context thisAc = BaobabCallHistory.this;

        Button logo_btn = (Button)findViewById( R.id.btn_baobablogo );
        logo_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logo_int = new Intent( BaobabCallHistory.this, BaobabMain.class);
                startActivity( logo_int );
                finish();
            }
        } );

        Button review = (Button)findViewById( R.id.btn_review );
        review.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabReview.class) {
                    Intent review = new Intent( BaobabCallHistory.this, BaobabReview.class );
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
                    Intent favorites = new Intent( BaobabCallHistory.this, BaobabCall.class );
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
                    Intent callhis = new Intent( BaobabCallHistory.this, BaobabCallHistory.class );
                    startActivity( callhis );
                    finish();
                }
            }
        } );

    }
    public void clickedCall1(View v) {
        Intent myIntent1 = new Intent( Intent.ACTION_VIEW, Uri.parse( "tel:031-000-0000" ) );
        startActivity( myIntent1 );
    }
    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
        // Remove the activity when its off the s
    }



}
