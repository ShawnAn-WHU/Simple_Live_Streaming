package com.example.livestreaming;

import android.content.Context;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
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
        holder.gift.setOnClickListener(view -> {
            View popupView = LayoutInflater.from(view.getContext())
                    .inflate(R.layout.gift_popup, null, false);
            PopupWindow popupWindow = new PopupWindow(popupView,
                                                      ViewGroup.LayoutParams.MATCH_PARENT,
                                                      ViewGroup.LayoutParams.MATCH_PARENT);
            RecyclerView recyclerView = popupView.findViewById(R.id.gift_recycler);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(popupView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            GiftAdapter giftAdapter = new GiftAdapter(initGifts());
            recyclerView.setAdapter(giftAdapter);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setFocusable(true);
            popupWindow.setTouchable(true);
            View rootView = LayoutInflater.from(view.getContext())
                    .inflate(R.layout.video_item, null);
            popupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
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
                commentAdapter.notifyDataSetChanged();
                holder.commentText.setText("");
                holder.commentText.clearFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) view.getContext()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
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
    public List<List<Gift>> initGifts(){
        List<List<Gift>> giftsList = new ArrayList<>();
        List<Gift> giftList_1 = new ArrayList<>();
        List<Gift> giftList_2 = new ArrayList<>();
        List<Gift> giftList_3 = new ArrayList<>();
        List<Gift> giftList_4 = new ArrayList<>();
        Gift gift = new Gift("蛋糕", R.drawable.cake);
        giftList_1.add(gift);
        gift = new Gift("电话", R.drawable.call);
        giftList_1.add(gift);
        giftsList.add(giftList_1);
        gift = new Gift("加餐", R.drawable.food);
        giftList_2.add(gift);
        gift = new Gift("音乐", R.drawable.music);
        giftList_2.add(gift);
        giftsList.add(giftList_2);
        gift = new Gift("飞机", R.drawable.plane);
        giftList_3.add(gift);
        gift = new Gift("星星", R.drawable.star);
        giftList_3.add(gift);
        giftsList.add(giftList_3);
        gift = new Gift("太阳", R.drawable.sun);
        giftList_4.add(gift);
        gift = new Gift("充电", R.drawable.battery);
        giftList_4.add(gift);
        giftsList.add(giftList_4);
        return giftsList;
    }
}

