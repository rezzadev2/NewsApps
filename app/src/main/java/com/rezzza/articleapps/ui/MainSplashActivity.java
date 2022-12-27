package com.rezzza.articleapps.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;

import com.rezzza.articleapps.ui.base.MyActivity;
import com.rezzza.articleapps.ui.category.CategoryActivity;
import com.rezzza.articleapps.R;

@SuppressLint("CustomSplashScreen")
public class MainSplashActivity extends MyActivity {

    @Override
    protected int setLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initLayout() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(mActivity, CategoryActivity.class));
            mActivity.finish();
        },2000);
    }

    @Override
    protected void initListener() {

    }
}