package com.example.livestreaming;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GiftAdapter extends RecyclerView.Adapter<GiftAdapter.ViewHolder> {
    private final List<List<Gift>> myGiftsList;
    private int clickNum = 0;
    private final Handler handler = new Handler();

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageButton gift_1_button;
        ImageButton gift_2_button;
        TextView gift_1_text;
        TextView gift_2_text;
        public ViewHolder(View view){
            super(view);
            gift_1_button = view.findViewById(R.id.gift_1_button);
            gift_2_button = view.findViewById(R.id.gift_2_button);
            gift_1_text = view.findViewById(R.id.gift_1_text);
            gift_2_text = view.findViewById(R.id.gift_2_text);
        }
    }
    public GiftAdapter(List<List<Gift>> giftsList){
        myGiftsList = giftsList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gift_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<Gift> gifts = myGiftsList.get(position);
        holder.gift_1_button.setImageResource(gifts.get(0).getSrc());
        holder.gift_2_button.setImageResource(gifts.get(1).getSrc());
        holder.gift_1_text.setText(gifts.get(0).getName());
        holder.gift_2_text.setText(gifts.get(1).getName());
        holder.gift_1_button.setOnClickListener(view -> {
            clickNum++;
            handler.postDelayed(() -> {
                if(clickNum == 1){
                    ViewGroup viewGroup = (ViewGroup) view.getParent().getParent().getParent().getParent();
                    ThumbView giftView = viewGroup.findViewById(R.id.gift_view);
                    ImageView giftImage = new ImageView(view.getContext());
                    giftImage.setImageResource(gifts.get(0).getSrc());
                    giftView.addView(giftImage);
                    int thumbSize = 150;
                    RelativeLayout.LayoutParams layoutParams =
                            new RelativeLayout.LayoutParams((int) (thumbSize * 1.5), (int) (thumbSize * 1.5));
                    layoutParams.leftMargin = (int) giftView.getX() + 5 * thumbSize;
                    layoutParams.topMargin = (int) giftView.getY() + (int) (7.5 * thumbSize);
                    giftImage.setLayoutParams(layoutParams);
                    giftView.playGiftAnim(giftImage);
                }
                else if(clickNum == 2){
                    ViewGroup viewGroup = (ViewGroup) view.getParent().getParent().getParent().getParent();
                    ThumbView giftView = viewGroup.findViewById(R.id.gift_view);
                    ImageView giftImage = new ImageView(view.getContext());
                    giftImage.setImageResource(gifts.get(0).getSrc());
                    giftView.addView(giftImage);
                    int thumbSize = 150;
                    RelativeLayout.LayoutParams layoutParams =
                            new RelativeLayout.LayoutParams((int) (thumbSize * 1.5), (int) (thumbSize * 1.5));
                    layoutParams.leftMargin = (int) giftView.getX() + 5 * thumbSize;
                    layoutParams.topMargin = (int) giftView.getY() + (int) (7.5 * thumbSize);
                    giftImage.setLayoutParams(layoutParams);
                    ImageView giftNum = new ImageView(view.getContext());
                    giftNum.setImageResource(R.drawable.plus2);
                    giftView.addView(giftNum);
                    int numSize = 100;
                    RelativeLayout.LayoutParams layoutParamsNum =
                            new RelativeLayout.LayoutParams((int) (numSize * 1.5), (int) (numSize * 1.5));
                    layoutParamsNum.leftMargin = (int) giftView.getX() + 5 * thumbSize + 2 * numSize;
                    layoutParamsNum.topMargin = (int) giftView.getY() + (int) (7.5 * thumbSize);
                    giftNum.setLayoutParams(layoutParamsNum);
                    giftView.playGiftAnim(giftImage);
                    giftView.playGiftAnim(giftNum);
                }
                handler.removeCallbacksAndMessages(null);
                clickNum = 0;
            }, 300);
        });
        holder.gift_2_button.setOnClickListener(view -> {
            clickNum++;
            handler.postDelayed(() -> {
                if(clickNum == 1){
                    ViewGroup viewGroup = (ViewGroup) view.getParent().getParent().getParent().getParent();
                    ThumbView giftView = viewGroup.findViewById(R.id.gift_view);
                    ImageView giftImage = new ImageView(view.getContext());
                    giftImage.setImageResource(gifts.get(1).getSrc());
                    giftView.addView(giftImage);
                    int thumbSize = 150;
                    RelativeLayout.LayoutParams layoutParams =
                            new RelativeLayout.LayoutParams((int) (thumbSize * 1.5), (int) (thumbSize * 1.5));
                    layoutParams.leftMargin = (int) giftView.getX() + 5 * thumbSize;
                    layoutParams.topMargin = (int) giftView.getY() + (int) (7.5 * thumbSize);
                    giftImage.setLayoutParams(layoutParams);
                    giftView.playGiftAnim(giftImage);
                }
                else if(clickNum == 2){
                    ViewGroup viewGroup = (ViewGroup) view.getParent().getParent().getParent().getParent();
                    ThumbView giftView = viewGroup.findViewById(R.id.gift_view);
                    ImageView giftImage = new ImageView(view.getContext());
                    giftImage.setImageResource(gifts.get(1).getSrc());
                    giftView.addView(giftImage);
                    int thumbSize = 150;
                    RelativeLayout.LayoutParams layoutParams =
                            new RelativeLayout.LayoutParams((int) (thumbSize * 1.5), (int) (thumbSize * 1.5));
                    layoutParams.leftMargin = (int) giftView.getX() + 5 * thumbSize;
                    layoutParams.topMargin = (int) giftView.getY() + (int) (7.5 * thumbSize);
                    giftImage.setLayoutParams(layoutParams);
                    ImageView giftNum = new ImageView(view.getContext());
                    giftNum.setImageResource(R.drawable.plus2);
                    giftView.addView(giftNum);
                    int numSize = 100;
                    RelativeLayout.LayoutParams layoutParamsNum =
                            new RelativeLayout.LayoutParams((int) (numSize * 1.5), (int) (numSize * 1.5));
                    layoutParamsNum.leftMargin = (int) giftView.getX() + 5 * thumbSize + 2 * numSize;
                    layoutParamsNum.topMargin = (int) giftView.getY() + (int) (7.5 * thumbSize);
                    giftNum.setLayoutParams(layoutParamsNum);
                    giftView.playGiftAnim(giftImage);
                    giftView.playGiftAnim(giftNum);
                }
                handler.removeCallbacksAndMessages(null);
                clickNum = 0;
            }, 300);
        });
    }
    @Override
    public int getItemCount() {
        return myGiftsList.size();
    }
}
