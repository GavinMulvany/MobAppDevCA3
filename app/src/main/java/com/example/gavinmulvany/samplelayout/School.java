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

public class School extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_stats);

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

                                mTextViewResult.append(getString(R.string.SchoolName)+" " +SchoolName + "\n" + getString(R.string.Address)+" " +Address + "\n"  + getString(R.string.SchoolLevel)+" "+SchoolLevel + "\n"  + getString(R.string.NumberOfMales)+" " +String.valueOf(NumberOfMales) + "\n" +  getString(R.string.NumberOfFemales)+" " +String.valueOf(NumberOfFemales) + "\n\n");
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
