package com.zhaogui.biyesheji.pager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.zhaogui.biyesheji.activity.NewsAcitivity;
import com.zhaogui.biyesheji.base.BaseFragmentPager;
import com.zhaogui.biyesheji.bean.NewsDataBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by gui on 2017/8/15.
 */

public class NewsPager extends BaseFragmentPager {

    Unbinder unbinder;
    @BindView(R.id.rlv_news)
    RecyclerView rlvNews;
    private String type;
    private NewsDataBean newsDataBean;
    private Myadapter adapter;

    public NewsPager(String type) {

        this.type = type;
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.item_news, null);
        return view;
    }

    @Override
    protected void initData() {

        dataFromNet();//从网络获取数据

    }

    private void dataFromNet() {
        OkGo.<String>get("http://v.juhe.cn/toutiao/index?").
                params("type", type).params("key", "9f65fdef59082ac45465665a561c056d").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                newsDataBean = gson.fromJson(response.body().toString(), NewsDataBean.class);
                adapter = new Myadapter();
                adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
                rlvNews.setLayoutManager(new LinearLayoutManager(mActivity));
                rlvNews.setAdapter(adapter);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent = new Intent(mActivity, NewsAcitivity.class);
                        intent.putExtra("url",newsDataBean.getResult().getData().get(position).getUrl());
                        intent.putExtra("text",newsDataBean.getResult().getData().get(position).getAuthor_name());
                        intent.putExtra("pic",newsDataBean.getResult().getData().get(position).getThumbnail_pic_s());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onCacheSuccess(Response<String> response) {
                super.onCacheSuccess(response);
                Gson gson = new Gson();
                newsDataBean = gson.fromJson(response.body().toString(), NewsDataBean.class);
                adapter = new Myadapter();
                adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
                rlvNews.setLayoutManager(new LinearLayoutManager(mActivity));
                rlvNews.setAdapter(adapter);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent = new Intent(mActivity, NewsAcitivity.class);
                        intent.putExtra("url",newsDataBean.getResult().getData().get(position).getUrl());
                        intent.putExtra("text",newsDataBean.getResult().getData().get(position).getAuthor_name());
                        startActivity(intent);
                    }
                });

            }
        });

    }

    class Myadapter extends BaseQuickAdapter<NewsDataBean.ResultBean.DataBean, BaseViewHolder> {

        public Myadapter() {
            super(R.layout.item_recycleview, newsDataBean.getResult().getData());
        }

        @Override
        protected void convert(BaseViewHolder holder, NewsDataBean.ResultBean.DataBean item) {
            holder.setText(R.id.tv_news_title, item.getTitle()).
                    setText(R.id.tv_news_from, item.getAuthor_name()).
                    setText(R.id.tv_news_time, item.getDate());
            Picasso.with(mActivity).load(item.getThumbnail_pic_s()).into((ImageView) holder.getView(R.id.iv_news_img));
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
