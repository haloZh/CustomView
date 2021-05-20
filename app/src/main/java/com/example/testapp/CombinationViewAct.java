package com.example.testapp;

import android.app.Activity;
import android.os.Bundle;

import com.example.testapp.view.TitleBar;

/**
 * @author zhnaghaopneg
 */
public class CombinationViewAct extends Activity {

    private TitleBar mTitleBar0;
    private TitleBar mTitleBar1;
    private TitleBar mTitleBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combination);

        mTitleBar0 = this.findViewById(R.id.title_bar_0);
        mTitleBar0.setTitle("自定义view");
        mTitleBar0.setHead(getDrawable(R.drawable.mi));

        mTitleBar1 = this.findViewById(R.id.title_bar_1);
        mTitleBar1.setBgColor(android.R.color.holo_green_light);

        mTitleBar2 = this.findViewById(R.id.title_bar_2);
        mTitleBar2.setHead(getDrawable(R.drawable.cmb_qrlogo));
    }
}
