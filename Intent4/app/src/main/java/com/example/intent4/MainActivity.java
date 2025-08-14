package com.example.intent4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnCall, btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btnCall);
        btnSms = findViewById(R.id.btnSms);

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CallActivity.class);
            startActivity(intent);
        });

        btnSms.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SmsActivity.class);
            startActivity(intent);
        });
    }
}