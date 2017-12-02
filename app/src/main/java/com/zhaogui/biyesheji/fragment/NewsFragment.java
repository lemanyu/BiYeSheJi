package com.zhaogui.biyesheji.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseFragment;
import com.zhaogui.biyesheji.pager.NewsPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/**
 * 新闻精选页面
 */

public class NewsFragment extends BaseFragment {

    private String[]  types;         //顶部 tab 英文内容数组
    private String[]  typesCN;       //顶部 tab 中文内容数组
    private View view;
    private ViewPager vpNews;
    private MagicIndicator mic;

    @Override
    public View initView() {
        view = View.inflate(mActivity,R.layout.fragment_news,null   );
        vpNews = view.findViewById(R.id.vp_news);
        mic = view.findViewById(R.id.mic);
        types = getResources().getStringArray(R.array.news_type_en);
        typesCN = getResources().getStringArray(R.array.news_type_cn);
        initViewPager();
        initTop();
        vpNews.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mic.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                mic.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mic.onPageScrollStateChanged(state);
            }
        });
        return view;
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initListener() {

    }

    private void initViewPager() {
        Myadapter adapter = new Myadapter(mActivity.getSupportFragmentManager());
        vpNews.setAdapter(adapter);
    }

    private void initTop() {
        CommonNavigator cn = new CommonNavigator(mActivity);
        cn.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {

                return types.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int i) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView
                        = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.BLACK);
                colorTransitionPagerTitleView.setSelectedColor(Color.RED);
                colorTransitionPagerTitleView.setText(typesCN[i]);
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        vpNews.setCurrentItem(i);
                    }
                });
                return colorTransitionPagerTitleView;

            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                return indicator;
            }
        });
        mic.setNavigator(cn);
        ViewPagerHelper.bind(mic, vpNews);

    }


    class Myadapter extends FragmentStatePagerAdapter{

        public Myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return new NewsPager(
                    types[position]);
        }

        @Override
        public int getCount() {
            return types.length;
        }

    }
}
