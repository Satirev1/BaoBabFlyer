package com.example.user.baobabflyer;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class BaobabDrawer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_baobab_drawer );

        final Context thisAc = BaobabDrawer.this;
        Button btn_logo = (Button)findViewById( R.id.btn_baobablogo );
        btn_logo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_logo = new Intent( BaobabDrawer.this, BaobabMain.class );
                startActivity( btn_logo );
                finish();
            }
        } );

        Button btn_join = (Button)findViewById( R.id.btn_baobabJoin );
        btn_join.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_join = new Intent( BaobabDrawer.this, BaobabSignIn.class );
                startActivity( btn_join );
                finish();
            }
        } );

        Button btn_login = (Button)findViewById( R.id.btn_baobabLogin );
        btn_login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_login = new Intent( BaobabDrawer.this, BaobabCpMenu.class );
                startActivity( btn_login );
                finish();
            }
        } );

        Button review = (Button)findViewById( R.id.btn_review );
        review.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabReview.class) {
                    Intent review = new Intent( BaobabDrawer.this, BaobabReview.class );
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
                    Intent favorites = new Intent( BaobabDrawer.this, BaobabCall.class );
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
                    Intent callhis = new Intent( BaobabDrawer.this, BaobabCallHistory.class );
                    startActivity( callhis );
                    finish();
                }
            }
        } );

    }
    public void clickedLink(View v) {
        Intent link  = new Intent( Intent.ACTION_VIEW, Uri.parse( "http://m.naver.com/" ) );
        startActivity( link );
    }

    public void clickedCall(View v) {
        Intent call  = new Intent( Intent.ACTION_VIEW, Uri.parse( "tel:031-000-0000" ) );
        startActivity( call );
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
        //액티비티 애니메이션 x

    }



}
