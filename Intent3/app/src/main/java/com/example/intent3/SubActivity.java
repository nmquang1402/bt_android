package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivity extends AppCompatActivity {

    EditText edtNhanA, edtNhanB;
    Button btnTong, btnHieu;
    TextView tvKetQua;
    int a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edtNhanA = findViewById(R.id.edtNhanA);
        edtNhanB = findViewById(R.id.edtNhanB);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        tvKetQua = findViewById(R.id.tvKetQua);

        // Lấy dữ liệu từ màn hình 1
        a = getIntent().getIntExtra("A", 0);
        b = getIntent().getIntExtra("B", 0);

        edtNhanA.setText(String.valueOf(a));
        edtNhanB.setText(String.valueOf(b));

        // Nút tính tổng
        btnTong.setOnClickListener(v -> tvKetQua.setText("Tổng: " + (a + b)));

        // Nút tính hiệu
        btnHieu.setOnClickListener(v -> tvKetQua.setText("Hiệu: " + (a - b)));
    }
}