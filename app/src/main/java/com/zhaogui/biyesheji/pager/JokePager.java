package com.zhaogui.biyesheji.pager;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ajguan.library.EasyRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseFragmentPager;
import com.zhaogui.biyesheji.bean.JokeBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 段子
 */

public class JokePager extends BaseFragmentPager {
    @BindView(R.id.rlv_joke)
    RecyclerView rlvJoke;
    Unbinder unbinder;
    @BindView(R.id.efl)
    EasyRefreshLayout efl;
    private int flag = 1;
    private JokeBean jokeBean;
    private JokeBean flagJb;
    private MyAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.pager_joke, null);
        return view;
    }

    @Override
    protected void initData() {
        dataFormNet(flag);
        efl.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        flag++;
                        dataFormNet(flag);
                        efl.loadMoreComplete(new EasyRefreshLayout.Event() {
                            @Override
                            public void complete() {
                                if(flagJb==jokeBean){
                                    Toast.makeText(mActivity, "没有更多数据", Toast.LENGTH_SHORT).show();
                                    return;
                                }else{
                                    adapter.getData().addAll(0,jokeBean.getResult().getData());
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }, 500);
                    }
                },1000);
            }

            @Override
            public void onRefreshing() {
                      new Handler().postDelayed(new Runnable() {
                          @Override
                          public void run() {
                              dataFormNet(1);
                              if(flagJb==jokeBean){
                                  Toast.makeText(mActivity, "当前没有最新数据", Toast.LENGTH_SHORT).show();
                                  efl.refreshComplete();
                              }else{
                                  Toast.makeText(mActivity, "已经加载更多数据", Toast.LENGTH_SHORT).show();
                                  adapter.setNewData(flagJb.getResult().getData());
                                  efl.refreshComplete();
                              }
                          }
                      },3000);

            }
        });
    }

    private void dataFormNet(int flag) {
        OkGo.<String>get("http://japi.juhe.cn/joke/content/text.from").
                params("key", "7a0e449f9f62f63124d78812a6f917e0").params("page", flag)
                .params("pagesize", 20).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                jokeBean = new Gson().fromJson(response.body().toString(), JokeBean.class);
                flagJb=jokeBean;
                adapter = new MyAdapter();
                rlvJoke.setLayoutManager(new LinearLayoutManager(mActivity));
                adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                rlvJoke.setAdapter(adapter);
            }

            @Override
            public void onCacheSuccess(Response<String> response) {
                super.onCacheSuccess(response);
                jokeBean = new Gson().fromJson(response.body().toString(), JokeBean.class);
                flagJb=jokeBean;
                adapter = new MyAdapter();
                rlvJoke.setLayoutManager(new LinearLayoutManager(mActivity));
                adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                rlvJoke.setAdapter(adapter);
            }
        });
    }

    class MyAdapter extends BaseQuickAdapter<JokeBean.ResultBean.DataBean, BaseViewHolder> {

        public MyAdapter() {
            super(R.layout.item_joke, jokeBean.getResult().getData());
        }

        @Override
        protected void convert(BaseViewHolder holder, JokeBean.ResultBean.DataBean item) {
            holder.setText(R.id.tv_joke_data, item.getContent()).
                    setText(R.id.tv_joke_time, item.getUpdatetime());
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
