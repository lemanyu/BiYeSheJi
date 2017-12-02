package com.zhaogui.biyesheji.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ajguan.library.EasyRefreshLayout;
import com.ajguan.library.LoadModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.squareup.picasso.Picasso;
import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseActivity;
import com.zhaogui.biyesheji.bean.ScenicBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 景点列表
 */

public class ScenicListActivity extends BaseActivity {
    @BindView(R.id.rlv_scenic)
    RecyclerView rlvScenic;
    @BindView(R.id.erl_scenic)
    EasyRefreshLayout erlScenic;
    @BindView(R.id.back)
    Button back;
    private String pic;
    private String id;
    private int flag=1;
    private ScenicBean scenicBean;
    private ScenicBean flagBean;
    private Myadapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_sceniclist;
    }

    @Override
    public void initView() {
        erlScenic.setLoadMoreModel(LoadModel.COMMON_MODEL);
        pic = getIntent().getStringExtra("pic");
        id = getIntent().getStringExtra("id");
    }

    @Override
    public void initData() {
          dataFromNet(flag);
          erlScenic.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
              @Override
              public void onLoadMore() {
                  new Handler().postDelayed(new Runnable() {
                      @Override
                      public void run() {
                         flag++;
                          dataFromNet(flag);
                          erlScenic.loadMoreComplete(new EasyRefreshLayout.Event() {
                              @Override
                              public void complete() {
                                  if(flagBean!=scenicBean||flagBean==null){
                                      Toast.makeText(ScenicListActivity.this, "没有更多数据", Toast.LENGTH_SHORT).show();
                                      return;
                                  }else{
                                      adapter.getData().addAll(0,scenicBean.getResult());
                                      adapter.notifyDataSetChanged();
                                  }
                              }
                          });
                      }
                  },1000);
              }

              @Override
              public void onRefreshing() {
                  new Handler().postDelayed(new Runnable() {
                      @Override
                      public void run() {
                          dataFromNet(1);
                          adapter.setNewData(scenicBean.getResult());
                          erlScenic.refreshComplete();

                      }
                  },2000);

              }
          });
    }

    private void dataFromNet(int flag) {
        OkGo.<String>get("http://apis.haoservice.com/lifeservice/travel/scenery").
                params("pid",pic).params("cid",id).params("page",flag).params("key","b836e20773d5418a9f8d656039cf6c34").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                scenicBean = new Gson().fromJson(response.body().toString(), ScenicBean.class);
                flagBean=scenicBean;
                adapter = new Myadapter();
                rlvScenic.setLayoutManager(new LinearLayoutManager(ScenicListActivity.this));
                rlvScenic.setAdapter(adapter);
                adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                          //跳转到更多详情页面
                        Intent intent = new Intent(ScenicListActivity.this, MoreDetailsActivity.class);
                        intent.putExtra("sid",scenicBean.getResult().get(position).getSid());
                        intent.putExtra("title",scenicBean.getResult().get(position).getTitle());
                        startActivity(intent);
                    }
                });
                adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                        //跳转到在线购票
                        Intent intent = new Intent(ScenicListActivity.this,OnlinePurchaseActivity.class);
                        intent.putExtra("url",scenicBean.getResult().get(position).getUrl());
                        startActivity(intent);
                    }
                });
            }
        });
    }

    @Override
    public void initListener() {

    }
    class Myadapter extends BaseQuickAdapter<ScenicBean.ResultBean,BaseViewHolder>{

        public Myadapter() {
            super(R.layout.item_scenic, scenicBean.getResult());
        }

        @Override
        protected void convert(BaseViewHolder holder, ScenicBean.ResultBean item) {
                  holder.setText(R.id.tv_scenic_title,item.getTitle()).
                          setText(R.id.tv_scenic_address,item.getAddress()).
                          setText(R.id.tv_scenic_grade,"国家等级："+item.getGrade()).
                          setText(R.id.tv_scenic_price_min,"当前价格"+item.getPrice_min()).addOnClickListener(R.id.bt_scenic);
            if(item.getImgurl()!=null&&!item.getImgurl().isEmpty()){
                Picasso.with(ScenicListActivity.this).load(item.getImgurl()).into((ImageView) holder.getView(R.id.iv_scenic));
            }else{
                Picasso.with(ScenicListActivity.this).load(R.drawable.ic_wrong).into((ImageView) holder.getView(R.id.iv_scenic));
            }
        }
    }
    @Override
    public void processClick(View v) {

    }

}
