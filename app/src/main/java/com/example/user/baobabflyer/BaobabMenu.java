package com.example.user.baobabflyer;

import android.accounts.NetworkErrorException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class BaobabMenu extends AppCompatActivity {

    LinearLayout lo;
    Button morebt;
    LinearLayout setMenu;
    LinearLayout mainMenu;
    LinearLayout childMenu;
    LinearLayout sideMenu;
    LinearLayout drinkMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_baobab_menu );
        final Context thisAc = BaobabMenu.this;

        lo = (LinearLayout) findViewById( R.id.hideReview );
        lo.setVisibility( View.GONE );
        morebt = (Button) findViewById( R.id.reviewMore );
        morebt.setText( "더보기" );

        setMenu = findViewById( R.id.setMenu );
        mainMenu = findViewById( R.id.mainMenu );
        childMenu = findViewById( R.id.childMenu );
        sideMenu = findViewById( R.id.sideMenu );
        drinkMenu = findViewById( R.id.drinkMenu );

        Button review = (Button) findViewById( R.id.btn_review );
        review.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabReview.class) {
                    Intent review = new Intent( BaobabMenu.this, BaobabReview.class );
                    startActivity( review );
                    finish();
                }
            }
        } );

        Button favorites = (Button) findViewById( R.id.btn_favorites );
        favorites.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabCall.class) {
                    Intent favorites = new Intent( BaobabMenu.this, BaobabCall.class );
                    startActivity( favorites );
                    finish();
                }
            }
        } );

        Button callhis = (Button) findViewById( R.id.btn_callhis );
        callhis.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabCallHistory.class) {
                    Intent callhis = new Intent( BaobabMenu.this, BaobabCallHistory.class );
                    startActivity( callhis );
                    finish();
                }
            }
        } );

        Button allView = (Button) findViewById( R.id.btn_allView );
        allView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allView = new Intent( BaobabMenu.this, BaobabCpReview.class );
                startActivity( allView );
                finish();
            }
        } );
    }

    public void clickedMore(View v) {
        if (lo.getVisibility() == View.GONE) {
            lo.setVisibility( View.VISIBLE );
            morebt.setText( "접기" );
        } else {
            lo.setVisibility( View.GONE );
            morebt.setText( "더보기" );
        }
    }

    public void clickedSet(View v) {
        if (setMenu.getVisibility() == View.GONE) {
            setMenu.setVisibility( View.VISIBLE );
        } else {
            setMenu.setVisibility( View.GONE );
        }
    }

    public void clickedMain(View v) {
        if (mainMenu.getVisibility() == View.GONE) {
            mainMenu.setVisibility( View.VISIBLE );
        } else {
            mainMenu.setVisibility( View.GONE );
        }
    }

    public void clickedChild(View v) {
        if (childMenu.getVisibility() == View.GONE) {
            childMenu.setVisibility( View.VISIBLE );
        } else {
            childMenu.setVisibility( View.GONE );
        }
    }

    public void clickedSide(View v) {
        if (sideMenu.getVisibility() == View.GONE) {
            sideMenu.setVisibility( View.VISIBLE );
        } else {
            sideMenu.setVisibility( View.GONE );
        }
    }

    public void clickedDrink(View v) {
        if (drinkMenu.getVisibility() == View.GONE) {
            drinkMenu.setVisibility( View.VISIBLE );
        } else {
            drinkMenu.setVisibility( View.GONE );
        }
    }


    public void clickedSelect(View v) {

    }

    public void clickedCall(View v) {
        Intent myIntent = new Intent( Intent.ACTION_VIEW, Uri.parse( "tel:01097934005" ) );
        startActivity( myIntent );
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
                Intent getCon = getIntent();
                if(getCon.getStringExtra( "context" ).toString().equals( "page" )){
                    switch (keyCode){
                        case KeyEvent.KEYCODE_BACK:
                            Intent intent = new Intent( BaobabMenu.this, BaobabPage.class );
                            startActivity( intent );
                            finish();
                    }
                }else if (getCon.getStringExtra( "context" ).toString().equals( "call" )){
                    switch (keyCode){
                        case KeyEvent.KEYCODE_BACK:
                            Intent intent = new Intent( BaobabMenu.this, BaobabCall.class );
                            startActivity( intent );
                            finish();
                    }
                }

        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition( 0, 0 );
    }
}

    /*public void clickedPlus(View v){
        TextView count = (TextView)findViewById(R.id.count);
        int countNum = Integer.parseInt(count.getText().toString());
        Integer setNum = countNum+1;
        String setStr = setNum.toString();
        count.setText(setStr);
    }
    public void clickedMinus(View v){
        TextView count = (TextView)findViewById(R.id.count);
        int countNum = Integer.parseInt(count.getText().toString());
        if(countNum > 0){
            Integer setNum = countNum - 1;
            String setStr = setNum.toString();
            count.setText(setStr);
        }else{
            Integer setNum = countNum;
            String setStr = setNum.toString();
            count.setText(setStr);
        }
    }*/


