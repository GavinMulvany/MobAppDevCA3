// modified from https://www.youtube.com/watch?v=-YCUrHFUxlA
// Created by: Gavin Mulvany - x15448892

package com.example.gavinmulvany.samplelayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private CardView forumCard, thingsCard, statsCard, busCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining cards
        forumCard = (CardView) findViewById(R.id.forum_card); //forum
        thingsCard = (CardView) findViewById(R.id.things_card); //things
        statsCard = (CardView) findViewById(R.id.stat_card); //stat
        busCard = (CardView) findViewById(R.id.bus_card); //bus

        // add click listeners to cards
        forumCard.setOnClickListener(this);
        thingsCard.setOnClickListener(this);
        statsCard.setOnClickListener(this);
        busCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.forum_card: i = new Intent(this,Forum.class); startActivity(i); break;
            case R.id.things_card: i = new Intent(this,Things.class); startActivity(i); break;
            case R.id.stat_card: i = new Intent(this,Add.class); startActivity(i); break;
            case R.id.bus_card: i = new Intent(this,Bus.class); startActivity(i); break;

            default:break;
        }

    }
}
