package com.example.shashu.jsonpractice;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


public class characters_fragment extends Fragment {

    private String privateKey = "aa2d591e334216929c7327f1d67fbb54ef3764dd";
    private String publicKey = "786adba4e64313dcd2028940b28c2e34";
    long timestamp;
    private static String URL = "";
    String hashed;
     private EditText txtCharacter;
    Context context;
    private Button btnSearch;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context=getContext();
        final View rootView = inflater.inflate(R.layout.fragment_characters_fragment, null);
        txtCharacter = (EditText)rootView.findViewById(R.id.txtCharacter);
        btnSearch = rootView.findViewById(R.id.btnSearch);
        String ts;
        timestamp = System.currentTimeMillis();
        ts = String.valueOf(timestamp);
        try {
            hashed = convertToHash(ts);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // int limit = 5;
        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(txtCharacter.getWindowToken(), 0);
                //txtCharacter.onEditorAction(EditorInfo.IME_ACTION_DONE);
                String searchedName = txtCharacter.getText().toString();
                Log.v("EditText",searchedName);
             System.out.print(searchedName);
                final RecyclerView userList = rootView.findViewById(R.id.character_recycler);
                userList.setLayoutManager(new LinearLayoutManager(getActivity()));
                URL = String.format("https://gateway.marvel.com:443/v1/public/characters?ts=%d&apikey=%s&hash=%s&nameStartsWith=%s&limit=100", timestamp, publicKey, hashed ,searchedName);
                Log.v("URL",URL);
                // URL = String.format("https://gateway.marvel.com:443/v1/public/characters/1009268?ts=%d&apikey=%s&hash=%s", timestamp, publicKey, hashed);
                StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("CODE", response);

                        GsonBuilder gsonB = new GsonBuilder();
                        Gson gs = gsonB.create();
                        Character item = gs.fromJson(response, Character.class);
                        Data marvelData = item.getData();
                        List<Result> users = marvelData.getResults();
                        //  List<Result>user=users.getResults();
                        userList.setAdapter(new GitHubAdapter(getActivity(), users));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "SomeThing went Wrong!!", Toast.LENGTH_SHORT).show();
                    }
                });
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(request);

            }
        });
        return rootView;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String convertToHash(String timeStamp) throws NoSuchAlgorithmException {
        String toBeHashed = timeStamp + privateKey + publicKey;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(toBeHashed.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }


}
