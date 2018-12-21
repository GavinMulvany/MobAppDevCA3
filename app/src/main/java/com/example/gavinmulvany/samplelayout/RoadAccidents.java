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

public class RoadAccidents extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roadaccidents);

        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);

        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewResult.setText("");
                jsonParse();
            }
        });

        TextView textView = (TextView) findViewById(R.id.text_view_result);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    private void jsonParse() {

        String url = "https://api.myjson.com/bins/1etqhk";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("statistics");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject statistics = jsonArray.getJSONObject(i);

                                int Airport = statistics.getInt("Airport");
                                int SWORDS_GLASMORE = statistics.getInt("SWORDS_GLASMORE");
                                int SWORDS_FORREST = statistics.getInt("SWORDS_FORREST");
                                int SWORDS_LISSENHALL = statistics.getInt("SWORDS_LISSENHALL");
                                int SWORDS_SEATOWN = statistics.getInt("SWORDS_SEATOWN");
                                int SWORDS_VILLAGE = statistics.getInt("SWORDS_VILLAGE");
                                int THE_WARD = statistics.getInt("THE_WARD");


                                mTextViewResult.append(getString(R.string.Airport)+" " +String.valueOf(Airport) + "\n"
                                        + getString(R.string.Glasmore)+" " +String.valueOf(SWORDS_GLASMORE) + "\n"
                                        + getString(R.string.Forrest)+" "+String.valueOf(SWORDS_FORREST) + "\n"
                                        + getString(R.string.Lissenhall)+" " +String.valueOf(SWORDS_LISSENHALL) + "\n"
                                        + getString(R.string.Seatown)+" " +String.valueOf(SWORDS_SEATOWN) + "\n"
                                        + getString(R.string.Village)+" " +String.valueOf(SWORDS_VILLAGE) + "\n"
                                        + getString(R.string.TheWard)+" " +String.valueOf(THE_WARD) + "\n\n");
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

