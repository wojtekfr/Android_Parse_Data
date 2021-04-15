package com.example.parse_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
 //
    RequestQueue queue;
    String url = "https://www.google.com";
    String apiUrl = "https://jsonplaceholder.typicode.com/todos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,apiUrl,null,
                response -> {
                    Log.d("JSON", "onCreate: " + response.toString());
        }, error -> {
            Log.d("JSON", "error");
        });

        queue.add(jsonArrayRequest);
        getString(queue);
    }

    private void getString(RequestQueue queue) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {
            Log.d("Main", "xxx" + response.substring(0,500));
        }, error -> {
            Log.d("Main", "fail");
        });

        queue.add(stringRequest);
    }
}