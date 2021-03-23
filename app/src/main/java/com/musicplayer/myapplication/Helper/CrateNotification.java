package com.musicplayer.myapplication.Helper;

import android.app.Notification;
import android.content.Context;

import androidx.core.app.NotificationManagerCompat;
import androidx.media.app.NotificationCompat;

import com.musicplayer.myapplication.Models.PlayerSongsModel;

public class CrateNotification {

    public static String CHANNEL_ID="channel";
    public static String ACTION_PREVIOUS="actionprevice";
    public static String CHANNEL_PLAY="actionplay";
    public static String CHANNEL_NEXT="actionnext";



    public static Notification notification;

    public static void createNotification(Context context, PlayerSongsModel playerSongsModel ,int playerbutton,int pos,int size){

        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(context);

    }
}
