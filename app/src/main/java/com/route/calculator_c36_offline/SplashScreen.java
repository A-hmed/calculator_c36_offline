package com.route.calculator_c36_offline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SplashScreen extends AppCompatActivity {
    Button gameButton, calculatorButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Log.e("MainActivity","on create");
        gameButton = findViewById(R.id.gameButton);
        calculatorButton = findViewById(R.id.calculatorButton);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SplashScreen.this, GameActivity.class);
                startActivity(intent);
            }
        });
        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActivity","on start");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainActivity","on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity","on pause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity","on Stop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity","on destroy");

    }
}