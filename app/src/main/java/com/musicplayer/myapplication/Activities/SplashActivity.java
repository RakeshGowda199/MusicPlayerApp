package com.musicplayer.myapplication.Activities;

import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.musicplayer.myapplication.MainActivity;
import com.musicplayer.myapplication.R;

public class SplashActivity extends AppCompatActivity {

    private ConstraintLayout cl_intro;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getColor(R.color.status_bar));
        setContentView(R.layout.activity_splash);



        cl_intro=findViewById(R.id.cl_intro);


        Animation bottomUp= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.bottomtotop);

        TextView sogaon=findViewById(R.id.tv_slogon);
        sogaon.setAnimation(bottomUp);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, IntroActivity.class));
            }
        },3500);


    }
}
