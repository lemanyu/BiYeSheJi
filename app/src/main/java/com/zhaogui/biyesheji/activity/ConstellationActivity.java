package com.zhaogui.biyesheji.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseActivity;
import com.zhaogui.biyesheji.fragment.Data;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

// 选择星座activity
public class ConstellationActivity extends BaseActivity {


    @BindView(R.id.lv_constell)
    ListView lvConstell;
    private ArrayList<Data> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_constellation;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        Data 白羊座 = new Data("白羊座  3.21-4.19", R.drawable.baiyang,"baiyang");
        Data 金牛座 = new Data("金牛座  4.20-5.20", R.drawable.jinniu,"jinniu");
        Data 双子座 = new Data("双子座  5.21-6.21", R.drawable.shuangzi,"shuangzi");
        Data 巨蟹座 = new Data("巨蟹座  6.22-7.22", R.drawable.juxie,"juxie");
        Data 狮子座 = new Data("狮子座  7.23-8.22", R.drawable.shizi,"shizi");
        Data 处女座 = new Data("处女座  8.23-9.22", R.drawable.chunv,"chunv");
        Data 天秤座 = new Data("天秤座  9.23-10.23", R.drawable.tiancheng,"tiancheng");
        Data 天蝎座 = new Data("天蝎座  10.24-11.22", R.drawable.tianxie,"tianxie");
        Data 射手座 = new Data("射手座  11.23-12.21", R.drawable.sheshou,"sheshou");
        Data 摩羯座 = new Data("摩羯座  12.22-1.19", R.drawable.mojie,"mojie");
        Data 水瓶座 = new Data("水瓶座  1.20-2.18", R.drawable.shuiping,"shuiping");
        Data 双鱼座 = new Data("双鱼座  2.19-3.20", R.drawable.shuangyu,"shuangyu");
        list.add(白羊座);list.add(金牛座);list.add(双子座);list.add(巨蟹座);list.add(狮子座);list.add(处女座);
        list.add(天秤座);list.add(天蝎座);list.add(射手座);list.add(摩羯座);list.add(水瓶座);list.add(双鱼座);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
         lvConstell.setAdapter(new MyAdapter());
         lvConstell.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                 Intent intent = new Intent(ConstellationActivity.this, HoroscopeActivity.class);
                 intent.putExtra("type",list.get(position).getType());
                 startActivity(intent);
             }
         });
    }
    class MyAdapter extends BaseAdapter {

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
            view=View.inflate(ConstellationActivity.this,R.layout.item_listview,null);
            TextView tv_list= view.findViewById(R.id.tv_list);
            ImageView iv_list = view.findViewById(R.id.iv_list);
            tv_list.setText(list.get(position).getTitle());
            iv_list.setBackgroundResource(list.get(position).getIcon());
            return view;
        }
    }
    @Override
    public void processClick(View v) {

    }

}
