package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button startbtn, stopbtn,  broadbtn  ;
    String t = "false";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbtn = findViewById(R.id.start);
        stopbtn = findViewById(R.id.stop);
        broadbtn = findViewById(R.id.broad);

        startbtn.setOnClickListener(this);
        stopbtn.setOnClickListener(this);
        broadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction("com.example.service,MYservice");
                intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);


            }
        });


    }
    @Override
    public void onClick(View v) {

        if (v==startbtn && t =="false"){
            t="true";
            Intent intent=new Intent(this,Myservice.class);
            startService(intent);


        }
        else if (v==stopbtn && t == "true" ){
            t = "false";
            Intent intent=new Intent(this,Myservice.class);
            stopService(intent);

        }}
       /* public void brodcastt(View v){
            Intent intent=new Intent();
            intent.setAction("android.intent.action.BATTERY_LOW");
            intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
           sendBroadcast(intent);


        }*/



}