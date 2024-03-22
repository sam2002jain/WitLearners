package com.example.witlearners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {

    String message = "hello sanyam";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Log.e(message,"splash activity runs");

        TextView textView = findViewById(R.id.txtviewSplash);
        textView.animate().translationX(2000).setDuration(3500).setStartDelay(1500);
        Thread thread = new Thread(){
            public void run(){
                try{
                    Thread.sleep(4000);
                }catch(Exception e){
                    e.printStackTrace();
                }

                finally{
                    Intent intent = new Intent(splashscreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        };
        thread.start();


    }
}