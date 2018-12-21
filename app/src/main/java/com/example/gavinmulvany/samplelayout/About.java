package com.example.gavinmulvany.samplelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tomer.fadingtextview.FadingTextView;

public class About extends AppCompatActivity {
    private FadingTextView fadingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        fadingTextView = findViewById(R.id.fading_text_view);
    }
}