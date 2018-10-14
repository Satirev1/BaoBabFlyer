package com.example.user.baobabflyer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class BaobabSignIn extends AppCompatActivity {

    CheckBox firstCheck;
    CheckBox secondCheck;
    Button nextBtn;
    EditText setPw;
    EditText setPwCheck;
    TextView pwChecker;
    EditText userMail;
    EditText userPhone;
    EditText licenseNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_baobab_sign_in );

        firstCheck = (CheckBox)findViewById(R.id.firstCheck); //체크박스
        secondCheck = (CheckBox)findViewById(R.id.secondCheck); //체크박스
        nextBtn = (Button)findViewById(R.id.nextBtn); //다음버튼

        setPw = (EditText)findViewById(R.id.setPw); //비밀번호
        setPwCheck = (EditText)findViewById(R.id.setPwCheck); //비밀번호 확인
        pwChecker = (TextView)findViewById(R.id.pwChecker); //비밀번호 확인 메세지

        userMail = (EditText)findViewById(R.id.userMail);
        userPhone = (EditText)findViewById(R.id.userPhone);

        licenseNum = (EditText)findViewById(R.id.licenseNum);

        String firstPw = setPw.getText().toString();
        String secondPw = setPwCheck.getText().toString();

        if(firstPw.toString().equals(secondPw.toString()) && firstPw.equals( null ) && secondPw.equals( null )){
            pwChecker.setTextColor( Color.GREEN);
            pwChecker.setText("비밀번호가 일치합니다.");
        }else {
            pwChecker.setText("비밀번호가 일치하지 않습니다.");
        }

        if(firstCheck.isChecked() || secondCheck.isChecked() || firstPw.toString().equals(secondPw.toString())){
            nextBtn.setEnabled(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
        //액티비티 애니메이션 x
        finish();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                Intent intent = new Intent( BaobabSignIn.this, BaobabDrawer.class );
                startActivity( intent );
                finish();
        }
        return false;
    }
}
