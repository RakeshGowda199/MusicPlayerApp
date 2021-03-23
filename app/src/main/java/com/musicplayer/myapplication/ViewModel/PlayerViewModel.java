package com.musicplayer.myapplication.ViewModel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.musicplayer.myapplication.Activities.PlayerActivity;
import com.musicplayer.myapplication.Models.PlayerSongsModel;

import java.util.ArrayList;

import static com.musicplayer.myapplication.Fragments.HomePlayerFragment.songs;

public class PlayerViewModel extends ViewModel {


    private MutableLiveData<PlayerSongsModel>modelMutableLiveData=new MutableLiveData<>();
    public MutableLiveData<PlayerSongsModel>  getingTheSongPostionData(Activity Activity){

        PlayerSongsModel playerSongsModel = null;
        if (Activity.getIntent().hasExtra("SongList") ){
            int position= (Activity.getIntent().getIntExtra("SongList",0));

             playerSongsModel= (PlayerSongsModel) songs.get((position));
             modelMutableLiveData.postValue(playerSongsModel);
        }



        return modelMutableLiveData;
    }
}
