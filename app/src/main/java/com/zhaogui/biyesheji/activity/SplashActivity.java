package com.zhaogui.biyesheji.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;

import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseActivity;

/**
 * Created by gui on 2017/9/6.
 */

public class SplashActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               startActivity(new Intent(SplashActivity.this,WelcomeActivity.class));
               finish();
           }
       },3000);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void processClick(View v) {

    }
}
