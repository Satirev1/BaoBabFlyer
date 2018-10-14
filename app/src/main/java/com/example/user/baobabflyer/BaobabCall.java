package com.example.user.baobabflyer;

import android.app.Activity;
import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;

public class BaobabCall extends AppCompatActivity {

    private CheckBox cbAll = null;
    private CheckBox cb1 = null;
    private CheckBox cb2 = null;
    private CheckBox cb3 = null;
    private CheckBox cb4 = null;
    private CheckBox cb5 = null;
    private CheckBox cb6 = null;
    private CheckBox cb7 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_baobab_call );


        cbAll = (CheckBox)findViewById( R.id.checkbox_all );
        cb1 = (CheckBox)findViewById( R.id.checkbox1 );

        cbAll.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbAll.isChecked()){
                    cb1.setChecked( true );

                }else {
                    cb1.setChecked( false );

                }
            }
        } );

        cb1.setOnClickListener( onCheckBoxClickListener );


        final Context thisAc = BaobabCall.this;

        Button logo_btn = (Button)findViewById( R.id.btn_baobablogo );
        logo_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logo_int = new Intent( BaobabCall.this, BaobabMain.class);
                startActivity( logo_int );
                finish();
            }
        } );

        Button review = (Button)findViewById( R.id.btn_review );
        review.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabReview.class) {
                    Intent review = new Intent( BaobabCall.this, BaobabReview.class );
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
                    Intent favorites = new Intent( BaobabCall.this, BaobabCall.class );
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
                    Intent callhis = new Intent( BaobabCall.this, BaobabCallHistory.class );
                    startActivity( callhis );
                    finish();
                }
            }
        } );

    }
    private View.OnClickListener onCheckBoxClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isAllchecked()) {
                cbAll.setChecked( true );
            } else {
                cbAll.setChecked( false );
            }
        }
    };

    private  boolean isAllchecked(){
        return(cb1.isChecked() && cb2.isChecked() && cb3.isChecked()
                && cb4.isChecked() && cb5.isChecked() && cb6.isChecked() && cb7.isChecked())
                ? true : false;
    }

    public void clickedCall1(View v) {
        Intent myIntent1 = new Intent( Intent.ACTION_VIEW, Uri.parse( "tel:031-000-0000" ) );
        startActivity( myIntent1 );
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);

    }

    static Intent cpmenu1;
    public void clickedMenu1(View v) {
        cpmenu1 = new Intent( BaobabCall.this, BaobabMenu.class );
        cpmenu1.putExtra( "context", "call" );
        startActivity( cpmenu1 );
    }

}
