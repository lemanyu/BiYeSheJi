package com.zhaogui.biyesheji.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseActivity;
import com.zhaogui.biyesheji.bean.CityBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityListActivity extends BaseActivity {


    @BindView(R.id.back)
    Button back;
    @BindView(R.id.elv)
    ExpandableListView elv;
    private ArrayList<CityBean.ResultBean> list;//省份
    private int flag=-1;
    private ArrayList<CityBean.ResultBean> clist;
    private ArrayList<String> cityId;
    private ArrayList<String> provinceId;
    //private HashMap<String, List<String>> map;
    private HashMap<CityBean.ResultBean, List<CityBean.ResultBean>> map;

    @Override
    public int getLayoutId() {
        return R.layout.activity_city_list;
    }

    @Override
    public void initView() {
        int width = getWindowManager().getDefaultDisplay().getWidth();
        elv.setIndicatorBounds(width-30, width-10);
        list = new ArrayList<>();
    }

    @Override
    public void initData() {
        dataFromNet();

    }

    private void dataFromNet() {
        OkGo.<String>get("http://apis.haoservice.com/lifeservice/travel/cityList?key=b836e20773d5418a9f8d656039cf6c34").
                execute(new StringCallback() {
                    @Override
                    public void onSuccess(final Response<String> response) {
                        final CityBean cityBean = new Gson().fromJson(response.body().toString(), CityBean.class);
                        initChild(cityBean.getResult());//省份中的城市
                        elv.setAdapter(new Myadapter());
                        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                            @Override
                            public boolean onChildClick(ExpandableListView expandableListView, View view, int position, int i1, long l) {
                                Toast.makeText(CityListActivity.this,map.get(list.get(position)).get(i1).getCityId()+"bbbb"
                                        +map.get(list.get(position)).get(i1).getProvinceId()+"cccc", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(CityListActivity.this,ScenicListActivity.class);
                                intent.putExtra("pic",map.get(list.get(position)).get(i1).getProvinceId());
                                intent.putExtra("id",map.get(list.get(position)).get(i1).getCityId());
                                startActivity(intent);
                                return true;
                            }
                        });
                    }
                });
    }

    private void initChild(List<CityBean.ResultBean> result) {
        cityId = new ArrayList<>();
        provinceId = new ArrayList<>();
        //城市
        clist = null;
        map = new HashMap<>();
        for (int i = 0; i < result.size(); i++) {
            String pid=result.get(i).getProvinceId();
            if(result.get(i).getCityId().equals(result.get(i).getProvinceId())){

                list.add(result.get(i));
                flag++;
                clist =new ArrayList<>();
                continue;
            }else {
                cityId.add(result.get(i).getCityId());
                provinceId.add(result.get(i).getProvinceId());
                clist.add(result.get(i));
            }
             if(!pid.equals(result.get(i).getProvinceId())){
             }else {
                 map.put(list.get(flag), clist);
             }

        }
    }
    class Myadapter extends BaseExpandableListAdapter{

            @Override
            public int getGroupCount() {
                return list.size();
            }

            @Override
            public int getChildrenCount(int i) {
                return map.get(list.get(i)).size();
            }

            @Override
            public List<CityBean.ResultBean> getGroup(int i) {

                return map.get(list.get(i));
            }

            @Override
            public CityBean.ResultBean getChild(int i, int i1) {

                return map.get(list.get(i)).get(i1);
            }

            @Override
            public long getGroupId(int i) {
                return i;
            }

            @Override
            public long getChildId(int i, int i1) {
                return i1;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                if (view == null) {
                    LayoutInflater inflater = (LayoutInflater) CityListActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.item_father, null);
                }
                view.setTag(R.layout.item_father, i);
                view.setTag(R.layout.item_son, -1);
                TextView tv_father = view.findViewById(R.id.tv_father);
                tv_father.setText(list.get(i).getCityName());
                return view;
            }

            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                if (view == null) {
                    LayoutInflater inflater = (LayoutInflater) CityListActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.item_son, null);
                }
                view.setTag(R.layout.item_father, i);
                view.setTag(R.layout.item_son, i1);
                TextView tv_son = view.findViewById(R.id.tv_son);
                tv_son.setText(map.get(list.get(i)).get(i1).getCityName());
                return view;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }
        }
    @Override
    public void initListener() {

    }

    @Override
    public void processClick(View v) {

    }


}
