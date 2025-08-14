package com.example.intent4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SmsActivity extends AppCompatActivity {

    EditText edtPhone, edtMessage;
    ImageButton btnSend;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        edtPhone = findViewById(R.id.edtPhone);
        edtMessage = findViewById(R.id.edtMessage);
        btnSend = findViewById(R.id.btnSend);
        btnBack = findViewById(R.id.btnBack);

        btnSend.setOnClickListener(v -> {
            String phone = edtPhone.getText().toString();
            String message = edtMessage.getText().toString();
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phone));
            smsIntent.putExtra("sms_body", message);
            startActivity(smsIntent);
        });

        btnBack.setOnClickListener(v -> finish());
    }
}