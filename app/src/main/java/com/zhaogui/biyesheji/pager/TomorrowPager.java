package com.zhaogui.biyesheji.pager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.squareup.picasso.Picasso;
import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.activity.HistoryActivity;
import com.zhaogui.biyesheji.base.BaseFragmentPager;
import com.zhaogui.biyesheji.bean.PostBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by gui on 2017/8/17.
 */

public class TomorrowPager extends BaseFragmentPager {
    @BindView(R.id.rlv_tomorrow)
    RecyclerView rlvTomorrow;
    Unbinder unbinder;
    private int month;
    private int day;
    private PostBean postBean;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.pager_tomorrow, null);
        return view;
    }

    @Override
    protected void initData() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sf.parse(sf.format(new Date(System.currentTimeMillis())));
            Calendar cd = Calendar.getInstance();
            cd.setTime(date);
            cd.add(Calendar.DAY_OF_MONTH,1);
            month = cd.get(Calendar.MONTH) + 1;
            day = cd.get(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dataFromNext(month, day);
    }

    private void dataFromNext(int month, int day) {
        OkGo.<String>get("http://apis.haoservice.com/lifeservice/toh").
                params("month", month).params("day", day).params("key", "d6efc7c5164e4110a9d1acb55e6831f7").
                execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        postBean = new Gson().fromJson(response.body().toString(), PostBean.class);
                        rlvTomorrow.setLayoutManager(new LinearLayoutManager(mActivity));
                        MyAdpater adapter = new MyAdpater();
                        rlvTomorrow.setAdapter(adapter);
                        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                Intent intent = new Intent(mActivity, HistoryActivity.class);
                                intent.putExtra("id",postBean.getResult().get(position).getId());
                                Log.e("bbbbbbbbbbbbbb",postBean.getResult().get(position).getId()+"");
                                intent.putExtra("title",postBean.getResult().get(position).getTitle());
                                startActivity(intent);
                            }
                        });
                    }

                    @Override
                    public void onCacheSuccess(Response<String> response) {
                        postBean = new Gson().fromJson(response.body().toString(), PostBean.class);
                        rlvTomorrow.setLayoutManager(new LinearLayoutManager(mActivity));
                        MyAdpater adapter = new MyAdpater();
                        rlvTomorrow.setAdapter(adapter);
                        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                Intent intent = new Intent(mActivity, HistoryActivity.class);
                                intent.putExtra("id",postBean.getResult().get(position).getId());
                                Log.e("bbbbbbbbbbbbbb",postBean.getResult().get(position).getId()+"");
                                intent.putExtra("title",postBean.getResult().get(position).getTitle());
                                startActivity(intent);
                            }
                        });
                    }
                });
    }
    class MyAdpater extends BaseQuickAdapter<PostBean.ResultBean, BaseViewHolder> {

        public MyAdpater() {
            super(R.layout.item_tommorrow, postBean.getResult());
        }

        @Override
        protected void convert(BaseViewHolder holder, PostBean.ResultBean item) {
            holder.setText(R.id.tv_tommor_title,item.getTitle()).setText(R.id.tv_tommor_data,item.getDes())
                    .setText(R.id.tv_tommor_lunar,item.getLunar()).setText(R.id.tv_tommor_year,item.getYear()+"年").
                    setText(R.id.tv_tommor_month,item.getMonth()+"月").setText(R.id.tv_tommor_day,item.getDay()+"日");
            if(item.getPic()!=null&&!item.getPic().isEmpty()){
                Picasso.with(mActivity).load(item.getPic()).into((ImageView) holder.getView(R.id.iv_tommor_img));
            }else{
                Picasso.with(mActivity).load(R.drawable.ic_wrong).into((ImageView) holder.getView(R.id.iv_tommor_img));
            }

        }
    }
    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View view) {

    }

}
