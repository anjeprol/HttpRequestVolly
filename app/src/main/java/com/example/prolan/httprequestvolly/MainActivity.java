package com.example.prolan.httprequestvolly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
Data getData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendRQ(final TextView textView){
        String url = "http://itunes.apple.com/search?term=rock";

// Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling
                        //System.out.println(response.toString());
                        Data fillData = new Data(response.toString());
                        getData = fillData;
                       // textView.setText(response.toString());
                        //Log.d("AJPO",response.substring(0,100));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            }
        });

// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void onGo(View view) {
        TextView tV = (TextView)findViewById(R.id.tV);
        RecyclerView rV = (RecyclerView) findViewById(R.id.rV);
        rV.setHasFixedSize(true);
        LinearLayoutManager lLM = new LinearLayoutManager(this);
        rV.setLayoutManager(lLM);
        this.sendRQ(tV);
        if(getData!=null) {
            RVAdapter adapter = new RVAdapter(getData.initializeData(getData));
            rV.setAdapter(adapter);
        }

    }
}
