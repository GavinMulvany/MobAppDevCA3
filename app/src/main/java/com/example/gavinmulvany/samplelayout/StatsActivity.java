package com.example.gavinmulvany.samplelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.text.method.ScrollingMovementMethod;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StatsActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crime_stats);

        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);

        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });

        TextView textView = (TextView) findViewById(R.id.text_view_result);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    private void jsonParse() {

        String url = "https://api.myjson.com/bins/ridl8";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("statistics");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject statistics = jsonArray.getJSONObject(i);

                                String SchoolName = statistics.getString("SchoolName");
                                String Address = statistics.getString("Address");
                                String  SchoolLevel= statistics.getString("SchoolLevel");
                                int NumberOfMales = statistics.getInt("NumberOfMales");
                                int  NumberOfFemales= statistics.getInt("NumberOfFemales");

                                mTextViewResult.append("School Name: " +SchoolName + "\n" + "Address: " +Address + "\n"  + "Type: "+SchoolLevel + "\n"  + "Number of Boys: " +String.valueOf(NumberOfMales) + "\n " +  "Number of Girls: " +String.valueOf(NumberOfFemales) + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}
//    private CardView crimeCard, populationCard, schoolCard, constructionCard;



//        //def the cards
//        crimeCard = (CardView) findViewById(R.id.crime_card);
//        populationCard = (CardView) findViewById(R.id.population_card);
//        schoolCard = (CardView) findViewById(R.id.school_card);
//        constructionCard = (CardView) findViewById(R.id.construction_card);
//
//        //click lis on cards
//        crimeCard.setOnClickListener(this);
//        populationCard.setOnClickListener(this);
//        schoolCard.setOnClickListener(this);
//        constructionCard.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        Intent i;
//
//        switch (v.getId()) {
//            case R.id.crime_card:
//                i = new Intent(StatsActivity.this, Crime.class);
//                startActivity(i);
//            case R.id.population_card:
//                i = new Intent(StatsActivity.this, Population.class);
//                startActivity(i);
//            case R.id.school_card:
//                i = new Intent(StatsActivity.this, School.class);
//                startActivity(i);
//            case R.id.construction_card:
//                i = new Intent(StatsActivity.this, Crime.class);
//                startActivity(i);
//
////        if(v.getId() == R.id.crime_card){
////            i = new Intent(this, Crime.class);
////            startActivity(i);
////        }
////
////        else if(v.getId() == R.id.population_card){
////            i = new Intent(this, Population.class);
////            startActivity(i);
////        }
////
////        else if(v.getId() == R.id.school_card){
////            i = new Intent(this, School.class);
////            startActivity(i);
////        }
////
////        else if (v.getId() == R.id.construction_card) {
////            i = new Intent(this, Construction.class);
////            startActivity(i);
////        }
////        else{
////            Toast.makeText(this, "jhfuiedkgfudekf", Toast.LENGTH_SHORT).show();
////        }
//
////
////
////
////            default:break;
//        }
//    }




