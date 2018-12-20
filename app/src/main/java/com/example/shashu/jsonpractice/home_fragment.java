package com.example.shashu.jsonpractice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class home_fragment extends Fragment {
    Button btnSearchCharacter;
    Button btnSearchComics;
    Button btnWatchTrailers;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_home_fragment, null);
        btnSearchCharacter=rootView.findViewById(R.id.btnCharactersSearchFragment);
        btnSearchCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_frame,new characters_fragment()).commit();
            }
        });
        btnSearchComics=rootView.findViewById(R.id.btnComicsSearchFragment);
        btnSearchComics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_frame,new comics_fragment()).commit();
            }
        });
        btnWatchTrailers=rootView.findViewById(R.id.btnTrailerFragment);
        btnWatchTrailers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_frame,new trailer_fragment()).commit();
            }
        });
        return rootView;
    }
}
