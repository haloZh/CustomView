package com.example.testapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * @author zhnaghaopneg
 */
public class CircleImageView extends ImageView {
    private static final String TAG = "CircleImageView";

    private Path circlePath;
    public CircleImageView(Context context) {
        this(context,null);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context,attrs,0);

    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        circlePath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //获取drawable
        Drawable drawable = getDrawable();
        if (drawable != null) {
            //计算半径和圆心
            float x = getWidth() >> 1;
            float y = getHeight() >> 1;
            float radius = Math.min(x - getPaddingLeft(), y - getPaddingTop());
            //添加圆形的path
            circlePath.addCircle(x, y, radius, Path.Direction.CW);
            canvas.save();
            //进行裁剪
            canvas.clipPath(circlePath);
            //画布上进行绘制
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
    }
}
