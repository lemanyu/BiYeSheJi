package com.zhaogui.biyesheji.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseFragment;
import com.zhaogui.biyesheji.base.BaseFragmentPager;
import com.zhaogui.biyesheji.pager.JokePager;
import com.zhaogui.biyesheji.pager.PicturesPager;
import com.zhaogui.biyesheji.view.ScaleTransitionPagerTitleView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 搞笑段子页面
 */

public class FunnyFragment extends BaseFragment {


    Unbinder unbinder;
    @BindView(R.id.mic_funny)
    MagicIndicator micFunny;
    @BindView(R.id.vp_funny)
    ViewPager vpFunny;
    private String[] typesCN = {"笑话", "趣图"};
    private ArrayList<BaseFragmentPager> fragmentList;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_funny, null);
        return view;
    }


    @Override
    protected void initData() {
        micFunny.setBackgroundColor(Color.WHITE);
        CommonNavigator navigator = new CommonNavigator(mActivity);
        navigator.setAdjustMode(true);
        navigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return typesCN.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int i) {
                SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                simplePagerTitleView.setText(typesCN[i]);
                simplePagerTitleView.setTextSize(20);
                simplePagerTitleView.setNormalColor(Color.parseColor("#616161"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#FF0000"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vpFunny.setCurrentItem(i);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(1.6f));
                indicator.setYOffset(UIUtil.dip2px(context, 39));
                indicator.setLineHeight(UIUtil.dip2px(context, 1));
                indicator.setColors(Color.parseColor("#FF0000"));
                return indicator;
            }

            @Override
            public float getTitleWeight(Context context, int index) {
                if (index == 0) {
                    return 2.0f;
                } else {
                    return 1.5f;
                }
            }
        });
        micFunny.setNavigator(navigator);
        ViewPagerHelper.bind(micFunny,vpFunny);
        initFragment();
        vpFunny.setAdapter(new Myadapter(mActivity.getSupportFragmentManager(),fragmentList));
    }

    @Override
    protected void initListener() {

    }

    private void initFragment() {
        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        JokePager jfp = new JokePager();
        PicturesPager pfp = new PicturesPager();
        fragmentList.add(jfp);
        fragmentList.add(pfp);
    }

    class Myadapter extends FragmentPagerAdapter {
        private final List<BaseFragmentPager> list;

        public Myadapter(FragmentManager fm, List<BaseFragmentPager> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
