package com.example.calendar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText et1;
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.editnamduonglich);
        txt1 = findViewById(R.id.txtYear);
        btn1 = findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Lấy năm từ EditText
                    String yearStr = et1.getText().toString().trim();
                    if (yearStr.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập năm", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Chuyển đổi sang số
                    int year = Integer.parseInt(yearStr);
                    if (year < 0) {
                        Toast.makeText(MainActivity.this, "Năm phải lớn hơn hoặc bằng 0", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Chuyển đổi sang năm âm lịch
                    String lunarYear = convertToLunarYear(year);

                    // Hiển thị kết quả
                    txt1.setText(lunarYear);

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập năm hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Hàm chuyển đổi năm dương lịch sang năm âm lịch (can và chi)
    private String convertToLunarYear(int year) {
        // Mảng Thiên Can và Địa Chi
        String[] thienCan = {"Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý"};
        String[] diaChi = {"Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi"};

        // Tính offset dựa trên năm 1864 (Giáp Tý)
        int offset = year - 1864;
        if (offset < 0) {
            offset = (offset % 60 + 60) % 60; // Xử lý năm trước 1864
        }

        // Tính chỉ số Thiên Can và Địa Chi
        int canIndex = offset % 10;
        int chiIndex = offset % 12;

        // Kết hợp Thiên Can và Địa Chi
        return thienCan[canIndex] + " " + diaChi[chiIndex];
    }
}