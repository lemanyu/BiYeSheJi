package com.zhaogui.biyesheji.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseFragment;
import com.zhaogui.biyesheji.base.BaseFragmentPager;
import com.zhaogui.biyesheji.pager.TodayPager;
import com.zhaogui.biyesheji.pager.TomorrowPager;
import com.zhaogui.biyesheji.pager.YesterdayPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.WrapPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 历史上的今日
 */

public class PostFragment extends BaseFragment {

    @BindView(R.id.mic_post)
    MagicIndicator micPost;
    @BindView(R.id.vp_post)
    ViewPager vpPost;
    Unbinder unbinder;
    private ArrayList<BaseFragmentPager> fragmentList;
     private String[] type={"历史昨日","历史今日","历史明日"};
    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_post, null);

        return view;
    }

    @Override
    protected void initData() {
        CommonNavigator navigator = new CommonNavigator(mActivity);
        navigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {

                return type.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int i) {
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
                simplePagerTitleView.setText(type[i]);
                simplePagerTitleView.setNormalColor(Color.parseColor("#333333"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#FF0000"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vpPost.setCurrentItem(i);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                WrapPagerIndicator indicator = new WrapPagerIndicator(context);
                indicator.setFillColor(Color.parseColor("#ebe4e3"));
                return indicator;
            }
        });
        micPost.setNavigator(navigator);
        ViewPagerHelper.bind(micPost,vpPost);
        initFragment();
        vpPost.setAdapter(new MyAdapter(mActivity.getSupportFragmentManager(),fragmentList));
        vpPost.setCurrentItem(1);
    }

    private void initFragment() {
      if(fragmentList==null){
          fragmentList=new ArrayList<>();
      }
      fragmentList.add(new YesterdayPager());
      fragmentList.add(new TodayPager());
       fragmentList.add(new TomorrowPager());
    }

    @Override
    protected void initListener() {

    }

   class MyAdapter extends FragmentPagerAdapter{

       private final List<BaseFragmentPager> list;

       public MyAdapter(FragmentManager fm, List<BaseFragmentPager> list) {
           super(fm);
            this.list=list;
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
