package com.example.shashu.jsonpractice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class trailer_fragment extends Fragment {
    List<Trailer_Characters> trailers_list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_trailer_fragment, null);
        trailers_list=new ArrayList<>();
        trailers_list.add(new Trailer_Characters("Iron-Man",R.drawable.iron_man));
        trailers_list.add(new Trailer_Characters("The Incredible Hulk",R.drawable.the_incredible_hulk));
        trailers_list.add(new Trailer_Characters("Iron-Man 2",R.drawable.iron_man_2));
        trailers_list.add(new Trailer_Characters("Thor(2011)",R.drawable.thor));
        trailers_list.add(new Trailer_Characters("Captain-America:The First Avenger",R.drawable.captain_america_the_first_avenger));
        trailers_list.add(new Trailer_Characters("Marvel's The Avengers",R.drawable.the_avengers));
        trailers_list.add(new Trailer_Characters("Iron-Man 3",R.drawable.iron_man_2));
        trailers_list.add(new Trailer_Characters("Thor:The Dark World",R.drawable.thor_the_dark_world));
        trailers_list.add(new Trailer_Characters("Captain-America:Winter Soldier",R.drawable.captain_america_winter_soldier));
        trailers_list.add(new Trailer_Characters("Guardians of the Galaxy(2014)",R.drawable.guardians_of_the_galaxy));
        trailers_list.add(new Trailer_Characters("Avengers:Age of Ultron",R.drawable.avengers_age_of_ultron));
        trailers_list.add(new Trailer_Characters("Ant-Man(2015)",R.drawable.ant_man));
        trailers_list.add(new Trailer_Characters("Captain-America:Civil War",R.drawable.captain_america_civil_war));
        trailers_list.add(new Trailer_Characters("Doctor-Strange",R.drawable.doctor_strange));
        trailers_list.add(new Trailer_Characters("Guardians of the Galaxy Vol. 2",R.drawable.guardians_of_the_galaxy_2));
        trailers_list.add(new Trailer_Characters("Spider-Man: Homecoming",R.drawable.spiderman_homecoming));
        trailers_list.add(new Trailer_Characters("Thor:Ragnarok",R.drawable.thor_ragnarok_alt));
        trailers_list.add(new Trailer_Characters("Black Panther",R.drawable.black_panther));
        trailers_list.add(new Trailer_Characters("Avengers: Infinity War",R.drawable.avengers_infinity_war));
        RecyclerView mRecyclerView=rootView.findViewById(R.id.trailer_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new Adapter_Trailers(getActivity(),trailers_list));
        return rootView;
    }
}
