package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtA, edtB;
    Button btnYeuCau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnYeuCau = findViewById(R.id.btnYeuCau);

        btnYeuCau.setOnClickListener(v -> {
            int a = Integer.parseInt(edtA.getText().toString());
            int b = Integer.parseInt(edtB.getText().toString());

            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            intent.putExtra("A", a);
            intent.putExtra("B", b);
            startActivity(intent);
        });
    }
}