package com.zhaogui.biyesheji.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.zhaogui.biyesheji.R;

/**
 * Created by gui on 2017/9/6.
 */

public class WelcomeActivity extends AppIntro2 {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("简阅属于生活App","简单生活、阅读精彩", R.mipmap.jianyue, Color.parseColor("#930d13")));
        addSlide(AppIntroFragment.newInstance("主推新闻、笑话、历史上今天","实时新闻、搞笑段子、了解过去", R.mipmap.jianyue, Color.parseColor("#930d13")));
        addSlide(AppIntroFragment.newInstance("更多发现有你喜欢的","更多功能完善。。。", R.mipmap.jianyue, Color.parseColor("#930d13")));
        setBarColor(Color.parseColor("#930d13"));
        showSkipButton(true);
        setProgressButtonEnabled(true);
    }
    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }

}