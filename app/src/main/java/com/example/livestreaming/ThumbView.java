package com.example.livestreaming;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.Random;

public class ThumbView extends RelativeLayout {
    private GestureDetector gestureDetector;
    public static int thumbStyle = 0;
    private final int[] angles = new int[]{-30, 0, 30};

    public ThumbView(Context context) {
        super(context);
        init();
    }
    public ThumbView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init() {
        gestureDetector = new GestureDetector(getContext(), new MyGestureDetectorListener());
        setOnTouchListener((v, event) -> {
            gestureDetector.onTouchEvent(event);
            return true;
        });
    }

    private class MyGestureDetectorListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            addImageView(e);
            ViewGroup viewGroup = (ViewGroup) getParent();
            ImageButton thumbUp = viewGroup.findViewById(R.id.thumb_up);
            thumbUp.setImageResource(R.drawable.thumb_anim);
            thumbStyle = 1;
            return true;
        }
    }

    private void addImageView(MotionEvent e) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.thumb_anim);
        addView(imageView);
        int thumbSize = 150;
        RelativeLayout.LayoutParams layoutParams = new LayoutParams(thumbSize, thumbSize);
        layoutParams.leftMargin = (int) e.getX() - thumbSize / 2;
        layoutParams.topMargin = (int) e.getY() - thumbSize / 2;
        imageView.setLayoutParams(layoutParams);
        playAnim(imageView);
    }

    private void playAnim(final ImageView imageView) {
        AnimationSet animationSet = new AnimationSet(true);
        int degrees = angles[new Random().nextInt(3)];
        animationSet.addAnimation(Animator.rotateAnim(0, 0, degrees));
        animationSet.addAnimation(Animator.scaleAnim(100, 2f, 1f, 0));
        animationSet.addAnimation(Animator.alphaAnim(0, 1, 100, 0));
        animationSet.addAnimation(Animator.scaleAnim(500, 1f, 1.8f, 300));
        animationSet.addAnimation(Animator.alphaAnim(1f, 0, 500, 300));
        animationSet.addAnimation(Animator.translationAnim(500, 0, 0, 0, -400, 300));
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().post(() -> removeView(imageView));
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        imageView.startAnimation(animationSet);
    }
    public void playGiftAnim(final ImageView imageView) {
        AnimationSet animationSet = new AnimationSet(true);
        int degree = 0;
        animationSet.addAnimation(Animator.rotateAnim(0, 0, degree));
        animationSet.addAnimation(Animator.scaleAnim(100, 2f, 1f, 0));
        animationSet.addAnimation(Animator.alphaAnim(0, 1, 100, 0));
        animationSet.addAnimation(Animator.scaleAnim(500, 1f, 1.3f, 300));
        animationSet.addAnimation(Animator.alphaAnim(1f, 0, 500, 300));
        animationSet.addAnimation(Animator.translationAnim(500, 0, 0, 0, -400, 300));
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().post(() -> removeView(imageView));
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        imageView.startAnimation(animationSet);
    }
}
