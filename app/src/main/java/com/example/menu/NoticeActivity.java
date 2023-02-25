package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NoticeActivity extends AppCompatActivity {
    TextView tv_show2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        tv_show2 = findViewById(R.id.tv_showNo);
        Bundle extra = getIntent().getExtras();
        String value =extra.getString("keymsg");
        tv_show2.setText(value);
    }
}