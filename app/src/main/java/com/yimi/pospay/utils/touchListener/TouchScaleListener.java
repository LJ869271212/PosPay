package com.yimi.pospay.utils.touchListener;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;

/**
 * @author: lj
 * Date: 2019/5/6 10:14
 * Description:触摸缩小监听
 */
public class TouchScaleListener extends BaseTouchListener{
    private float fromScale = 1.0F;
    private float toScale = 0.9F;

    public TouchScaleListener() {
    }

    public TouchScaleListener(float fromScale, float toScale) {
        this.fromScale = fromScale;
        this.toScale = toScale;
    }

    public TouchScaleListener(float toScale) {
        this.toScale = toScale;
    }

    @Override
    protected void actionDown(View view) {
        scaleXY(view, fromScale, toScale);
    }

    @Override
    protected void actionUp(View view) {
        scaleXY(view, toScale, fromScale);
    }

    private void scaleXY(View object, float fromValues, float toValues) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("scaleX", fromValues, toValues);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleY", fromValues, toValues);
        ObjectAnimator objectAnim = ObjectAnimator.ofPropertyValuesHolder(object, pvhX, pvhY);
        objectAnim.setDuration(500L);
        objectAnim.start();
    }
}
