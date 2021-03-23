package com.musicplayer.myapplication.Fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.musicplayer.myapplication.MainActivity;
import com.musicplayer.myapplication.R;
import com.rtugeek.android.colorseekbar.ColorSeekBar;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddAveitorFragment extends DialogFragment {


    private ImageView circleImageView;
    private ImageView iv_smiley,iv_image2,iv_image3,iv_image4,iv_image5,iv_image6,iv_image7,iv_image8,iv_image9,iv_image10;
    private boolean isSetColor = false;
    public AddAveitorFragment() {
        // Required empty public constructor
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        if (dialog.getWindow() != null) {
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(true);

            // Add back button listener
            dialog.setOnKeyListener(new Dialog.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialogInterface, int keyCode, KeyEvent keyEvent) {
                    // getAction to make sure this doesn't double fire
                    if (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.getAction() == KeyEvent.ACTION_UP) {
                        // Your code here
                        return false; // Capture onKey
                    }
                    return false; // Don't capture
                }
            });
        }
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(true);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_aveitor, container, false);

        iv_smiley=view.findViewById(R.id.iv_smiley);
        iv_image2=view.findViewById(R.id.iv_image2);
        iv_image3=view.findViewById(R.id.iv_image3);
        iv_image4=view.findViewById(R.id.iv_image4);
        iv_image5=view.findViewById(R.id.iv_image5);
        iv_image6=view.findViewById(R.id.iv_image6);
        iv_image7=view.findViewById(R.id.iv_image7);
        iv_image8=view.findViewById(R.id.iv_image8);
        iv_image9=view.findViewById(R.id.iv_image9);
        iv_image10=view.findViewById(R.id.iv_image10);
        circleImageView=view.findViewById(R.id.circleImageView);
        Button btn_save_avatar=view.findViewById(R.id.btn_save_avatar);
        btn_save_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        final ColorSeekBar mColorSeekBar = view.findViewById(R.id.colorSlider);
        mColorSeekBar.setColor(Color.parseColor("#223BC8" ));

        // mColorSeekBar.setOnColorChangeListener(onColorChangeListener);
        mColorSeekBar.setOnColorChangeListener(new ColorSeekBar.OnColorChangeListener() {
            @Override
            public void onColorChangeListener(int colorBarPosition, int alphaBarPosition, int color) {
                LayerDrawable layerDrawable = (LayerDrawable) circleImageView.getBackground();
                //GradientDrawable circle = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.bg_circle);
                if (isSetColor) {
                   // circle.setColor(color);
                } else {
                    isSetColor = true;
                }
            }
        });

        iv_smiley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!iv_smiley.isActivated()){
                    iv_smiley.setActivated(true);
                    iv_image2.setActivated(false);
                    iv_image3.setActivated(false);
                    iv_image4.setActivated(false);
                    iv_image5.setActivated(false);
                    iv_image6.setActivated(false);
                    iv_image7.setActivated(false);
                    iv_image8.setActivated(false);
                    iv_image9.setActivated(false);
                    iv_image10.setActivated(false);

                    iv_smiley.setImageResource(R.drawable.happyicon);
                    circleImageView.setImageResource(R.drawable.happyicon);
                    iv_smiley.setActivated(true);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        iv_smiley.setBackground(getActivity().getDrawable(R.color.secondary_color));
                    }
                }else{
                    iv_smiley.setActivated(false);
                    iv_smiley.setImageResource(R.drawable.happyicon);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        iv_smiley.setBackground(getActivity().getDrawable(R.color.color_white));
                    }
                }
            }
        });



        iv_image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!iv_image2.isActivated()){
                    iv_smiley.setActivated(false);
                    iv_image2.setActivated(true);
                    iv_image3.setActivated(false);
                    iv_image4.setActivated(false);
                    iv_image5.setActivated(false);
                    iv_image6.setActivated(false);
                    iv_image7.setActivated(false);
                    iv_image8.setActivated(false);
                    iv_image9.setActivated(false);
                    iv_image10.setActivated(false);

                    iv_image2.setImageResource(R.drawable.horseshoeicon);
                    circleImageView.setImageResource(R.drawable.horseshoeicon);
                    iv_image2.setActivated(true);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        iv_image2.setBackground(getActivity().getDrawable(R.color.secondary_color));
                    }
                }else{
                    iv_image2.setActivated(false);
                    iv_image2.setImageResource(R.drawable.horseshoeicon);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        iv_image2.setBackground(getActivity().getDrawable(R.color.color_white));
                    }
                }
            }
        });

        iv_image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!iv_image3.isActivated()){
                    iv_smiley.setActivated(false);
                    iv_image2.setActivated(false);
                    iv_image3.setActivated(true);
                    iv_image4.setActivated(false);
                    iv_image5.setActivated(false);
                    iv_image6.setActivated(false);
                    iv_image7.setActivated(false);
                    iv_image8.setActivated(false);
                    iv_image9.setActivated(false);
                    iv_image10.setActivated(false);

                    iv_image3.setImageResource(R.drawable.maleicon);
                    circleImageView.setImageResource(R.drawable.maleicon);
                    iv_image3.setActivated(true);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        iv_image2.setBackground(getActivity().getDrawable(R.color.secondary_color));
                    }
                }else{
                    iv_image3.setActivated(false);
                    iv_image3.setImageResource(R.drawable.maleicon);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        iv_image3.setBackground(getActivity().getDrawable(R.color.color_white));
                    }
                }
            }
        });
        iv_image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!iv_image4.isActivated()){
                    iv_smiley.setActivated(false);
                    iv_image2.setActivated(false);
                    iv_image3.setActivated(false);
                    iv_image4.setActivated(true);
                    iv_image5.setActivated(false);
                    iv_image6.setActivated(false);
                    iv_image7.setActivated(false);
                    iv_image8.setActivated(false);
                    iv_image9.setActivated(false);
                    iv_image10.setActivated(false);

                    iv_image4.setImageResource(R.drawable.specialoccasionsicon);
                    circleImageView.setImageResource(R.drawable.specialoccasionsicon);
                    iv_image4.setActivated(true);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        iv_image4.setBackground(getActivity().getDrawable(R.color.secondary_color));
                    }
                }else{
                    iv_image4.setActivated(false);
                    iv_image4.setImageResource(R.drawable.specialoccasionsicon);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        iv_image4.setBackground(getActivity().getDrawable(R.color.color_white));
                    }
                }
            }
        });

        iv_image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!iv_image5.isActivated()){
                    iv_smiley.setActivated(false);
                    iv_image2.setActivated(false);
                    iv_image3.setActivated(false);
                    iv_image4.setActivated(false);
                    iv_image5.setActivated(true);
                    iv_image6.setActivated(false);
                    iv_image7.setActivated(false);
                    iv_image8.setActivated(false);
                    iv_image9.setActivated(false);
                    iv_image10.setActivated(false);

                    iv_image5.setImageResource(R.drawable.crownicon);
                    circleImageView.setImageResource(R.drawable.crownicon);
                    iv_image5.setActivated(true);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        iv_image5.setBackground(getActivity().getDrawable(R.color.secondary_color));
                    }
                }else{
                    iv_image5.setActivated(false);
                    iv_image5.setImageResource(R.drawable.crownicon);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        iv_image5.setBackground(getActivity().getDrawable(R.color.color_white));
                    }
                }
            }
        });

        return view;
    }
}