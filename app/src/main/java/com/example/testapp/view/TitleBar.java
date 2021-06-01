package com.example.testapp.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.testapp.CustomViewAct;
import com.example.testapp.R;

/**
 * @author zhnaghaopneg
 */
public class TitleBar extends FrameLayout implements View.OnClickListener {
    private static final String TAG = "TitleBar";

    boolean isShowHead;
    boolean isShowTitle;
    boolean isShowBack;
    int color;

    private RelativeLayout rlTitleBar;
    private TextView tvTitle;
    private CircleImageView civHead;
    private RelativeLayout rlSearch;
    private ImageView ivBack;
    private Context mContext;


    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;

        initView(context);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.combination);
        isShowHead = ta.getBoolean(R.styleable.combination_showHead, false);
        isShowTitle = ta.getBoolean(R.styleable.combination_showTitle, true);
        isShowBack = ta.getBoolean(R.styleable.combination_showBack, true);
        color = ta.getColor(R.styleable.combination_bgColor,getResources().getColor(android.R.color.holo_orange_light));
        ta.recycle();  //注意回收
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.title_bar, this);
        rlTitleBar = this.findViewById(R.id.rl_title_bar);
        tvTitle = this.findViewById(R.id.tv_title);
        civHead = this.findViewById(R.id.civ_head);
        rlSearch = this.findViewById(R.id.rl_search);
        ivBack = this.findViewById(R.id.iv_back);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        rlTitleBar.setBackgroundColor(color);
        civHead.setVisibility(isShowHead ? View.VISIBLE : View.GONE);
        ivBack.setVisibility(isShowBack ? VISIBLE : GONE);
        if (isShowTitle) {
            tvTitle.setVisibility(VISIBLE);
        } else {
            tvTitle.setVisibility(GONE);
            ViewStub stub = (ViewStub) this.findViewById(R.id.vs_search);
            stub.setVisibility(VISIBLE);
        }

        ivBack.setOnClickListener(this);
        civHead.setOnClickListener(this);
    }

    /***
     * 设置title文字
     * @param title
     */
    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    /***
     * 设置头像
     * @param drawable
     */
    public void setHead(Drawable drawable) {
        civHead.setImageDrawable(drawable);
    }

    /***
     * 设置背景颜色
     * @param color
     */
    public void setBgColor(int color) {
        rlTitleBar.setBackgroundColor(getResources().getColor(color));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                ((Activity)mContext).finish();
                break;
            case R.id.civ_head:
                Intent intent = new Intent(mContext, CustomViewAct.class);
                mContext.startActivity(intent);
                break;
            default:
                break;
        }
    }
}
