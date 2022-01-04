package com.example.livestreaming;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>{
    private final List<String> uri = new ArrayList<>();
    public ListView commentListView;

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
        holder.thumbUp.setOnClickListener(view -> {
            switch (ThumbView.thumbStyle){
                case 0:
                    holder.thumbUp.setImageResource(R.drawable.thumb_anim);
                    ThumbView.thumbStyle = 1;
                    break;
                case 1:
                    holder.thumbUp.setImageResource(R.drawable.thumb);
                    ThumbView.thumbStyle = 0;
                    break;
                default:
            }
        });
        commentListView = holder.commentListView;
        commentListView.setDivider(null);
        List<Comment> commentList;
        CommentAdapter commentAdapter;
        switch (position){
            case 0:
                commentList = initVertical_1();
                commentAdapter = new CommentAdapter(commentListView.getContext(), R.layout.comment_item, commentList);
                break;
            case 1:
                commentList = initHorizontal_1();
                commentAdapter = new CommentAdapter(commentListView.getContext(), R.layout.comment_item, commentList);
                break;
            case 2:
                commentList = initVertical_2();
                commentAdapter = new CommentAdapter(commentListView.getContext(), R.layout.comment_item, commentList);
                break;
            default:
                commentList = initHorizontal_2();
                commentAdapter = new CommentAdapter(commentListView.getContext(), R.layout.comment_item, commentList);
        }
        commentListView.setAdapter(commentAdapter);
        holder.send.setOnClickListener(view -> {
            String commentText = holder.commentText.getText().toString();
            if(!commentText.equals("")) {
                commentList.add(new Comment(commentText));
                holder.commentText.setText("");
                holder.commentText.clearFocus();
            }
        });
    }

    @Override
    public int getItemCount() {
        return uri.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        VideoView videoView;
        ImageButton thumbUp;
        ImageButton gift;
        ImageButton send;
        ListView commentListView;
        TextInputEditText commentText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.video_view);
            thumbUp = itemView.findViewById(R.id.thumb_up);
            gift = itemView.findViewById(R.id.gift);
            commentListView = itemView.findViewById(R.id.comment_list_view);
            send = itemView.findViewById(R.id.send);
            commentText = itemView.findViewById(R.id.comment_text);
        }
    }
    public List<Comment> initVertical_1(){
        List<Comment> ver_1 = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            Comment comment1 = new Comment("球技真好！");
            ver_1.add(comment1);
            Comment comment2 = new Comment("真棒！");
            ver_1.add(comment2);
            Comment comment3 = new Comment("我也想要练足球！");
            ver_1.add(comment3);
        }
        return ver_1;
    }
    public List<Comment> initHorizontal_1(){
        List<Comment> hor_1 = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            Comment comment1 = new Comment("技术真好！");
            hor_1.add(comment1);
            Comment comment2 = new Comment("真好玩！");
            hor_1.add(comment2);
            Comment comment3 = new Comment("我也想要练冲浪！");
            hor_1.add(comment3);
        }
        return hor_1;
    }
    public List<Comment> initVertical_2(){
        List<Comment> ver_2 = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            Comment comment1 = new Comment("风景真好！");
            ver_2.add(comment1);
            Comment comment2 = new Comment("我也想去看！");
            ver_2.add(comment2);
            Comment comment3 = new Comment("风景真优美！");
            ver_2.add(comment3);
        }
        return ver_2;
    }
    public List<Comment> initHorizontal_2(){
        List<Comment> hor_2 = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            Comment comment1 = new Comment("俯瞰城市真的好美！");
            hor_2.add(comment1);
            Comment comment2 = new Comment("调色很棒！");
            hor_2.add(comment2);
            Comment comment3 = new Comment("角度不错！");
            hor_2.add(comment3);
        }
        return hor_2;
    }
}

