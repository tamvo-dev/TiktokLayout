package com.example.tiktoklayout.home;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tiktoklayout.R;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.io.File;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {

    private Context context;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewpager, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull MyViewHolder holder) {
        super.onViewAttachedToWindow(holder);

        holder.player.setPlayWhenReady(true);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);

        holder.player.setPlayWhenReady(false);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindView(context);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        SimpleExoPlayer player;

        public MyViewHolder(View itemView){
            super(itemView);
        }

        public void bindView(Context context){

            PlayerView playerView = itemView.findViewById(R.id.item_videoplayer);

            DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();

            TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
            TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);

            player = ExoPlayerFactory.newSimpleInstance(context, trackSelector);
            playerView.setUseController(false);
            playerView.requestFocus();
            playerView.setPlayer(player);

            Uri mp4VideoUri =Uri.parse("http://cbsnewshd-lh.akamaihd.net/i/CBSNHD_7@199302/index_700_av-p.m3u8");
            DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(context, Util.getUserAgent(context, "tiktoklayout"), bandwidthMeter);
            MediaSource mediaSource = new HlsMediaSource(mp4VideoUri, dataSourceFactory, 1, null, null);

            player.prepare(mediaSource);
        }

    }

}
