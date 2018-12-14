package com.example.shashu.jsonpractice;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private String privateKey = "aa2d591e334216929c7327f1d67fbb54ef3764dd";
//    private String publicKey = "786adba4e64313dcd2028940b28c2e34";
//    long timestamp;
//    private static String URL = "";
//    String hashed;
//
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        String ts;
//        timestamp = System.currentTimeMillis();
//        ts = String.valueOf(timestamp);
//        try {
//            hashed = convertToHash(ts);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//       // int limit = 5;
//
//        final RecyclerView userList = findViewById(R.id.userList);
//        userList.setLayoutManager(new LinearLayoutManager(this));
//        URL=String.format("https://gateway.marvel.com:443/v1/public/characters?ts=%d&apikey=%s&hash=%s", timestamp, publicKey, hashed);
//      // URL = String.format("https://gateway.marvel.com:443/v1/public/characters/1009268?ts=%d&apikey=%s&hash=%s", timestamp, publicKey, hashed);
//        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                Log.d("CODE", response);
//
//                GsonBuilder gsonB = new GsonBuilder();
//                Gson gs = gsonB.create();
//               Hulk item= gs.fromJson(response,Hulk.class);
//Data marvelData=item.getData();
//List<Result> users=marvelData.getResults();
//              //  List<Result>user=users.getResults();
//                userList.setAdapter(new CharactersAdapter(MainActivity.this, users));
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this, "SomeThing went Wrong!!", Toast.LENGTH_SHORT).show();
//            }
//        });
//        RequestQueue queue = Volley.newRequestQueue(this);
//        queue.add(request);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    public String convertToHash(String timeStamp) throws NoSuchAlgorithmException {
//        String toBeHashed = timeStamp + privateKey + publicKey;
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        byte[] hashInBytes = md.digest(toBeHashed.getBytes(StandardCharsets.UTF_8));
//
//        StringBuilder sb = new StringBuilder();
//        for (byte b : hashInBytes) {
//            sb.append(String.format("%02x", b));
//        }
//        System.out.println(sb.toString());
//        return sb.toString();
//    }
//protected void onCreate(Bundle savedInstanceState) {
//      super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        RecyclerView r=findViewById(R.id.userList);
//        Biography bio=new Biography();
//        Intent i=getIntent();
//        bio.setName(i.getExtras().getString("name"));
//        bio.setDescription(i.getExtras().getString("description"));
//        bio.setTrailer_thumbnail(i.getExtras().getString("thumbnail"));
//        r.setLayoutManager(new LinearLayoutManager(this));
//        r.setAdapter(new adapter_character_bio(MainActivity.this,bio));
//}
}



