package com.example.manoj_nilanga.gotcha;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

public class MainActivity extends AppCompatActivity {

    int MY_PERMISSION_REQUEST_SEND_SMS =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendMeSms();
    }

    public void sendMeSms(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSION_REQUEST_SEND_SMS);
            sendMeSms();
        }
        else
        {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage("0779089211",null,"Gotcha",null,null);

        }
    }
}
