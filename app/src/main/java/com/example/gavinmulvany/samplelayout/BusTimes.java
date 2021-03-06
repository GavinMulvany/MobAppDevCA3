package com.example.gavinmulvany.samplelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
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

public class BusTimes extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;
    private String stopNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times);

        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);

        mQueue = Volley.newRequestQueue(this);

        final EditText editText = (EditText) findViewById(R.id.stopnum); //taking a users stop mun from the edit plan

        stopNum = "none";

        TextView textView = (TextView) findViewById(R.id.text_view_result);
        textView.setMovementMethod(new ScrollingMovementMethod());
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewResult.setText(""); //setting the text to blank for every search so it gets overwrited
                stopNum = editText.getText().toString(); //putting my stop num input to a string to place in my url
                jsonParse();
            }
        });
    }


    private void jsonParse() {

        String url = "https://data.smartdublin.ie/cgi-bin/rtpi/realtimebusinformation?stopid="+stopNum+"&format=json"; //dublin bus api

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject results = jsonArray.getJSONObject(i);

                                String duetime = results.getString("duetime"); //getting back a duetime
                                String route = results.getString("route"); //getting the route




                                mTextViewResult.append(getString(R.string.Bus_Number)+ " " +String.valueOf(route) + " " + getString(R.string.due_in) + " " +String.valueOf(duetime)+ " "+ getString(R.string.minutes) + " "  + "\n");
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