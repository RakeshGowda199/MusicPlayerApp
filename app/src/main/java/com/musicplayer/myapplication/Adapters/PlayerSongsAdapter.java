package com.musicplayer.myapplication.Adapters;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.musicplayer.myapplication.Models.PlayerSongsModel;
import com.musicplayer.myapplication.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import io.paperdb.Paper;

import static com.musicplayer.myapplication.Fragments.HomePlayerFragment.home_POSITION;
import static com.musicplayer.myapplication.Fragments.HomePlayerFragment.mediaPlayer;
import static com.musicplayer.myapplication.Fragments.HomePlayerFragment.songsFavurites;

public class PlayerSongsAdapter extends RecyclerView.Adapter<PlayerSongsAdapter.ViewHolder> {


    private Context context;
    private ArrayList<PlayerSongsModel>playerSongsModels=new ArrayList<>();
    public static int POSITION_LIST =0;
    private SongListClicked songListClicked;

    public PlayerSongsAdapter(Context context, ArrayList<PlayerSongsModel> songs) {
        this.context=context;
        this.playerSongsModels=songs;
        //this.songListClicked= (SongListClicked) context;
    }

    public void setSongSelected(SongListClicked songSelected){
        this.songListClicked=songSelected;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.song_list_adpter,parent,false);
        return new ViewHolder(view,songListClicked);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        for (int i = 0; i < songsFavurites.size() ; i++) {
            if (songsFavurites.get(i).getID().equals(playerSongsModels.get(position).getID())){
                holder.star_button.setActivated(true);
                holder.star_button.setImageResource(R.drawable.heart_on);
                break;
            }
        }



        holder.tv_SongName.setText(playerSongsModels.get(position).getTITLE());
        holder.tv_SongTitle.setText(playerSongsModels.get(position).getARTIST());
        holder.an_play_btn.setVisibility(View.GONE);
        holder.iv_play_btn.setVisibility(View.VISIBLE);


        int dur = (int) Integer.parseInt(playerSongsModels.get(position).getDURATION());

        int hrs = (dur / 3600000);
        int mns = (dur / 60000) % 60000;
        int scs = dur % 60000 / 1000;

        String songTime = String.format("%02d:%02d",mns, scs);
        holder.tv_timer.setText(songTime);
        if (POSITION_LIST == position){
           //holder.iv_play_btn.setImageResource(R.drawable.ic_volume);
          /* holder.iv_play_btn.setVisibility(View.GONE);
           holder.an_play_btn.setVisibility(View.VISIBLE);
*/
            home_POSITION=POSITION_LIST;
          holder.tv_SongName.setTextColor(context.getColor(R.color.colorPrimaryDark));
          holder.tv_SongTitle.setTextColor(context.getColor(R.color.colorPrimaryDark));
            if (mediaPlayer.isPlaying() ){
                holder.iv_play_btn.setVisibility(View.GONE);
                holder.an_play_btn.setVisibility(View.VISIBLE);
                holder.an_play_btn.playAnimation();
            }else {
                holder.iv_play_btn.setVisibility(View.GONE);
                holder.an_play_btn.setVisibility(View.VISIBLE);
                holder.an_play_btn.pauseAnimation();
            }
        }else {
            holder.tv_SongName.setTextColor(context.getColor(R.color.black_text_color));
            holder.tv_SongTitle.setTextColor(context.getColor(R.color.black_text_color));
            holder.iv_play_btn.setImageResource(R.drawable.ic_play_arrow_24dp);
        }

      /*  holder.iv_play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                POSITION_LIST =position;
                songListClicked.SongSelcted(position);
                notifyDataSetChanged();
            }
        });*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                POSITION_LIST =position;
                songListClicked.SongSelcted(position);
                notifyDataSetChanged();
              /*  songListClicked.SongItemSelcted(position);
                notifyDataSetChanged();*/
            }
        });
        holder.star_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!holder.star_button.isActivated()){
                    holder.star_button.setActivated(true);
                    holder.star_button.setImageResource(R.drawable.heart_on);
                    songListClicked.SongFavuritesSelcted(playerSongsModels.get(position));
                    notifyItemChanged(position);
                }else {
                    holder.star_button.setActivated(false);
                    holder.star_button.setImageResource(R.drawable.heart_off);
                    songListClicked.SongunFavuritesSelcted(playerSongsModels.get(position));
                    notifyItemChanged(position);
                }
            }
           /* @Override
            public void liked(LikeButton likeButton) {

            }

            @Override
            public void unLiked(LikeButton likeButton) {
                songListClicked.SongunFavuritesSelcted(playerSongsModels.get(position));
                notifyDataSetChanged();
            }*/
        });



        byte[] images=getAblumArt(playerSongsModels.get(position).getDATA().toString());
        if (images != null){
            Glide.with(context)
                    .load(images)
                    .centerCrop()
                    .error(R.drawable.hiclipart_com)
                    .into(holder.iv_image_song);
        }else {
            Glide.with(context).load(R.drawable.hiclipart_com)
                    .centerCrop()
                    .error(R.drawable.hiclipart_com)
                    .into(holder.iv_image_song);
            // .load("data:image/jpeg;base64,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")

        }


    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return playerSongsModels.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_SongName,tv_SongTitle,tv_timer;
        private ImageView iv_play_btn;
        public  LottieAnimationView an_play_btn;
        private CircleImageView iv_image_song;
        private ImageView star_button;

        public ViewHolder(@NonNull View itemView, SongListClicked songListClicked) {
            super(itemView);

            star_button=itemView.findViewById(R.id.star_button);
            tv_timer=itemView.findViewById(R.id.tv_timer);
            tv_SongName=itemView.findViewById(R.id.tv_song_name);
            tv_SongTitle=itemView.findViewById(R.id.tv_song_subtitle);
            iv_play_btn=itemView.findViewById(R.id.iv_play_btn);
            an_play_btn=itemView.findViewById(R.id.an_play_btn);
            iv_image_song=itemView.findViewById(R.id.iv_image_song);



        }
    }

    public interface  SongListClicked{
        void SongSelcted(int mPositon);
        void SongFavuritesSelcted(PlayerSongsModel playerSongsModel);

        void SongunFavuritesSelcted(PlayerSongsModel playerSongsModel);
    }

    private byte[] getAblumArt(String uri) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(uri);
        byte[] image = retriever.getEmbeddedPicture();
        retriever.release();
        return image;
    }


}
