package com.example.livestreaming;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class CommentAdapter extends ArrayAdapter<Comment> {
    private final int resourceId;
    public CommentAdapter(Context context, int commentResourceId, List<Comment> objects){
        super(context, commentResourceId, objects);
        resourceId = commentResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Comment comment = getItem(position);
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext())
                                                .inflate(resourceId, parent, false);
        TextView textView = view.findViewById(R.id.comment_item);
        textView.setText(comment.getText());
        return view;
    }
}
