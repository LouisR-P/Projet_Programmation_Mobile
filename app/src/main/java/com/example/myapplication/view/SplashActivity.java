package com.example.myapplication.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.R;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class SplashActivity extends AppCompatActivity {

    private static int time=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_spalsh);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in=new Intent(SplashActivity.this, MainActivity.class);
                startActivity(in);
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                finish();
            }
        },time);
    }
}