package com.musicplayer.myapplication.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.musicplayer.myapplication.Models.PlayerSongsModel;
import com.musicplayer.myapplication.R;
import com.musicplayer.myapplication.ViewModel.PlayerViewModel;

import info.abdolahi.CircularMusicProgressBar;
import info.abdolahi.OnCircularSeekBarChangeListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerFragment extends Fragment {

    public PlayerFragment() {
        // Required empty public constructor
    }

    private PlayerViewModel model;

    CircularMusicProgressBar  circularMusicProgressBar;
    private PlayerSongsModel playerSongsModel;
    private TextView tv_song_title;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_player,container,false);


      /*  model=new ViewModelProvider(getActivity()).get(PlayerViewModel.class);
        if (getArguments() != null){
            Bundle bundle=getArguments();
         //  playerSongsModel= model.getingTheSongPostionData(bundle);

            Toast.makeText(getActivity(), ""+playerSongsModel.getDISPLAY_NAME(), Toast.LENGTH_SHORT).show();

        }




       // circularMusicProgressBar=view.findViewById(R.id.album_art);
        circularMusicProgressBar.setBorderColor(getResources().getColor(R.color.color_white));
        circularMusicProgressBar.setBorderWidth(2);
        circularMusicProgressBar.setProgressAnimationState(true);
        circularMusicProgressBar.setOnCircularBarChangeListener(new OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularMusicProgressBar circularBar, int progress, boolean fromUser) {

                Toast.makeText(getActivity(), "Cilick"+progress, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onClick(CircularMusicProgressBar circularBar) {

                Toast.makeText(getActivity(), "Cilick", Toast.LENGTH_SHORT).show();
                *//*DialogEqualizerFragment fragment = DialogEqualizerFragment.newBuilder()
                        .setAudioSessionId(sessionId)
                        .themeColor(ContextCompat.getColor(this, R.color.primaryColor))
                        .textColor(ContextCompat.getColor(this, R.color.textColor))
                        .accentAlpha(ContextCompat.getColor(this, R.color.playingCardColor))
                        .darkColor(ContextCompat.getColor(this, R.color.primaryDarkColor))
                        .setAccentColor(ContextCompat.getColor(this, R.color.secondaryColor))
                        .build();
                fragment.show(getActivity().getSupportFragmentManager(), "eq");
*//*
                }

            @Override
            public void onLongPress(CircularMusicProgressBar circularBar) {

            }
        });*/







    return view;
    }





}
