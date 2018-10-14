package com.example.user.baobabflyer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;


public class BaobabNonCP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_baobab_non_cp );
        final Context thisAc = BaobabNonCP.this;

        Button review = (Button)findViewById( R.id.btn_review );
        review.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thisAc.getClass() != BaobabReview.class){
                    Intent review = new Intent( BaobabNonCP.this, BaobabReview.class );
                    startActivity( review );
                }
            }
        } );

        Button favorites = (Button)findViewById( R.id.btn_favorites );
        favorites.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thisAc.getClass() != BaobabCall.class){
                    Intent favorites = new Intent( BaobabNonCP.this, BaobabCall.class );
                    startActivity( favorites );
                }
            }
        } );

        Button callhis = (Button)findViewById( R.id.btn_callhis );
        callhis.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thisAc.getClass() != BaobabCallHistory.class){
                    Intent callhis = new Intent( BaobabNonCP.this, BaobabCallHistory.class );
                    startActivity( callhis );
                }
            }
        } );

    }
    public void clickedCall(View v) {
        Intent call  = new Intent( Intent.ACTION_VIEW, Uri.parse( "tel:02-1234-0123" ) );
        startActivity( call );
    }

    public void clickedCall2(View v) {
        Intent call2  = new Intent( Intent.ACTION_VIEW, Uri.parse( "tel:02-1234-0123" ) );
        startActivity( call2 );
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                Intent intent = new Intent( BaobabNonCP.this, BaobabPage.class );
                startActivity( intent );
                finish();
        }
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
        //액티비티 애니메이션 x
    }
}
