package com.example.livestreaming;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>{
    private final List<String> uri = new ArrayList<>();
    public ViewPagerAdapter(){
        uri.add("android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.vertical_1);
        uri.add("android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.horizontal_1);
        uri.add("android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.vertical_2);
        uri.add("android.resource://" + MainActivity.PACKAGE_NAME + "/" + R.raw.horizontal_2);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerAdapter.ViewHolder holder, int position) {
        holder.videoView.setVideoURI(Uri.parse(uri.get(position)));
        holder.videoView.requestFocus();
        holder.videoView.start();
    }

    @Override
    public int getItemCount() {
        return uri.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        VideoView videoView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.video_view);
        }
    }
}

