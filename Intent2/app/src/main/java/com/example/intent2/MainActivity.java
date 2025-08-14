package com.example.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edta,edtb;
    Button btnkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edta = findViewById(R.id.txta);
        edtb = findViewById(R.id.txtb);
        btnkq = findViewById(R.id.btnketqua);

        btnkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(edta.getText().toString());
                double b = Double.parseDouble(edtb.getText().toString());

                Intent intent = new Intent(MainActivity.this, ketqua.class);
                intent.putExtra("soa", a);
                intent.putExtra("sob", b);
                startActivity(intent);
            }
        });
    }

}