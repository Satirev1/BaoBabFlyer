package com.example.user.baobabflyer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class BaobabPage extends AppCompatActivity {

    Spinner Main_spinner;
    Spinner Main_spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_baobab_page );
        final Context thisAc = BaobabPage.this;

        Main_spinner = (Spinner) findViewById( R.id.spinner1 );
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.address, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        Main_spinner.setAdapter( adapter );

        Intent intent = getIntent();
        Main_spinner.setSelection( intent.getIntExtra( "loc", 0 ) );

        Main_spinner2 = (Spinner) findViewById( R.id.spinner2 );
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource( this, R.array.business, android.R.layout.simple_spinner_item );
        adapter2.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        Main_spinner2.setAdapter( adapter2 );

        Intent secIntent = new Intent(BaobabPage.this, BaobabMenu.class);
        if (intent.getStringExtra( "menu" ).toString().equals( "한식" )) {
            Main_spinner2.setSelection( 0 );
        } else if (intent.getStringExtra( "menu" ).toString().equals( "중식" )) {
            Main_spinner2.setSelection( 1 );
        } else if(intent.getStringExtra( "menu" ).toString().equals( "일식" )) {
            Main_spinner2.setSelection( 2 );
        } else if(intent.getStringExtra( "menu" ).toString().equals( "술집/포장마차" )) {
            Main_spinner2.setSelection( 3 );
        } else if(intent.getStringExtra( "menu" ).toString().equals( "레스토랑" )) {
            Main_spinner2.setSelection( 4 );
        } else if(intent.getStringExtra( "menu" ).toString().equals( "카페/디저트" )) {
            Main_spinner2.setSelection( 5 );
        } else if(intent.getStringExtra( "menu" ).toString().equals( "찜/탕" )) {
            Main_spinner2.setSelection( 6 );
        } else if(intent.getStringExtra( "menu" ).toString().equals( "고기집" )) {
            Main_spinner2.setSelection( 7 );
        } else if(intent.getStringExtra( "menu" ).toString().equals( "치킨/피자" )) {
            Main_spinner2.setSelection( 8 );
        } else if(intent.getStringExtra( "menu" ).toString().equals( "분식/도시락" )) {
            Main_spinner2.setSelection( 9 );
        } else if(intent.getStringExtra( "menu" ).toString().equals( "제과제빵/면요리" )) {
            Main_spinner2.setSelection( 10 );
        } else if(intent.getStringExtra( "menu" ).toString().equals( "기타" )) {
            Main_spinner2.setSelection( 11 );
        }

        Button logo_btn = (Button) findViewById( R.id.btn_baobablogo );
        logo_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logo_int = new Intent( BaobabPage.this, BaobabMain.class );
                startActivity( logo_int );
                finish();
            }
        } );

        Button review = (Button) findViewById( R.id.btn_review );
        review.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabReview.class) {
                    Intent review = new Intent( BaobabPage.this, BaobabReview.class );
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
                    Intent favorites = new Intent( BaobabPage.this, BaobabCall.class );
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
                    Intent callhis = new Intent( BaobabPage.this, BaobabCallHistory.class );
                    startActivity( callhis );
                    finish();
                }
            }
        } );
    }

    static Intent cpmenu1;

    public void clickedCp1(View v) {
        cpmenu1 = new Intent( BaobabPage.this, BaobabMenu.class );
        cpmenu1.putExtra( "context", "page" );
        startActivity( cpmenu1 );
    }

    public void clickedNonCp1(View v) {
        Intent noncpmenu1 = new Intent( BaobabPage.this, BaobabNonCP.class );
        startActivity( noncpmenu1 );
    }

    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition( 0, 0 );
        // Remove the activity when its off the s

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                Intent intent = new Intent( BaobabPage.this, BaobabMain.class );
                startActivity( intent );
        }
        return false;
    }


}
