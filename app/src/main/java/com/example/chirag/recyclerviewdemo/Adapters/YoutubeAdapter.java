package com.example.chirag.recyclerviewdemo.Adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chirag.recyclerviewdemo.Model.Youtube;
import com.example.chirag.recyclerviewdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by chirag on 08-Apr-17.
 */

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.YoutubeViewHolder> {
    private Context context;
    private ArrayList<Youtube> youtubeArrayList = new ArrayList<>();

    public YoutubeAdapter(Context context, ArrayList<Youtube> youtubeArrayList) {
        this.context = context;
        this.youtubeArrayList = youtubeArrayList;
    }

    @Override
    public YoutubeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_youtube, parent, false);

        return new YoutubeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(YoutubeViewHolder holder, int position) {
        Youtube youtube = youtubeArrayList.get(position);
        holder.tvTitle.setText(youtube.getYoutubeTitle());
        holder.tvYoutubeOwner.setText(youtube.getYoutubeOwner());
        holder.tvTime.setText(youtube.getTime());
        holder.tvYoutubeStream.setText(youtube.getYoutubeStream());
        Picasso.with(context).load(youtube.getProfileUrl()).into(holder.ivProfile);
        Picasso.with(context).load(youtube.getYoutubeUrl()).into(holder.ivYoutube);

    }

    @Override
    public int getItemCount() {
        return youtubeArrayList.size();
    }

    static class YoutubeViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView ivProfile;
        private AppCompatImageView ivYoutube;
        private AppCompatTextView tvTitle, tvTime, tvYoutubeOwner, tvYoutubeStream;

        public YoutubeViewHolder(View itemView) {
            super(itemView);
            ivProfile = (AppCompatImageView) itemView.findViewById(R.id.iv_youtube_profile);
            ivYoutube = (AppCompatImageView) itemView.findViewById(R.id.iv_youtube_video);
            tvTitle = (AppCompatTextView) itemView.findViewById(R.id.tv_youtube_title);
            tvTime = (AppCompatTextView) itemView.findViewById(R.id.tv_youtube_time);
            tvYoutubeOwner = (AppCompatTextView) itemView.findViewById(R.id.tv_youtube_owner);
            tvYoutubeStream = (AppCompatTextView) itemView.findViewById(R.id.tv_youtube_stream);
        }
    }
}