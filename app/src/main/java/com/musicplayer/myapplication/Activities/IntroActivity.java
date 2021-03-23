package com.musicplayer.myapplication.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.musicplayer.myapplication.Adapters.IntroAdpter;
import com.musicplayer.myapplication.Fragments.AddAveitorFragment;
import com.musicplayer.myapplication.MainActivity;
import com.musicplayer.myapplication.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class IntroActivity extends AppCompatActivity {

    private ViewPager vp_intro;
    private IntroAdpter introAdpter;
    private LinearLayout mDotsLayout;
    private ImageView[] mDots;
    private int dotscount;
    int page_position = 0;
    Timer timer;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar));
        setContentView(R.layout.activity_intro);

        initView();

        vp_intro = findViewById(R.id.vp_intro);

        introAdpter = new IntroAdpter(IntroActivity.this, AnimationDataBackground(), AnimationData(), createTitleList(), createSubTitleList());
        vp_intro.setAdapter(introAdpter);
        introAdpter.nextlistener(new IntroAdpter.nextClicked() {
            @Override
            public void nextIntro(int position) {
                vp_intro.setCurrentItem(position + 1, true);
            }

            @Override
            public void continuenext(int position) {
                //loadFragment(new AddAveitorFragment());
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
               /* FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                Fragment prev = getSupportFragmentManager().findFragmentByTag("avatar");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                AddAveitorFragment addAveitorFragment = new AddAveitorFragment();
                addAveitorFragment.show(ft, "avatar");*/
            }
        });
        dotscount = introAdpter.getCount();
        mDots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            mDots[i] = new ImageView(this);
            mDots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            mDotsLayout.addView(mDots[i], params);

        }

        mDots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        vp_intro.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    mDots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                mDots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        scheduleSlider();


    }

    private void initView() {
        mDotsLayout = findViewById(R.id.ll_dotsLayout);
    }

    private ArrayList<Integer> AnimationData() {
        ArrayList<Integer> rawFile = new ArrayList<>();
        rawFile.add(R.raw.listnman);
        rawFile.add(R.raw.listwomen);
        rawFile.add(R.raw.listcarton);
        rawFile.add(R.raw.listcart2);
        return rawFile;
    }

    private ArrayList<Integer> AnimationDataBackground() {
        ArrayList<Integer> rawFile = new ArrayList<>();
        rawFile.add(R.drawable.background_intro_blue);
        rawFile.add(R.drawable.intro_bg_varient);
        rawFile.add(R.drawable.blur);
        rawFile.add(R.drawable.intro_bg_purple);
        return rawFile;
    }

    public void scheduleSlider() {

        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == dotscount) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                vp_intro.setCurrentItem(page_position, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 5000, 5000);

        vp_intro.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                timer.cancel();
                return false;
            }
        });
    }


    private ArrayList<String> createTitleList() {
        ArrayList<String> mTitles = new ArrayList<>();
        mTitles.add("Music With Health");
        mTitles.add("Music With Work");
        mTitles.add("Music With Buddyes");
        mTitles.add("Music With Buddyes");
        return mTitles;
    }

    private ArrayList<String> createSubTitleList() {
        ArrayList<String> mTitles = new ArrayList<>();
        mTitles.add("Music With Health Music With Health Music With Health Music With Health");
        mTitles.add("Music With Work Music With Work Music With Work Music With Work Music With Work");
        mTitles.add("Music With Buddye sMusic With Buddyes Music With Buddye Music With Buddyes Music With Buddyes");
        mTitles.add("Music With Buddye sMusic With Buddyes Music With Buddye Music With Buddyes Music With Buddyes");
        return mTitles;
    }


    //To load particular fragment
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cl_intro_parent, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }
}