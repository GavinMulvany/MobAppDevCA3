package com.example.gavinmulvany.samplelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.tomer.fadingtextview.FadingTextView;

public class About extends AppCompatActivity {
    private FadingTextView fadingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about); // connecting the right activity to the page

        fadingTextView = findViewById(R.id.fading_text_view); //setting up fading text here to use for my heading - ref: https://codinginflow.com/tutorials/android/fadingtextview
        TextView textView = (TextView) findViewById(R.id.textviewAbout);
        textView.setMovementMethod(new ScrollingMovementMethod()); //allowing the text view to be scrollable
    }
}