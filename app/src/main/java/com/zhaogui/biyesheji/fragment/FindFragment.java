package com.zhaogui.biyesheji.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.activity.BusEnquiryActivity;
import com.zhaogui.biyesheji.activity.CityListActivity;
import com.zhaogui.biyesheji.activity.ConstellationActivity;
import com.zhaogui.biyesheji.activity.MusicActivity;
import com.zhaogui.biyesheji.activity.VideoActivity;
import com.zhaogui.biyesheji.activity.WeChatActivity;
import com.zhaogui.biyesheji.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 更多发现
 */

public class FindFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.lv)
    ListView lv;
    Unbinder unbinder1;
    private ArrayList<Data> list;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_find, null);

        return view;
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        Data 景点查询 = new Data("景点查询", R.drawable.jingdian);
        Data 星座运势 = new Data("星座运势", R.drawable.xingzuo);
        Data 微信精选 = new Data("微信精选", R.drawable.wenxin);
        Data 公交车查询 = new Data("公交车查询", R.drawable.gongjiaoche);
        Data 精彩视频 = new Data("精彩视频", R.drawable.shipin);
        Data 精选音乐 = new Data("音乐轻听", R.drawable.music);
        list.add(景点查询);
        list.add(星座运势);
        list.add(微信精选);
        list.add(公交车查询);
        list.add(精彩视频);
        list.add(精选音乐);

    }
 class MyAdapter extends BaseAdapter{

     @Override
     public int getCount() {
         return list.size();
     }

     @Override
     public Object getItem(int i) {
         return null;
     }

     @Override
     public long getItemId(int i) {
         return 0;
     }

     @Override
     public View getView(int position, View view, ViewGroup viewGroup) {
         view=View.inflate(mActivity,R.layout.item_listview,null);
         TextView tv_list= view.findViewById(R.id.tv_list);
         ImageView iv_list = view.findViewById(R.id.iv_list);
         tv_list.setText(list.get(position).getTitle());
         iv_list.setBackgroundResource(list.get(position).getIcon());

         return view;
     }
 }
    @Override
    protected void initListener() {
        lv.setAdapter(new MyAdapter());
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                  switch (position){
                      case 0:
                          startActivity(new Intent(mActivity, CityListActivity.class));
                          break;
                      case 1:
                          startActivity(new Intent(mActivity, ConstellationActivity.class));
                          break;
                      case 2:
                         startActivity(new Intent(mActivity, WeChatActivity.class));
                          break;
                      case 3:
                        startActivity(new Intent(mActivity, BusEnquiryActivity.class));
                      break;
                      case 4:
                          startActivity(new Intent(mActivity,VideoActivity.class));
                          break;
                      case 5:
                          startActivity(new Intent(mActivity, MusicActivity.class));
                          break;
                  }
            }
        });
    }

    @Override
    public void onClick(View view) {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }
}
