package com.zhaogui.biyesheji.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.fragment.FindFragment;
import com.zhaogui.biyesheji.fragment.FunnyFragment;
import com.zhaogui.biyesheji.fragment.NewsFragment;
import com.zhaogui.biyesheji.fragment.PostFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {


    @BindView(R.id.fl_main)
    FrameLayout flMain;
    @BindView(R.id.rb_news)
    RadioButton rbNews;
    @BindView(R.id.rb_funny)
    RadioButton rbFunny;
    @BindView(R.id.rb_post)
    RadioButton rbPost;
    @BindView(R.id.rb_find)
    RadioButton rbFind;
    @BindView(R.id.rg_main_footer)
    RadioGroup rgMainFooter;
    private NewsFragment nf;
    private FunnyFragment ff;
    private PostFragment pf;
    private FindFragment fdf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rgMainFooter.setOnCheckedChangeListener(this);
        rbNews.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        hideAllFragment(ft);
        switch (i) {
            case R.id.rb_news:
                if (nf == null) {
                    nf = new NewsFragment();
                    ft.add(R.id.fl_main, nf);
                } else {
                    ft.show(nf);
                }
                break;
            case R.id.rb_funny:
                if (ff == null) {
                    ff = new FunnyFragment();
                    ft.add(R.id.fl_main, ff);
                } else {
                    ft.show(ff);
                }

                break;
            case R.id.rb_post:
                if (pf == null) {
                    pf = new PostFragment();
                    ft.add(R.id.fl_main, pf);
                } else {
                    ft.show(pf);
                }
                break;
            case R.id.rb_find:
                if(fdf==null){
                    fdf=new FindFragment();
                    ft.add(R.id.fl_main,fdf);
                }else{
                    ft.show(fdf);
                }
        }
        ft.commit();
    }
    private void hideAllFragment(FragmentTransaction ft) {
        if (nf != null) ft.hide(nf);
        if (ff != null) ft.hide(ff);
        if (pf != null) ft.hide(pf);
        if (fdf != null) ft.hide(fdf);
    }
}
