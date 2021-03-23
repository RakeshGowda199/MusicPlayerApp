package com.musicplayer.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.LottieAnimationView;
import com.musicplayer.myapplication.MainActivity;
import com.musicplayer.myapplication.R;

import java.util.ArrayList;

public class IntroAdpter extends PagerAdapter {
    private Context context;
    private ArrayList<Integer> animationImages;
    private ArrayList<Integer> animationBackground;
    private ArrayList<String>mIntroTitels;
    private ArrayList<String>mIntroSubTitels;
    private nextClicked nextClicked;
    public IntroAdpter(Context context, ArrayList<Integer>baground,ArrayList<Integer>DynamicFragment,ArrayList<String>mIntroTitels,ArrayList<String>mIntroSubTitels) {
        this.animationImages =DynamicFragment;
        this.animationBackground=baground;
        this.context=context;
        this.mIntroTitels=mIntroTitels;
        this.mIntroSubTitels=mIntroSubTitels;
    }

    public void nextlistener(nextClicked nextClicked){
        this.nextClicked=nextClicked;
    }
    @Override
    public int getCount() {
        return animationImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        View introView = LayoutInflater.from(context).inflate(R.layout.intro_item, container, false);

        ConstraintLayout cl_parent=introView.findViewById(R.id.cl_parent);
       LottieAnimationView an_intro_view=introView.findViewById(R.id.an_intro_view);
       TextView tv_intro_title=introView.findViewById(R.id.tv_intro_title);
       TextView tv_intro_subtitle=introView.findViewById(R.id.tv_intro_subtitle);
       TextView tv_skip=introView.findViewById(R.id.tv_skip);
        LottieAnimationView tv_next=introView.findViewById(R.id.tv_next);
       Button btn_intro_continue=introView.findViewById(R.id.btn_intro_continue);
       an_intro_view.setAnimation(animationImages.get(position));
       if (position == animationImages.size()-1){
           btn_intro_continue.setVisibility(View.VISIBLE);
           tv_skip.setVisibility(View.GONE);
           tv_next.setAnimation(R.raw.finsh);
       }else {
           btn_intro_continue.setVisibility(View.INVISIBLE);
           tv_skip.setVisibility(View.VISIBLE);
           tv_next.setVisibility(View.VISIBLE);
           tv_next.setAnimation(R.raw.nextintro);
       }
       tv_intro_title.setText(mIntroTitels.get(position));
        tv_intro_subtitle.setText(mIntroSubTitels.get(position));

        cl_parent.setBackgroundResource(animationBackground.get(position));

        btn_intro_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextClicked.continuenext(0);
               // context.startActivity(new Intent(context, MainActivity.class));
            }
        });
        tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               nextClicked.nextIntro(position);
            }
        });
        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextClicked.continuenext(0);
                //context.startActivity(new Intent(context, MainActivity.class));
            }
        });

        container.addView(introView);
        return introView;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public interface nextClicked{
        void nextIntro(int position);
        void continuenext(int position);
    }

}
