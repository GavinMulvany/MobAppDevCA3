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

public class Crime extends AppCompatActivity {

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

        String url = "https://api.myjson.com/bins/dmz70";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("statistics");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject statistics = jsonArray.getJSONObject(i);

                                int Murders_Assualts = statistics.getInt("Murders_Assualts");
                                int  Attempts_Murder_Assult= statistics.getInt("Attempts_Murder_Assult");
                                int Robbery = statistics.getInt("Robbery");
                                int  Burglary= statistics.getInt("Burglary");
                                int Theft = statistics.getInt("Theft");
                                int  Fraud= statistics.getInt("Fraud");
                                int Drug_Offences = statistics.getInt("Drug_Offences");
                                int  Weapons= statistics.getInt("Weapons");
                                int Damage_to_property = statistics.getInt("Damage_to_property");
                                int  Public_order= statistics.getInt("Public_order");
                                int Offences_against_gov = statistics.getInt("Offences_against_gov");





                                mTextViewResult.append("Number of Murders and Assaults : " +String.valueOf(Murders_Assualts)  + "\n" +
                                        "Attempted Murders and Assaults : " +String.valueOf(Attempts_Murder_Assult)  + "\n"  +
                                        "Number of Robberies: "+String.valueOf(Robbery)  + "\n"  +
                                        "Number of Burglaries: " +String.valueOf(Burglary) + "\n " +
                                        "Number of Thefts: " +String.valueOf(Theft) + "\n " +
                                        "Number of Fraud offences: " +String.valueOf(Fraud) + "\n " +
                                        "Number of Drug Offences: " +String.valueOf(Drug_Offences) + "\n " +
                                        "Number of Weapon crimes: " +String.valueOf(Weapons) + "\n " +
                                        "Damage to property offences: " +String.valueOf(Damage_to_property) + "\n " +
                                        "Number of Public order offences: " +String.valueOf(Public_order) + "\n " +
                                        "Number of Offences against the Government " +String.valueOf(Offences_against_gov) + "\n "

                                );
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

