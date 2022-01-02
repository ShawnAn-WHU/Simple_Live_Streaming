package com.example.livestreaming;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class Animator {
    public static ScaleAnimation scaleAnim(long time, float from, float to, long offsetTime) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(from, to, from, to,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setStartOffset(offsetTime);
        scaleAnimation.setInterpolator(new DecelerateInterpolator());
        scaleAnimation.setDuration(time);
        return scaleAnimation;
    }

    public static RotateAnimation rotateAnim(long time, int fromDegrees, float toDegrees) {
        RotateAnimation rotateAnimation = new RotateAnimation(fromDegrees, toDegrees,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(time);
        return rotateAnimation;
    }

    public static TranslateAnimation translationAnim(long time, float fromX, float toX, float fromY, float toY, long offsetTime) {
        TranslateAnimation anim = new TranslateAnimation(fromX, toX, fromY, toY);
        anim.setDuration(time);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.setStartOffset(offsetTime);
        return anim;
    }

    public static AlphaAnimation alphaAnim(float fromAlpha, float toAlpha, long duration, long offsetTime) {
        AlphaAnimation anim = new AlphaAnimation(fromAlpha, toAlpha);
        anim.setDuration(duration);
        anim.setStartOffset(offsetTime);
        return anim;
    }
}
