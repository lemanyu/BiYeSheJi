package com.zhaogui.biyesheji.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.squareup.picasso.Picasso;
import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseActivity;
import com.zhaogui.biyesheji.bean.WeChatBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 微信精选页面
 */

public class WeChatActivity extends BaseActivity {

    @BindView(R.id.back)
    Button back;
    @BindView(R.id.rlv_wechat)
    RecyclerView rlvWechat;
    private WeChatBean chatBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_wechat;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        OkGo.<String>get("http://route.showapi.com/181-1").params("showapi_appid", "44333").
                params("showapi_sign", "f8fc97c5902b48e0ac7552c799514016").
                params("num", "50").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                chatBean = new Gson().fromJson(response.body().toString(), WeChatBean.class);
                Myadapter myadapter = new Myadapter();
                rlvWechat.setLayoutManager(new LinearLayoutManager(WeChatActivity.this));
                rlvWechat.setAdapter(myadapter);
                myadapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                myadapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent = new Intent(WeChatActivity.this, ArticleActivity.class);
                        intent.putExtra("url",chatBean.getShowapi_res_body().getNewslist().get(position).getUrl());
                        intent.putExtra("title",chatBean.getShowapi_res_body().getNewslist().get(position).getDescription());
                        intent.putExtra("pic",chatBean.getShowapi_res_body().getNewslist().get(position).getPicUrl());
                        startActivity(intent);
                    }
                });


            }
        });
    }

    @Override
    public void initListener() {

    }

    @Override
    public void processClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    class Myadapter extends BaseQuickAdapter<WeChatBean.ShowapiResBodyBean.NewslistBean, BaseViewHolder> {

        public Myadapter() {
            super(R.layout.item_wechat, chatBean.getShowapi_res_body().getNewslist());
        }

        @Override
        protected void convert(BaseViewHolder holder, WeChatBean.ShowapiResBodyBean.NewslistBean item) {
            holder.setText(R.id.tv_wechat_title, item.getTitle()).setText(R.id.tv_wechat_description, item.getDescription())
                    .setText(R.id.tv_wechat_ctime, item.getCtime());
            Picasso.with(WeChatActivity.this).load(item.getPicUrl()).into((ImageView) holder.getView(R.id.iv_wechat_pic));
        }
    }
}
