// modified from https://www.youtube.com/watch?v=-YCUrHFUxlA
// Created by: Gavin Mulvany - x15448892

package com.example.gavinmulvany.samplelayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //declare card vars
        private CardView timesCard, thingsCard, statsCard, crimeCard, creditCard, roadCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining cards
        timesCard  = (CardView) findViewById(R.id.times_card); //bus
        thingsCard = (CardView) findViewById(R.id.things_card); //things
        statsCard = (CardView) findViewById(R.id.stat_card); //stat
        crimeCard = (CardView) findViewById(R.id.crime_card); //bus
        creditCard = (CardView) findViewById(R.id.credit_card);
        roadCard = (CardView) findViewById(R.id.road_card); //bus



        // add click listeners to cards
        timesCard.setOnClickListener(this);
        thingsCard.setOnClickListener(this);
        statsCard.setOnClickListener(this);
        crimeCard.setOnClickListener(this);
        creditCard.setOnClickListener(this);
        roadCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        //starting activity
        switch (v.getId()){
            case R.id.times_card: i = new Intent(this,BusTimes.class); startActivity(i); break;
            case R.id.things_card: i = new Intent(this,ThingsToDo.class); startActivity(i); break;
            case R.id.stat_card: i = new Intent(this,School.class); startActivity(i); break;
            case R.id.crime_card: i = new Intent(this,CrimeStats.class); startActivity(i); break;
            case R.id.credit_card: i = new Intent(this,About.class); startActivity(i); break;
            case R.id.road_card: i = new Intent(this,RoadAccidents.class); startActivity(i); break;



            default:break;
        }

    }
}
