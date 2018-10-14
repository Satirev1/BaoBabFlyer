package com.example.user.baobabflyer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class BaobabMain extends AppCompatActivity {


    Spinner Main_spinner;
    Spinner Main_spinner2;
    private BackPressCloseHandler backPressCloseHandler;

    EditText myEditText;
    Button btn;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_baobab_main );
        final Context thisAc = BaobabMain.this;
        backPressCloseHandler = new BackPressCloseHandler( this );

        myEditText = (EditText) findViewById( R.id.myEditText );
        myEditText.setOnEditorActionListener( new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
                if (arg1 == EditorInfo.IME_ACTION_SEARCH) {
                    //검색매서드 넣으셈
                    return true;
                }
                return false;
            }
        } );

        LocationManager lm = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

        try {
            // GPS 제공자의 정보가 바뀌면 콜백하도록 리스너 등록하기~!!!
            lm.requestLocationUpdates( LocationManager.GPS_PROVIDER, // 등록할 위치제공자
                    100, // 통지사이의 최소 시간간격 (miliSecond)
                    1, // 통지사이의 최소 변경거리 (m)
                    mLocationListener );
            lm.requestLocationUpdates( LocationManager.NETWORK_PROVIDER, // 등록할 위치제공자
                    100, // 통지사이의 최소 시간간격 (miliSecond)
                    1, // 통지사이의 최소 변경거리 (m)
                    mLocationListener );
        } catch (SecurityException ex) {
            ex.printStackTrace();
        }
        btn = findViewById( R.id.btn_gps );
        if (btn.getText().toString().equals( null ) || btn.getText().toString().equals( "현 위치 탐색중..." ))
            lm.removeUpdates( mLocationListener );

        Main_spinner = (Spinner) findViewById( R.id.spinner );
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.address, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        Main_spinner.setAdapter( adapter );

        Main_spinner2 = (Spinner) findViewById( R.id.spinner2 );
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource( this, R.array.classify, android.R.layout.simple_spinner_item );
        adapter2.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        Main_spinner2.setAdapter( adapter2 );

        Button logo_btn = (Button) findViewById( R.id.btn_baobablogo );
        logo_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logo_int = new Intent( BaobabMain.this, BaobabMain.class );
                startActivity( logo_int );
            }
        } );

        Button logo_gps = (Button) findViewById( R.id.btn_gps );
        logo_gps.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logo_gps = new Intent( BaobabMain.this, BaobabLocSearch.class );
                startActivity( logo_gps );
            }
        } );

        Button menu_btn1 = (Button) findViewById( R.id.menu1 );
        menu_btn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_int1 = new Intent( BaobabMain.this, BaobabPage.class );
                menu_int1.putExtra( "loc", Main_spinner.getSelectedItemPosition() );
                menu_int1.putExtra( "menu", v.getTag().toString() );
                startActivity( menu_int1 );

            }
        } );

        Button menu_btn2 = (Button) findViewById( R.id.menu2 );
        menu_btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_int2 = new Intent( BaobabMain.this, BaobabPage.class );
                menu_int2.putExtra( "loc", Main_spinner.getSelectedItemPosition() );
                menu_int2.putExtra( "menu", v.getTag().toString() );
                startActivity( menu_int2 );
            }
        } );

        Button menu_btn3 = (Button) findViewById( R.id.menu3 );
        menu_btn3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_int3 = new Intent( BaobabMain.this, BaobabPage.class );
                menu_int3.putExtra( "loc", Main_spinner.getSelectedItemPosition() );
                menu_int3.putExtra( "menu", v.getTag().toString() );
                startActivity( menu_int3 );
            }
        } );

        Button menu_btn4 = (Button) findViewById( R.id.menu4 );
        menu_btn4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_int4 = new Intent( BaobabMain.this, BaobabPage.class );
                menu_int4.putExtra( "loc", Main_spinner.getSelectedItemPosition() );
                menu_int4.putExtra( "menu", v.getTag().toString() );
                startActivity( menu_int4 );
            }
        } );

        Button menu_btn5 = (Button) findViewById( R.id.menu5 );
        menu_btn5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_int5 = new Intent( BaobabMain.this, BaobabPage.class );
                menu_int5.putExtra( "loc", Main_spinner.getSelectedItemPosition() );
                menu_int5.putExtra( "menu", v.getTag().toString() );
                startActivity( menu_int5 );
            }
        } );

        Button menu_btn6 = (Button) findViewById( R.id.menu6 );
        menu_btn6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_int6 = new Intent( BaobabMain.this, BaobabPage.class );
                menu_int6.putExtra( "loc", Main_spinner.getSelectedItemPosition() );
                menu_int6.putExtra( "menu", v.getTag().toString() );
                startActivity( menu_int6 );
            }
        } );

        Button menu_btn7 = (Button) findViewById( R.id.menu7 );
        menu_btn7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_int7 = new Intent( BaobabMain.this, BaobabPage.class );
                menu_int7.putExtra( "loc", Main_spinner.getSelectedItemPosition() );
                menu_int7.putExtra( "menu", v.getTag().toString() );
                startActivity( menu_int7 );
            }
        } );

        Button menu_btn8 = (Button) findViewById( R.id.menu8 );
        menu_btn8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_int8 = new Intent( BaobabMain.this, BaobabPage.class );
                menu_int8.putExtra( "loc", Main_spinner.getSelectedItemPosition() );
                menu_int8.putExtra( "menu", v.getTag().toString() );
                startActivity( menu_int8 );
            }
        } );

        Button menu_btn9 = (Button) findViewById( R.id.menu9 );
        menu_btn9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_int9 = new Intent( BaobabMain.this, BaobabPage.class );
                menu_int9.putExtra( "loc", Main_spinner.getSelectedItemPosition() );
                menu_int9.putExtra( "menu", v.getTag().toString() );
                startActivity( menu_int9 );
            }
        } );

        Button menu_btn10 = (Button) findViewById( R.id.menu10 );
        menu_btn10.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_int10 = new Intent( BaobabMain.this, BaobabPage.class );
                menu_int10.putExtra( "loc", Main_spinner.getSelectedItemPosition() );
                menu_int10.putExtra( "menu", v.getTag().toString() );
                startActivity( menu_int10 );
            }
        } );

        Button menu_btn11 = (Button) findViewById( R.id.menu11 );
        menu_btn11.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_int11 = new Intent( BaobabMain.this, BaobabPage.class );
                menu_int11.putExtra( "loc", Main_spinner.getSelectedItemPosition() );
                menu_int11.putExtra( "menu", v.getTag().toString() );
                startActivity( menu_int11 );
            }
        } );

        Button menu_btn12 = (Button) findViewById( R.id.menu12 );
        menu_btn12.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_int12 = new Intent( BaobabMain.this, BaobabPage.class );
                menu_int12.putExtra( "loc", Main_spinner.getSelectedItemPosition() );
                menu_int12.putExtra( "menu", v.getTag().toString() );
                startActivity( menu_int12 );
            }
        } );

        Button review = (Button) findViewById( R.id.btn_review );
        review.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabReview.class) {
                    Intent review = new Intent( BaobabMain.this, BaobabReview.class );
                    startActivity( review );
                }
            }
        } );

        Button favorites = (Button) findViewById( R.id.btn_favorites );
        favorites.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabCall.class) {
                    Intent favorites = new Intent( BaobabMain.this, BaobabCall.class );
                    startActivity( favorites );
                }
            }
        } );

        Button callhis = (Button) findViewById( R.id.btn_callhis );
        callhis.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thisAc.getClass() != BaobabCallHistory.class) {
                    Intent callhis = new Intent( BaobabMain.this, BaobabCallHistory.class );
                    startActivity( callhis );
                }
            }
        } );

        Button openDrawer = (Button) findViewById( R.id.openDrawer );
        openDrawer.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openDrawer = new Intent( BaobabMain.this, BaobabDrawer.class );
                startActivity( openDrawer );

            }
        } );
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();

    }

    private final LocationListener mLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            //여기서 위치값이 갱신되면 이벤트가 발생한다.
            //값은 Location 형태로 리턴되며 좌표 출력 방법은 다음과 같다.
            Log.d( "test", "onLocationChanged, location:" + location );
            double longitude = location.getLongitude(); //경도
            double latitude = location.getLatitude();   //위도
            double altitude = location.getAltitude();   //고도
            float accuracy = location.getAccuracy();    //정확도
            String provider = location.getProvider();   //위치제공자
            //Gps 위치제공자에 의한 위치변화. 오차범위가 좁다.
            //Network 위치제공자에 의한 위치변화
            //Network 위치는 Gps에 비해 정확도가 많이 떨어진다.
            GeocodeUtil.GeoLocation geolocation = new GeocodeUtil.GeoLocation( location.getLatitude(), location.getLongitude() );
            GeocodeUtil geocodeUtil = new GeocodeUtil( BaobabMain.this );
            //parsing( result );
            ArrayList<String> arr = geocodeUtil.getAddressListUsingGeolocation( geolocation );
            String addrStr = arr.get( 0 ).toString().substring( 29,
                    arr.get( 0 ).toString().indexOf( "\"]" ) );
            btn.setText( "현 위치 탐색중..." );

            btn = findViewById( R.id.btn_gps );
            btn.setText( addrStr );//주소 뿌리는 변수
        }

        public void onProviderDisabled(String provider) {
            // Disabled시
            Log.d( "test", "onProviderDisabled, provider:" + provider );
        }

        public void onProviderEnabled(String provider) {
            // Enabled시
            Log.d( "test", "onProviderEnabled, provider:" + provider );
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            // 변경시
            Log.d( "test", "onStatusChanged, provider:" + provider + ", status:" + status + " ,Bundle:" + extras );
        }
    };

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged( newConfig );
        Toast.makeText( this, newConfig.toString(), Toast.LENGTH_LONG ).show();
    }
    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
    }
}

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                moveTaskToBack( true);
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
        }
        return false;
    }

}*/



